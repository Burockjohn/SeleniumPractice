package com.cydeo.tests.homework_week02;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Day03_task5 {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:

        WebElement loginBox = driver.findElement(By.cssSelector("input.login-inp"));
        loginBox.sendKeys("incorrect username");

        //4- Click to `Reset password` button

        WebElement resetPasswordButton = driver.findElement(By.xpath("//button[@value='Reset password']"));
        resetPasswordButton.click();

        //5- Verify “error” label is as expected

        WebElement errorMessage = driver.findElement(By.cssSelector("div.errortext"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Login or E-mail not found";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Error Label Verification is Passed" );
        } else {
            System.out.println("Error Label Verification is Failed" );
        }

        //Expected: Login or E-mail not found
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from

    }
}
