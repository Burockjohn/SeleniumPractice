package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_01 {

    public static void main(String[] args) {

        /*
        TC #1: Etsy Title Verification
        1. Open Chrome browser
        2. Go to https://www.etsy.com
        3. Search for “wooden spoon”
        4. Verify title:
        Expected: “Wooden spoon | Etsy”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        WebElement etsySearchBox = driver.findElement(By.id("global-enhancements-search-query"));
        etsySearchBox.sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        String result = (actualTitle.equals(expectedTitle)) ? "Title verification PASSED!" : "Title verification FAILED!!!";
        System.out.println("result = " + result); // Wooden spoon - Etsy


    }
}
