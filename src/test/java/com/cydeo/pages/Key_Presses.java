package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Key_Presses {

    public Key_Presses() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "form-control")
    public WebElement input;

    @FindBy(id = "result")
    public WebElement resultText;

}
