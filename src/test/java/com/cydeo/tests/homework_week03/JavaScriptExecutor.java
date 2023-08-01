package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

    @Test
    public void test1(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        WebElement inputBar = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String text = "Eu11 is the best";
        js.executeScript("arguments[0].setAttribute('value', '" + text +"')",inputBar);
    }

    @Test
    public void test2() throws InterruptedException {
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,250)");
        }
    }

    // click button    jse.executeScript("arguments[0].click();", dropdownLink);
    // scroll to some element  jse.executeScript("arguments[0].scrollIntoView(true);",eng);
}
