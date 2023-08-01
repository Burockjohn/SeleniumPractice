package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePage {

    public AutoCompletePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "country")
    public WebElement countryName;

    @FindBy(xpath = "//div[@id='countryautocomplete-list']/div")
    public List<WebElement> countries;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submit;

    @FindBy(xpath = "//p[@id='result']")
    public WebElement resultText;

    @FindBy(xpath = "//div[@id='countryautocomplete-list']/div/strong")
    public WebElement typingCountry;

}
