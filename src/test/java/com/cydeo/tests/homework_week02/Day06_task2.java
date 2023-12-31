package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day06_task2 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void task2() throws InterruptedException {
        //3. Click to “Click for JS Confirm” button
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to Cancel button from the alert
        alert.dismiss();

        //5. Verify “You clicked: Cancel” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText = "You clicked: Cancel";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is not as expected!!!");
    }

    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }
}
