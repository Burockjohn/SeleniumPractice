package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    //Open https://demoqa.com/webtables page
    //Change the name of first user
    //Verify if it is changed or not
    //Add a user to table
    //Verify if it is added or not

    @Test
    public void userModify() {
        Driver.getDriver().get("https://demoqa.com/webtables");

        WebElement editButton = Driver.getDriver().findElement(By.xpath("//span[@id='edit-record-2']"));
        editButton.click();

        WebElement firstName = Driver.getDriver().findElement(By.cssSelector("input#firstName"));
        String initalName = firstName.getText();
        firstName.clear();
        firstName.sendKeys("Burockjohn");

        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("button#submit"));
        submitButton.click();

        WebElement finalName = Driver.getDriver().findElement(By.xpath("//*[.='Burockjohn']"));
        Assert.assertNotEquals(initalName, finalName.getText());

        Driver.closeDriver();
    }

    @Test
    public void verifyAddition() {

        Driver.getDriver().get("https://demoqa.com/webtables");

        List<WebElement> initialEditButtons = Driver.getDriver().findElements(By.xpath("//span[@class='mr-2']"));
        System.out.println("initialEditButtons.size() = " + initialEditButtons.size());

        WebElement addButton = Driver.getDriver().findElement(By.cssSelector("button#addNewRecordButton"));
        addButton.click();

        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.cssSelector("input#firstName"));
        WebElement LastName = Driver.getDriver().findElement(By.cssSelector("input#lastName"));
        WebElement email = Driver.getDriver().findElement(By.cssSelector("input#userEmail"));
        WebElement age = Driver.getDriver().findElement(By.cssSelector("input#age"));
        WebElement salary = Driver.getDriver().findElement(By.cssSelector("input#salary"));
        WebElement department = Driver.getDriver().findElement(By.cssSelector("input#department"));
        WebElement submitButton = Driver.getDriver().findElement(By.cssSelector("button#submit"));

        firstName.sendKeys(faker.name().firstName());
        LastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.letterify("?????@email.com"));
        age.sendKeys(String.valueOf(faker.number().numberBetween(18, 50)));
        salary.sendKeys(faker.numerify("######"));
        department.sendKeys("Java");
        submitButton.click();

        List<WebElement> finalEditButtons = Driver.getDriver().findElements(By.xpath("//span[@class='mr-2']"));

        System.out.println("finalEditButtons.size() = " + finalEditButtons.size());
        //boolean differenceEquals1 = (finalEditButtons.size() - initialEditButtons.size()) == 1;
        //System.out.println("differenceEquals1 = " + differenceEquals1);

        Assert.assertTrue((finalEditButtons.size() - initialEditButtons.size()) == 1);

        Driver.closeDriver();

    }

}
