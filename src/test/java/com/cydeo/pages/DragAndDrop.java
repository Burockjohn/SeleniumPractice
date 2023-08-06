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

    @FindBy(xpath = "//div[@id='source']/div")
    public List<WebElement> draggableCircles;

    @FindBy(id = "target")
    public WebElement targetPlace;

    @FindBy(css = "#target>div")
    public List<WebElement> coloursAfterDragging;

}
