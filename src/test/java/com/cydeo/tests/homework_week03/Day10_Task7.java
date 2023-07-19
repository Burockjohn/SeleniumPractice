package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day10_Task7 {

    //TC #7: Scroll using JavascriptExecutor
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/large
    //3- Scroll down to “Cydeo” link
    //4- Scroll up to “Home” link
    //5- Use below provided JS method only
    //JavaScript method to use : arguments[0].scrollIntoView(true)
    //Note: You need to locate the links as web elements and pass them as
    //arguments into executeScript() method

    @Test
    public void task7(){

        Driver.getDriver().get("https://practice.cydeo.com/large");
        BrowserUtils.sleep(2);

        WebElement cydeo = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView();", cydeo);
        BrowserUtils.sleep(2);

        //4- Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView();", home);
        BrowserUtils.sleep(2);

        Driver.closeDriver();
    }

}
