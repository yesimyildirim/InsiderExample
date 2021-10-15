package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static org.openqa.selenium.By.xpath;

public class LeverPage {

    public WebDriver  switchSecondSegment(WebDriver driver){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

        WebDriver driver1 = driver.switchTo().window(tabs2.get(1));

        return driver1;
    }
    public void elementCheck(WebDriver driver,String baseurl){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        switchSecondSegment(driver);
        WebDriver driver1 = driver.switchTo().window(tabs2.get(1));
        String urlcheck=driver1.getCurrentUrl();

        WebElement title=driver1.findElement(xpath("/html/body/div[3]/div/div[1]/div/div[1]/h2"));
        WebElement applyForThisJobButton=driver1.findElement(xpath("/html/body/div[3]/div/div[1]/div/div[2]/a"));

        String jobcheck = title.getText();
        String basejobtitle="Software Quality Assurance Engineer";
        Assert.assertEquals(baseurl,urlcheck);
        Assert.assertEquals(basejobtitle,jobcheck);
        if(applyForThisJobButton!=null){
            System.out.println("Element bulundu!");
        }else
        {
            System.out.println("Element bulunamadı!");
        }
    }
    public void jobFormAndButtonClick(WebDriver driver1){

        WebElement applyForThisJobButton=driver1.findElement(xpath("/html/body/div[3]/div/div[1]/div/div[2]/a"));
        applyForThisJobButton.click();

    }

}
