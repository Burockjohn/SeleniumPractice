package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3 {

    // TC#3: Registration Form Page Filling Form Test

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @Test
    public void testCase3() {

        // 3. Enter First name: "John"
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstName.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastName = driver.findElement(By.xpath("//*[@name='lastname']"));
        lastName.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement userName = driver.findElement(By.xpath("//*[@name='username']"));
        userName.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement email = driver.findElement(By.xpath("//*[@name='email']"));
        email.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
        password.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@name='phone']"));
        phoneNumber.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement maleGender = driver.findElement(By.xpath("//*[@value='male']"));
        maleGender.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement birthday = driver.findElement(By.xpath("//*[@name='birthday']"));
        birthday.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select select1 = new Select(driver.findElement(By.cssSelector("select.form-control.selectpicker")));
        select1.selectByVisibleText("Department of Engineering");

        // 12. Select "SDET" from Job title dropdown
        Select select2 = new Select(driver.findElement(By.cssSelector("select[name = 'job_title']")));
        select2.selectByVisibleText("SDET");

        // 13. Click to "Java" from languages
        WebElement java = driver.findElement(By.cssSelector("input#inlineCheckbox2"));
        java.click();

        // 14. Click to "Sign up" button
        WebElement loginButton = driver.findElement(By.cssSelector("button#wooden_spoon"));
        loginButton.click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        WebElement header = driver.findElement(By.xpath("//h4"));
        String expectedText = "Well done!";
        String actualText = header.getText();

        Assert.assertEquals(expectedText, actualText);

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

}
