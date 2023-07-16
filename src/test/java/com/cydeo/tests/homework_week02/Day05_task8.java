package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day05_task8 {

    //TC #8: Selecting value from multiple select dropdown

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void task8() throws InterruptedException {
        //3. Select all the options from multiple select dropdown.
        Select multipleDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = multipleDropdown.getOptions();

        for (WebElement each : allOptions) {
            multipleDropdown.selectByVisibleText(each.getText());
            Thread.sleep(1000);

            //4. Print out all selected values.
            if (each.isSelected()) System.out.println(each.getText());
        }

        //5. Deselect all values.
        multipleDropdown.deselectAll();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }

}
