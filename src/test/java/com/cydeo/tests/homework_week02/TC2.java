package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2 {

    // TC#2: Registration Form Page Testing


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @Test
    public void testCase2() {

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        Assert.assertEquals(driver.getTitle(), "Registration Form");

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
