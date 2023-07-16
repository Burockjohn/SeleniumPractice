package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day04_task3 {

    public static void main(String[] args) {

        //XPATH Practice
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #6: XPATH LOCATOR practice
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cydeo.com/multiple_buttons

        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1

        WebElement button1 = driver.findElement(By.xpath("//button[.='Button 1']"));
        button1.click();

        //4. Verify text displayed is as expected:

        WebElement display = driver.findElement(By.xpath("//*[@id='result']"));
        String expectedMessage = "Clicked on button one!";
        String actualMessage = display.getText();

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Text Displayed Verification is Passed" );
        } else {
            System.out.println("Text Displayed Verification is Failed" );
        }

        //Expected: “Clicked on button one!”
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    }
}
