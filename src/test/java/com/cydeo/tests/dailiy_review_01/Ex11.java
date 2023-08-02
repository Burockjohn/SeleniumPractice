package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.TablesPages;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex11 {

    @Test
    public void verifySortedNames() {

        TablesPages tablesPages = new TablesPages();

        //Goto https://practice.expandtesting.com/tables page
        Driver.getDriver().get("https://practice.expandtesting.com/tables");
        List<String> firstNames1 = new ArrayList<>();
        for (WebElement eachFirstName : tablesPages.table1FirstNames) {
            firstNames1.add(eachFirstName.getText());
        }

        //Click first table's "First Name" header to sort table
        tablesPages.table1FirstNameHeader.click();
        Collections.sort(firstNames1);

        //Verify if "First Name" column is sorted or not
        for (int i = 0; i < tablesPages.table1FirstNames.size(); i++) {
            Assert.assertEquals(tablesPages.table1FirstNames.get(i).getText(), firstNames1.get(i));
        }

        ///////////////////////////////////////////////////////////////////////

        List<String> lastNames1 = new ArrayList<>();
        for (WebElement eachLastName : tablesPages.table2LastNames) {
            lastNames1.add(eachLastName.getText());
        }

        //Click second table's "Last Name" header to sort table
        tablesPages.table2LastNameHeader.click();
        Collections.sort(lastNames1);

        //Verify if "Last Name" column is sorted or not
        for (int i = 0; i < tablesPages.table2LastNames.size(); i++) {
            Assert.assertEquals(tablesPages.table2LastNames.get(i).getText(), lastNames1.get(i));
        }

        Driver.closeDriver();

    }

}
