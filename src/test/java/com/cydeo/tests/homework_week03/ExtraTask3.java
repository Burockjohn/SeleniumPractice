package com.cydeo.tests.homework_week03;

import com.cydeo.tests.utilities.Driver;
import com.cydeo.tests.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraTask3 {

    //TC#3: Smartbear software order verification
    //1. Open browser and login to Smartbear software
    //2. Click on View all orders
    //3. Verify Susan McLaren has order on date “01/05/2010”

    @Test
    public void task3() {
        SmartBearUtils.loginToSmartBear(Driver.getDriver());
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]")).getText(),("01/05/2010"));

        Driver.closeDriver();

    }


}
