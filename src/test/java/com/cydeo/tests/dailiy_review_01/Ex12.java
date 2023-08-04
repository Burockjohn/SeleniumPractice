package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex12 {
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyLoginFunction() {

        //Goto https://practice.expandtesting.com/login page
        Driver.getDriver().get("https://practice.expandtesting.com/login");

        //Get username and password form page (Tip:they are emphasized)
        //Enter the username into username box
        loginPage.userNameSection.sendKeys(loginPage.userName.getText());

        //Enter the password into password box
        loginPage.passwordSection.sendKeys(loginPage.password.getText());

        //Click login button
        loginPage.loginButton.click();

        //Verify that "You logged into a secure area!" message is displayed
        Assert.assertEquals(loginPage.resultText.getText(), "You logged into a secure area!");

        //Click "Logout" link
        loginPage.logout.click();

        //Verify that "You logged out of the secure area!" message is displayed
        Assert.assertEquals(loginPage.resultText.getText(), "You logged out of the secure area!");

        Driver.closeDriver();

    }

}
