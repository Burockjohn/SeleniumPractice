package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day10_task4_5 {

    //TC #4: Scroll practice
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/
    //3- Scroll down to “Powered by CYDEO”
    //4- Scroll using Actions class “moveTo(element)” method

    //TC #5: Scroll practice 2
    //1- Continue from where the Task 4 is left in the same test.
    //2- Scroll back up to “Home” link using PageUP button

    @Test
    public void task4() {
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);

        WebElement poweredByCydeo = Driver.getDriver().findElement(By.cssSelector("div[style='text-align: center;']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(poweredByCydeo).perform();
        BrowserUtils.sleep(2);

        Driver.closeDriver();
    }

    @Test
    public void task5() {
        Driver.getDriver().get("https://practice.cydeo.com/");
        BrowserUtils.sleep(2);

        WebElement poweredByCydeo = Driver.getDriver().findElement(By.cssSelector("div[style='text-align: center;']"));
        WebElement home = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(poweredByCydeo).perform();
        BrowserUtils.sleep(2);

        //2- Scroll back up to “Home” link using PageUP button
        //actions.sendKeys(home, "\uE01A").build().perform();
        //we are using the \uE01A character sequence to simulate the PageUp button press.
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        BrowserUtils.sleep(2);

        Driver.closeDriver();

    }


}
