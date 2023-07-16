package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_03 {

    /*
    TC #3: Back and forth navigation
    1- Open a Chrome browser
    2- Go to: https://google.com
    3- Click to Gmail from top right.
    4- Verify title contains:
    Expected: Gmail
    5- Go back to Google by using the .back();
    6- Verify title equals:
    Expected: Google
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement gmailButton = driver.findElement(By.linkText("Gmail"));
        gmailButton.click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        String result = (actualTitle.equals(expectedTitle)) ? "Title verification PASSED!" : "Title verification FAILED!!!";
        System.out.println("result = " + result);

        driver.navigate().back();

        expectedTitle = "Google";
        actualTitle = driver.getTitle();

        result = (actualTitle.equals(expectedTitle)) ? "Title verification PASSED!" : "Title verification FAILED!!!";
        System.out.println("result = " + result);

    }
}
