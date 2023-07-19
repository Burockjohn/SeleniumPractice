package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.WebDriverFactory;
import com.cydeo.tests.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day08_Task3 {

    //TC #3: Create a custom method
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/tables
    //3- Write custom method:
    //• Method name: getTableGetEmail()
    //• Return type: void
    //• Arg1: WebDriver driver
    //• Arg2: String tableNum
    //• Arg3: String firstName

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/tables");

    }

    @Test
    public void test4() {
        WebTableUtils.getTableGetEmail(driver,"1","Jason");
    }

}
