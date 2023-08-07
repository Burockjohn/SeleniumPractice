package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='ytp-title-text']/a")
    public WebElement videoName;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement commentFrame;

    @FindBy(id = "tinymce")
    public WebElement commentArea;

    @FindBy(css = "iframe#email-subscribe")
    public WebElement subscriptionFrame;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "btn-subscribe")
    public WebElement subscribeButton;

    @FindBy(id = "success-message")
    public WebElement resultText;

    @FindBy(className = "my-link")
    public WebElement bottomLink;
}
