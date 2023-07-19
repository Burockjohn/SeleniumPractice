package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ex1 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testBoxLogOn() {

        driver.get("https://demoqa.com/text-box");

        WebElement nameSection = driver.findElement(By.cssSelector("input#userName"));
        nameSection.sendKeys("Burak");

        WebElement emailSection = driver.findElement(By.cssSelector("input#userEmail"));
        emailSection.sendKeys("brkcn@tt.com");

        WebElement currentAddressSection = driver.findElement(By.cssSelector("textarea#currentAddress"));
        currentAddressSection.sendKeys("ANGARA");

        WebElement permanentAddressSection = driver.findElement(By.cssSelector("textarea#permanentAddress"));
        permanentAddressSection.sendKeys("WORLD");

        WebElement submitButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        submitButton.click();

        WebElement output = driver.findElement(By.cssSelector("div.border"));
        System.out.println(output.getText());

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
}
