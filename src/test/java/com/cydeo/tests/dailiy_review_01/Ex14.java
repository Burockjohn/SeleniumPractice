package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.Key_Presses;
import com.cydeo.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex14 {

    Key_Presses key_presses = new Key_Presses();

    @Test
    public void verifyCharacters() {

        //Goto https://practice.expandtesting.com/key-presses page
        Driver.getDriver().get("https://practice.expandtesting.com/key-presses");

        //Press each lowercase and uppercase letters and numbers and check for each one if it is shown in result text
        List<Character> allChars = new ArrayList<>();

        for (char i = '0'; i <= '9'; i++) {
            allChars.add(i);
        }

        /*
        for (char i = 'a'; i <= 'z'; i++) {
            allChars.add(i);
        }

         */

        for (char i = 'A'; i <= 'Z'; i++) {
            allChars.add(i);
        }

        for (Character eachChar : allChars) {
            key_presses.input.sendKeys(eachChar + "");
            System.out.println(key_presses.resultText.getText() + "-->" + (eachChar+"").toUpperCase());
            Assert.assertTrue(key_presses.resultText.getText().contains((eachChar + "").toUpperCase()));
        }

        Driver.closeDriver();

    }

}
