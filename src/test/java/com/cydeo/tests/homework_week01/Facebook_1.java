package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_1 {

    /*

    TC #1: Facebook title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Verify title:
    Expected: “Facebook - Log In or Sign Up”

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED");
        } else {
            System.out.println("Title verification FAILED");
        }

    }
}
