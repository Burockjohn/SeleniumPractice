package com.cydeo.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DragAndDrop {

    public DragAndDrop() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div.red")
    public WebElement red;

    @FindBy(css = "div.green")
    public WebElement green;

    @FindBy(css = "div.blue")
    public WebElement blue;

    @FindBy(id = "target")
    public WebElement targetPlace;

    @FindBy(css = "#target>div")
    public List<WebElement> coloursAfterDragging;

}
