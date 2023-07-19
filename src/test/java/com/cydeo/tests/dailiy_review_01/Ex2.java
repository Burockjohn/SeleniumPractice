package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ex2 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void displayedExcelFİle() {

        driver.get(" https://demoqa.com/checkbox");
        WebElement arrowButton1 = driver.findElement(By.xpath("(//button[@title='Toggle'])[1]"));
        arrowButton1.click();

        WebElement arrowButton2 = driver.findElement(By.xpath("(//button[@title='Toggle'])[4]"));
        arrowButton2.click();

        WebElement excelFile = driver.findElement(By.xpath("(//span[.='Excel File.doc'])[2]"));
        excelFile.click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div#result")).getText().contains("excelFile"));

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
