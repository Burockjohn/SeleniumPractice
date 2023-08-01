package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex7 {


    //Open https://demoqa.com/frames page
    //Verify if first frames header is "This is a sample page"
    //Verify if second frames header is "This is a sample page"

    @Test
    public void test1() {

        Driver.getDriver().get("https://demoqa.com/frames");

        Driver.getDriver().switchTo().frame("frame1");
        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("h1")).getText(), "This is a sample page");

        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame("frame2");
        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("h1")).getText(), "This is a sample page");

        Driver.closeDriver();


    }

    @Test
    public void test2() {

        //Open https://demoqa.com/select-menu page
        Driver.getDriver().get("https://demoqa.com/select-menu");
        //    //Type "option 1" into first dropdown
        //    //Hit the enter
        //WebElement firstDropdown = Driver.getDriver().findElement(By.xpath("(//div[@class=' css-yk16xz-control'])[1]"));
        WebElement firstDropdown = Driver.getDriver().findElement(By.cssSelector("#react-select-2-input"));
        //firstDropdown.click();
        firstDropdown.sendKeys("option 1" + Keys.ENTER);

        //    //Verify whether the selected option is "Group 1, option 1"
        String actual1 = Driver.getDriver().findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[1]")).getText();
        Assert.assertEquals(actual1, "Group 1, option 1");

        //    //Type "Ot" into second dropdown
        //    //Hit the enter
        WebElement secondDropdown = Driver.getDriver().findElement(By.cssSelector("#react-select-3-input"));
        //secondDropdown.click();
        secondDropdown.sendKeys("Ot" + Keys.ENTER);

        //    //Verify if the selected option is "Other"
        String actual2 = Driver.getDriver().findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[2]")).getText();
        Assert.assertEquals(actual2, "Other");

        Driver.closeDriver();

    }

}
