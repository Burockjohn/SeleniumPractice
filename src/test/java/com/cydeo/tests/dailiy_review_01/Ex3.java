package com.cydeo.tests.dailiy_review_01;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Ex3 {

    @Test
    public void verifyAge() {

        //Open https://demoqa.com/webtables page
        //Find the average of the ages (from table)
        //Verify if the integer part of the average of the ages is 37

        Driver.getDriver().get("https://demoqa.com/webtables");

        List<WebElement> ages = Driver.getDriver().findElements(By.xpath("//div[@class='rt-td'][3]"));

        int sum = 0;
        int counter = 0;

        for (WebElement age : ages) {

            if (!age.getText().isBlank()) {
                sum += Integer.parseInt(age.getText());
                counter++;
            }
        }
        System.out.println("counter = " + counter);
        System.out.println("sum = " + sum);

        Assert.assertEquals((sum / counter), 37);

        Driver.closeDriver();

    }
}
