package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_04 {

    /*

    TC #4: Practice Cydeo – Class locator practice
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/inputs
    3- Click to “Home” link
    4- Verify title is as expected:
    Expected: Practice
    PS: Locate “Home” link using “className” locator

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");

        WebElement gmailButton = driver.findElement(By.className("nav-link"));
        gmailButton.click();

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        String result = (actualTitle.equals(expectedTitle)) ? "Title verification PASSED!" : "Title verification FAILED!!!";
        System.out.println("result = " + result);

    }
}
