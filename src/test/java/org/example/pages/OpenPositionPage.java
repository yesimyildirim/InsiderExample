package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class OpenPositionPage {
    public void filterCountry(WebDriver driver){
        WebElement countrys=driver.findElement(xpath("//*[@id=\"select2-filter-by-location-container\"]"));
        countrys.click();

        WebElement selectcountry = driver.findElement(By.xpath("//*[@id=\"select2-filter-by-location-results\"]"));
        String searchText = "Istanbul, Turkey";
        ArrayList<WebElement> options = new ArrayList<>(selectcountry.findElements(By.tagName("li")));
        for (WebElement option : options)
        {
            if (option.getText().equals(searchText))
            {
                option.click(); // click the desired option
                break;
            }
        }

    }
    public void filterPosition(WebDriver driver){
        WebElement department=driver.findElement(xpath("//*[@id=\"select2-filter-by-department-container\"]"));
        department.click();
        WebElement selectdepartment = driver.findElement(By.xpath("//*[@id=\"select2-filter-by-department-results\"]"));
        ArrayList<WebElement> options2 = new ArrayList<>(selectdepartment.findElements(By.tagName("li")));
        String searchTextt ="Quality Assurance";
        for (WebElement option2 : options2)
        {
            if (option2.getText().equals(searchTextt))
            {
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", option2);
                option2.click();
                break;

            }
        }

    }
    public void listCheck(WebDriver driver){
        WebElement results= driver.findElement(xpath("//*[@id=\"jobs-list\"]"));
        ArrayList<WebElement> options3 = new ArrayList<>(results.findElements(By.tagName("div")));
        if(options3.size()!=0){
            System.out.println("İş ilanı mevcut!");
        }


    }

    public void listCountryCheck(WebDriver driver, int jobNumber){
        String searchText3= "Istanbul, Turkey";
        int i=0;
        WebElement results1= driver.findElement(xpath("//*[@id=\"jobs-list\"]"));
        ArrayList<WebElement> options4 = new ArrayList<>(results1.findElements(By.tagName("div")));
        for (WebElement option4 : options4)
        {

            if (option4.getText().equals(searchText3))
            {

                i++;
                if(i==jobNumber)
                {
                    System.out.println("Istanbul Turkey mevcut");
                }

            }
        }
    }
    public void listPositionCheck(WebDriver driver, int jobNumber){
        String searchText2= "Quality Assurance";
        int j=0;
        WebElement results= driver.findElement(xpath("//*[@id=\"jobs-list\"]"));
        ArrayList<WebElement> options3 = new ArrayList<>(results.findElements(By.tagName("span")));
        for (WebElement option3 : options3)
        {
            if (option3.getText().equals(searchText2))
            {
                j++;
                if (j==jobNumber){
                    System.out.println("Quality Assurance mevcut");
                }

            }
        }
    }
    public void applyNowButtonAct(WebDriver driver){
        WebElement applayNowButton=driver.findElement(xpath("//*[@id=\"jobs-list\"]/div[2]/div/a"));
        applayNowButton.click();
    }
    public String getBaseUrl(WebDriver driver){
        WebElement applayNowButton=driver.findElement(xpath("//*[@id=\"jobs-list\"]/div[2]/div/a"));
        String baseurl = applayNowButton.getAttribute("href");
        return baseurl;
    }
}
