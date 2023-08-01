package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.AddRemoveElements;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex9 {

    //Goto https://practice.expandtesting.com/add-remove-elements page
    //Click "Add Element" button 20 times
    //Verify if 20 "Delete" button element occurs
    //Click each "Delete" button
    //Verify if all "Delete" buttons are deleted or not
    //NOTE: FOLLOW POM

    @Test
    public void verifyAddRemove() {

        Driver.getDriver().get("https://practice.expandtesting.com/add-remove-elements");

        AddRemoveElements addRemoveElements = new AddRemoveElements();

        for (int i = 0; i < 20; i++) {
            addRemoveElements.addElement.click();
        }

        int actualSize = addRemoveElements.deleteElement.size();
        int expectedSize = 20;

        Assert.assertEquals(actualSize, expectedSize);

        for (WebElement each : addRemoveElements.deleteElement) {
            each.click();
        }

        Assert.assertTrue(addRemoveElements.deleteElement.size() == 0);

        Driver.closeDriver();

    }
}
