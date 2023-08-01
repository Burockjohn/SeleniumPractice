package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElements {

    public AddRemoveElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Add Element']")
    public WebElement addElement;


    @FindAll(@FindBy(xpath = "//button[.='Delete']")
    )
    public List<WebElement> deleteElement;

}
