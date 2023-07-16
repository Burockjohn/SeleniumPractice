package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1 {

    // TC#1: Practice page Login test


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");
    }

    @Test
    public void testCase1() {
        // 3. Enter username: "tomsmith"
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        loginButton.click();

        // 6. Verify text displayed on page
        // Expected: "You logged into a secure area!"
        WebElement displayedMessage = driver.findElement(By.cssSelector("div#flash"));
        // --> //div[normalize-space(text())='You logged into a secure area!']

        String actualMessage = displayedMessage.getText();
        //actualMessage = actualMessage.substring(0,actualMessage.indexOf("\n"));


        System.out.println(actualMessage);
        String expectedMessage = "You logged into a secure area!";

        //Assert.assertEquals(actualMessage, expectedMessage, "the messages are different");
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
