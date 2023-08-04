package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//b/em)[1]")
    public WebElement userName;

    @FindBy(xpath = "(//b/em)[2]")
    public WebElement password;

    @FindBy(id = "username")
    public WebElement userNameSection;

    @FindBy(id = "password")
    public WebElement passwordSection;

    @FindBy(xpath = "(//button)[2]")
    public WebElement loginButton;

    @FindBy(css = "#flash>b")
    public WebElement resultText;

    @FindBy(css = "a.button.secondary.radius")
    public WebElement logout;


}
