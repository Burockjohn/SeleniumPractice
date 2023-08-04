package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.RadioButtonsPage;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex13 {

    RadioButtonsPage radioButtonsPage = new RadioButtonsPage();

    @Test
    public void verifySelection() {
        //Goto https://practice.expandtesting.com/radio-buttons page
        Driver.getDriver().get("https://practice.expandtesting.com/radio-buttons");

        //Select each radio button if it is selectable
        int counter = 0;
        for (WebElement radioButton : radioButtonsPage.radioButtons) {
            if (radioButton.isEnabled()) {
                radioButton.click();
                counter++;
            }
            BrowserUtils.sleep(1);

        }
        //Verify that the count of selectable radio buttons is 7
        Assert.assertEquals(counter, 7);

        Driver.closeDriver();
    }

}
