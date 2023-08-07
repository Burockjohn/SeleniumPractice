package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.IframePage;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ex16 {

    IframePage iframePage = new IframePage();

    @Test
    public void verifySubscription() {

        //Goto https://practice.expandtesting.com/iframe page
        Driver.getDriver().get("https://practice.expandtesting.com/iframe");

        //Get the name of video
        Driver.getDriver().switchTo().frame("iframe-youtube");
        String actualNameOfVideo = iframePage.videoName.getText();
        System.out.println(actualNameOfVideo);

        //Clear comment area
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(iframePage.commentFrame);
        iframePage.commentArea.clear();

        //Verify if it is cleared
        Assert.assertEquals(iframePage.commentArea.getText(), "");

        //Print $theNameOfVideo + "was wonderful!" in comment area
        iframePage.commentArea.sendKeys(actualNameOfVideo + " was wonderful!");

        //Verify if it is printed
        Assert.assertTrue(iframePage.commentArea.getText().contains("was wonderful!"));

        //Input a valid email into "Send updates" box
        Faker faker = new Faker();
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(iframePage.subscriptionFrame);
        iframePage.inputEmail.sendKeys(faker.internet().emailAddress());
        BrowserUtils.sleep(2);

        //Click "Subscribe" button
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(iframePage.subscribeButton));

//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].scrollIntoView(true)", iframePage.bottomLink);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        BrowserUtils.sleep(2);
        iframePage.subscribeButton.click();


        //Verify "You are now subscribed!" message occurs
        Assert.assertEquals(iframePage.resultText.getText(), "You are now subscribed!");

        Driver.getDriver().switchTo().parentFrame();

        Driver.closeDriver();
    }

}
