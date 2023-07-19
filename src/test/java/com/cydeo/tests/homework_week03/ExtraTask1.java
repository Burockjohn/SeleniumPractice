package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.Driver;
import com.cydeo.tests.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ExtraTask1 {

    //TC #1: Smartbear software link verification
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page

    @Test
    public void test1() {
        SmartBearUtils.loginToSmartBear(Driver.getDriver());

        //Find and store in a List all links using finElement(S) method
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));

        //Print out count of all the links on landing page
        System.out.println("links.size() = " + links.size());

        //Print out each link text on this page
        for (int i = 0; i < links.size(); i++) {
            System.out.println((i + 1) + ". link= " + links.get(i).getText());
        }

        Driver.closeDriver();
    }
}
