package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraTask5 {

    //Task #: Gas Mileage Calculator Automation Test
    //1. Add a new class GasMileageCalculatorTest
    //2. Go to https://www.calculator.net
    //3. Search for “gas mileage” using search box
    //4. Click on the “Gas Mileage Calculator” link
    //5. On Next page verify:
    //a. Title equals: “Gas Mileage Calculator”
    //b. “Gas Mileage Calculator” label is displayed
    //6. Locate, clear and type “7925” into “Current odometer” field
    //7. Locate, clear and type “7550” into “Previous odometer” field
    //8. Locate, clear and type “16” into “Gas added” field
    //9. Locate, clear and type “3.55” into “Gas price” field
    //10. Click on Calculate button
    //11. Verify mpg value is as expected:
    //Expected value: “23.44 mpg”

    @Test
    public void task5() {
        Driver.getDriver().get("https://www.calculator.net");

        WebElement searchBox = Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");

        WebElement gasMileageCalculator = Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalculator.click();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Gas Mileage Calculator");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1")).isDisplayed());

        WebElement currentOdometer = Driver.getDriver().findElement(By.id("mucodreading"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        WebElement previousOdometer = Driver.getDriver().findElement(By.id("mupodreading"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        WebElement gasAdded = Driver.getDriver().findElement(By.id("mugasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        WebElement gasPrice = Driver.getDriver().findElement(By.id("mugasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("(//input[@type='image'])[2]"));
        calculateButton.click();

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//p[@class='verybigtext']/font/b"));
        Assert.assertTrue(resultText.getText().contains("23.44 mpg"));

        Driver.closeDriver();


    }
}
