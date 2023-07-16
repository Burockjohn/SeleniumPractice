package com.cydeo.tests.homework_week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_02 {

    public static void main(String[] args) {

        /*

        TC #2: Zero Bank header verification
        1. Open Chrome browser
        2. Go to http://zero.webappsecurity.com/login.html
        3. Verify header text
        Expected: “Log in to ZeroBank”

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = driver.findElement(By.tagName("h3")).getText();

        String result = (actualHeader.equals(expectedHeader)) ? "Header verification PASSED!" : "Header verification FAILED!!!";
        System.out.println("result = " + result); //


    }
}
