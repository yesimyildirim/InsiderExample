package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class CareerPage {
    public void careersPageOpen(WebDriver driver, String url){
        driver.get(url);
        WebElement more = driver.findElement(xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[5]"));
        WebElement careers = driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[5]/div/div[1]/div[3]/div/a"));
        more.click();
        careers.click();


    }
    public void careersPageTest(WebDriver driver)
    {
        driver.getPageSource().contains("Our Location");
        driver.getPageSource().contains("teams");
        driver.getPageSource().contains("jobs");
        driver.getPageSource().contains("culture");
        driver.getPageSource().contains("life");
    }
    public void openPositionPage(WebDriver driver){
        WebElement openpositionpagebutton= driver.findElement(xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a"));
        openpositionpagebutton.click();
    }

}
