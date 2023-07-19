package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.Driver;
import com.cydeo.tests.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraTask2 {

    //TC#2: Smartbear software order placing
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click on Login button
    //6. Click on Order
    //7. Select familyAlbum from product, set quantity to 2
    //8. Click to “Calculate” button
    //9. Fill address Info with JavaFaker
    //• Generate: name, street, city, state, zip code
    //10. Click on “visa” radio button
    //11. Generate card number using JavaFaker
    //12. Click on “Process”
    //13. Verify success message “New order has been successfully added.”

    @Test
    public void task2() {
        SmartBearUtils.loginToSmartBear(Driver.getDriver());

        WebElement order = Driver.getDriver().findElement(By.xpath("//a[.='Order']"));
        order.click();

        Select select1 = new Select(Driver.getDriver().findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")));
        select1.selectByIndex(1);

        WebElement quantitiy = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantitiy.sendKeys("2");

        WebElement calculateButton = Driver.getDriver().findElement(By.cssSelector("input[value='Calculate']"));
        calculateButton.click();

        Faker faker = new Faker();

        WebElement nameSection = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetSection = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement citySection = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateSection = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCodeSection = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        nameSection.sendKeys(faker.name().fullName());
        streetSection.sendKeys(faker.address().streetAddress());
        citySection.sendKeys(faker.address().city());
        stateSection.sendKeys(faker.address().state());
        //zipCodeSection.sendKeys(faker.address().zipCode());
        zipCodeSection.sendKeys(faker.bothify("#####"));

        WebElement visa = Driver.getDriver().findElement(By.xpath("//input[@value='Visa']"));
        visa.click();

        WebElement cardNumber = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        //cardNumber.sendKeys(faker.business().creditCardNumber());
        cardNumber.sendKeys(faker.numerify("################"));

        WebElement expiredDate = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expiredDate.sendKeys(faker.numerify("##/##"));

        WebElement process = Driver.getDriver().findElement(By.xpath("//a[.='Process']"));
        process.click();

        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("strong")).getText(), "New order has been successfully added.");

        Driver.closeDriver();


    }
}
