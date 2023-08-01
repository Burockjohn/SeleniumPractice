package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.AutoCompletePage;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Ex10 {

    //Goto https://practice.expandtesting.com/autocomplete page
    //Print "A" into "Country name" box and print the count of listed countries
    //Type each listed country into "Country name" box
    //and click "Submit" button and verify that the result text contains selected country

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://practice.expandtesting.com/autocomplete");
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }

    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @Test(priority = 1)
    public void verifyCountriesStartWithA() {
        autoCompletePage.countryName.sendKeys("A");
        BrowserUtils.sleep(1);

        int numberOfCountries = autoCompletePage.countries.size();
        System.out.println(numberOfCountries);

        ArrayList<String> result = new ArrayList<>();

        for (WebElement country : autoCompletePage.countries) {
            result.add(country.getText());
        }

        /*for (WebElement country : autoCompletePage.countries) {
            System.out.println(country.getText());
        }

         */
        autoCompletePage.countryName.clear();
        String countryName = "";
        for (String country : result) {
            autoCompletePage.countryName.sendKeys(country);
            BrowserUtils.sleep(1);
            countryName = autoCompletePage.typingCountry.getText();
            autoCompletePage.submit.click();
            Assert.assertTrue(autoCompletePage.resultText.getText().contains(countryName));
        }

    }

    //Challenge (You can find and print the count of all countries)
    @Test(priority = 2)
    public void countAllCountries() {

        int countOfAllCountries = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            autoCompletePage.countryName.sendKeys(i + "");
            countOfAllCountries += autoCompletePage.countries.size();
            autoCompletePage.countryName.clear();
        }

        System.out.println("countOfAllCountries = " + countOfAllCountries);

    }

}
