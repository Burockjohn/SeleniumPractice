package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_2 {

    /*

    TC #2: Facebook incorrect login title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Enter incorrect username
    4. Enter incorrect password
    5. Verify title changed to:
    Expected: “Log into Facebook”

     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        WebElement usernameSection = driver.findElement(By.id("email"));
        usernameSection.sendKeys("incorrect username");

        WebElement passwordSection = driver.findElement(By.id("pass"));
       passwordSection.sendKeys("incorrect password" + Keys.ENTER);

        String expectedTitle = "Facebook'a Giriş Yap";
        Thread.sleep(10000);
        String actualTitle = driver.getTitle(); //Facebook

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED");
        } else {
            System.out.println("Title verification FAILED");
        }


    }
}
