package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day05_task7 {

    //TC #7: Selecting value from non-select dropdown

    WebDriver driver;

    @BeforeClass
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void task7() {

        //3. Click to non-select dropdown
        WebElement nonselectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonselectDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.xpath("//*[.='Facebook']"));
        facebook.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle, "The title of pages are diffirent");

    }

    @AfterClass
    public void teardownMethod() {
        driver.close();
    }
}
