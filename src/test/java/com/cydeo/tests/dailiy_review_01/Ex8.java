package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex8 {

    //Open https://jqueryui.com/selectable/ page
    //Select Item 4
    //Verify if Item 4 is selected
    //Select Item 7
    //Verify if Item 4 is not selected
    //Verify if Item 7 is selected

    @Test
    public void test1() {

        Driver.getDriver().get("https://jqueryui.com/selectable/");
        Driver.getDriver().switchTo().frame(0);
        WebElement item4 = Driver.getDriver().findElement(By.xpath("//ol[@id='selectable']/li[4]"));
        item4.click();
        BrowserUtils.sleep(2);
        Assert.assertTrue(item4.getAttribute("class").contains("selected"));
        WebElement item7 = Driver.getDriver().findElement(By.xpath("//ol[@id='selectable']/li[7]"));
        item7.click();
        BrowserUtils.sleep(2);
        Assert.assertFalse(item4.getAttribute("class").contains("selected"));
        Assert.assertTrue(item7.getAttribute("class").contains("selected"));

        Driver.closeDriver();

    }

}
