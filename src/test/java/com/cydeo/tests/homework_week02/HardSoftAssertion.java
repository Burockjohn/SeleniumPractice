package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardSoftAssertion  {

    // TC#1: Practice page Login test
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username: "tomsmith"
    // 4. Enter password: "SuperSecretPassword"
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "You logged into a secure area!"

    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        // TC: Practice page Login test
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/login");
    }

    @Test
    public void login_test_with_hard_assertion() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        Assert.assertEquals(driver.getTitle(),"Secure Are");

        WebElement resultText = driver.findElement(By.xpath("//div[normalize-space(text()) ='You logged into a secure area!']"));

        String actualResulText = resultText.getText();
        String expectedResultText = "You logged into a secure area!!!";

        Assert.assertTrue(actualResulText.contains(expectedResultText));

    }

    @Test
    public void login_test_with_soft_assertion() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement loginBtn1 = driver.findElement(By.id("wooden_spoon"));
        loginBtn1.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Secure Are");

        WebElement resultText = driver.findElement(By.xpath("//div[normalize-space(text()) ='You logged into a secure area!']"));

        String actualResulText = resultText.getText();
        String expectedResultText = "You logged into a secure area!!!";

        softAssert.assertTrue(actualResulText.contains(expectedResultText));

        softAssert.assertAll();

    }




















//    // TC#1: Registration Form Page Testing
//    // 1. Open Chrome browser
//    // 2. Go to https://practice.cydeo.com/registration_form
//    // 3. Verify title is as expected:
//    // Expected: "Registration Form"
//    // 4. Select "SDET" from Job title dropdown
//    // 5. Verify "SDET" is selected
//
//
//    @Test
//    public void registrationFormPageTestHard(){
//        // 3. Verify title is as expected:
//        // Expected: "Registration Form"
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Registration For";
//        Assert.assertEquals(actualTitle,expectedTitle,"Title verification is not passed!");
//
//        System.out.println("After hard assertion failed!");
//
//        // 4. Select "SDET" from Job title dropdown
//        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
//        jobTitleSelect.selectByVisibleText("SDET");
//
//        // 5. Verify "SDET" is selected
//        Assert.assertTrue(jobTitleSelect.getFirstSelectedOption().getText().equals("SDET"));
//
//    }
//
//    @Test
//    public void registrationFormPageTestSoft(){
//        // 3. Verify title is as expected:
//        // Expected: "Registration Form"
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Registration For";
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualTitle,expectedTitle,"Title verification is not passed!");
//
//        System.out.println("After soft assertion failed!");
//
//        // 4. Select "SDET" from Job title dropdown
//        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
//        jobTitleSelect.selectByVisibleText("SDET");
//
//        // 5. Verify "SDET" is selected
//        softAssert.assertTrue(jobTitleSelect.getFirstSelectedOption().getText().equals("SDET"));
//
//        softAssert.assertAll();
//    }

}
