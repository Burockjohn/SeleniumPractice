package com.cydeo.tests.dailiy_review_01;

import com.cydeo.pages.DragAndDrop;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ex15 {

    DragAndDrop dragAndDrop = new DragAndDrop();

    @Test
    public void verifyDragAndDrop() {

        //Goto https://practice.expandtesting.com/drag-and-drop-circles page
        Driver.getDriver().get("https://practice.expandtesting.com/drag-and-drop-circles");

        //Move to the red circle into the box
        //Move to the blue circle into the box
        //Move to the green circle into the box
        //Verify that the circles are in the order you moved them

//        for (int i = 0; i < dragAndDrop.draggableCircles.size(); i++) {
//            System.out.println(dragAndDrop.draggableCircles.get(i).getAttribute("class"));
//        }

        List<WebElement> draggables = dragAndDrop.draggableCircles;

        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < draggables.size(); i++) {
            actions.dragAndDrop(draggables.get(i), dragAndDrop.targetPlace).perform();
            BrowserUtils.sleep(1);
            //System.out.println(draggables.get(i).getAttribute("class"));
            //System.out.println(draggables.size());
        }

        //System.out.println("dragAndDrop.coloursAfterDragging.size() = " + dragAndDrop.coloursAfterDragging.size());

        for (WebElement webElement : dragAndDrop.coloursAfterDragging) {
            webElement.getAttribute("class");
        }

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.xpath("//div[@id='target']/div[3]"))));

        for (int i = 0; i < dragAndDrop.coloursAfterDragging.size(); i++) {
            Assert.assertEquals(dragAndDrop.coloursAfterDragging.get(i).getAttribute("class"), draggables.get(i).getAttribute("class"));
            //System.out.println(draggables.size());
            //System.out.println(draggables.get(i).getAttribute("class"));
        }

        Driver.closeDriver();

    }

}
