package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExtraTask4 {

    //TC #1: Checking the number of links on the page
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Count the number of the links on the page and verify
    //Expected: 332

    //TC #2: Printing out the texts of the links on the page
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Print out all of the texts of the links on the page

    //TC #3: Counting the number of links that does not have text
    //1. Open Chrome browser
    //2. Go to https://www.openxcell.com
    //3. Count the number of links that does not have text and verify
    //Expected: 109

    @Test
    public void tc1() {
        Driver.getDriver().get("https://www.openxcell.com");
        Assert.assertTrue(Driver.getDriver().findElements(By.tagName("a")).size() >= 332);
        Driver.closeDriver();
    }

    @Test
    public void tc2() {
        Driver.getDriver().get("https://www.openxcell.com");
        BrowserUtils.sleep(10);

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            System.out.println((i + 1) + ". link= " + links.get(i).getText());
        }
        Driver.closeDriver();
    }

    @Test
    public void tc3() {
        Driver.getDriver().get("https://www.openxcell.com");
        BrowserUtils.sleep(10);

        int numberOfLinksWithoutText = 0;
        for (WebElement each : Driver.getDriver().findElements(By.tagName("a"))) {
            if (!each.getText().isEmpty()) numberOfLinksWithoutText++;
        }
        System.out.println("numberOfLinksWithoutText = " + numberOfLinksWithoutText);
        Assert.assertEquals(numberOfLinksWithoutText, 109);
        Driver.closeDriver();
    }
}
