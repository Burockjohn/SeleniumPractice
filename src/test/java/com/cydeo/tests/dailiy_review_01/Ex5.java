package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex5 {

    // Open "https://demoqa.com/select-menu" page
    // Select each option of Old Style Select Menu
    // Verify if each option is selected or not
    // Tip:Use Select class and getOptions(),selectByVisibleText(),getFirstSelectedOption() methods

    @Test
    public void verifySelection() {

        Driver.getDriver().get("https://demoqa.com/select-menu");

        WebElement oldStyleSelectMenu = Driver.getDriver().findElement(By.id("oldSelectMenu"));
        //List<WebElement> allOptions = Driver.getDriver().findElements(By.cssSelector("#oldSelectMenu>option"));

        Select select = new Select(oldStyleSelectMenu);
        List<WebElement> allOptions = select.getOptions();

        for (int i = 0; i < allOptions.size(); i++) {
            select.selectByVisibleText(allOptions.get(i).getText());
            //select.selectByIndex(i);
            //WebElement actual = select.getFirstSelectedOption();
            //Assert.assertEquals(actual,allOptions.get(i));
            BrowserUtils.sleep(2);
            Assert.assertTrue(allOptions.get(i).isSelected());
        }

        Driver.closeDriver();

    }
}
