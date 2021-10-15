package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public void homePageOpen(WebDriver driver){
        Assert.assertEquals(driver.getCurrentUrl(), "https://useinsider.com/");
    }
}
