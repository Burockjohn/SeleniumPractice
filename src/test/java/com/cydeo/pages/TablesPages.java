package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablesPages {

    public TablesPages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[.='First Name'])[1]")
    public WebElement table1FirstNameHeader;

    @FindBy(xpath = "(//tbody)[1]/tr/td[2]")
    public List<WebElement> table1FirstNames;

    @FindBy(css = "span.last-name")
    public WebElement table2LastNameHeader;

    @FindBy(xpath = "(//tbody)[2]/tr/td[1]")
    public List<WebElement> table2LastNames;



}
