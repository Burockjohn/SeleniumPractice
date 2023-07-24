package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex6 {

    //Open  https://demoqa.com/alerts page
    //Click first "Click me" button
    //Verify if displayed text is "You clicked a button"

    @Test(priority = 1)
    public void verifyText() {

        Driver.getDriver().get("https://demoqa.com/alerts");

        Driver.getDriver().findElement(By.id("alertButton")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String actual = alert.getText();
        Assert.assertEquals("You clicked a button", actual);
        BrowserUtils.sleep(2);
        alert.accept();

        Driver.closeDriver();

    }

    //Open  https://demoqa.com/alerts page
    //Click second "Click me" button
    //Wait 5 seconds
    //Verify if displayed text is "This alert appeared after 5 seconds"

    @Test(priority = 2)
    public void verifySecondClick() {

        Driver.getDriver().get("https://demoqa.com/alerts");

        Driver.getDriver().findElement(By.id("timerAlertButton")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Driver.getDriver().switchTo().alert();
        String actual = alert.getText();
        Assert.assertEquals("This alert appeared after 5 seconds", actual);
        BrowserUtils.sleep(2);
        alert.accept();

        Driver.closeDriver();

    }

    //Open  https://demoqa.com/alerts page
    //Click third "Click me" button
    //Click ok button.
    //Verify if "You selected Ok" text occurs

    @Test(priority = 3)
    public void verifyThirdClick() {

        Driver.getDriver().get("https://demoqa.com/alerts");

        Driver.getDriver().findElement(By.id("confirmButton")).click();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();

        String actual = Driver.getDriver().findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(actual, "You selected Cancel");

        Driver.closeDriver();

    }

    //Open  https://demoqa.com/alerts page
    //Click fourth "Click me" button
    //Input your name
    //Accept alert
    //Verify if result text is "You entered "+$yourName text occurs

    @Test(priority = 4)
    public void verifyFourthClick() {

        Driver.getDriver().get("https://demoqa.com/alerts");

        Driver.getDriver().findElement(By.id("promtButton")).click();

        Alert alert = Driver.getDriver().switchTo().alert();
        String sendItem = "Burockjohn";
        alert.sendKeys(sendItem);
        alert.accept();

        String actual = Driver.getDriver().findElement(By.id("promptResult")).getText();
        Assert.assertEquals("You entered " + sendItem, actual);

        Driver.closeDriver();

    }
}
