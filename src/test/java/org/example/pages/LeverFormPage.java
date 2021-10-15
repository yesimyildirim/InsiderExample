package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class LeverFormPage {
    public void formElementCheck(WebDriver driver1){

        WebElement formelement= driver1.findElement(xpath("/html/body/div[3]/div/div[2]/form"));
        if(formelement!=null){
            System.out.println("Element bulundu!");
        }else
        {
            System.out.println("Element bulunamadı!");
        }

    }
}
