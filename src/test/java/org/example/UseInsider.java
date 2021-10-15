package org.example;
import org.example.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import static org.openqa.selenium.By.xpath;
public class UseInsider {

    public WebDriver driver;
    public String url = "https://useinsider.com/";
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/yesimartik/IdeaProjects/ExmProject/ExmProject/InsiderExample/InsiderExample/InsiderExample/Driver/chromedriver-3");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void homePageOpen() {
        driver.get(url);
        HomePage homePage = new HomePage();
        homePage.homePageOpen(driver);
    }

    @Test
    public void careersPageOpen() {
        CareerPage career = new CareerPage();
        career.careersPageOpen(driver,url);
        career.careersPageTest(driver);
    }
    @Test
    public void FilterandList (){
        CareerPage career = new CareerPage();
        career.careersPageOpen(driver,url);
        career.openPositionPage(driver);

        OpenPositionPage openPositionPage = new OpenPositionPage();
        openPositionPage.filterCountry(driver);
        openPositionPage.filterPosition(driver);
        openPositionPage.listCheck(driver);

}
    @Test
    public void ListCheck(){
        CareerPage career = new CareerPage();
        career.careersPageOpen(driver,url);
        career.openPositionPage(driver);

        OpenPositionPage openPositionPage = new OpenPositionPage();
        openPositionPage.filterCountry(driver);
        openPositionPage.filterPosition(driver);

        WebElement resultsNumber1= driver.findElement(xpath("//*[@id=\"deneme\"]"));
        int jobNumber=Integer.parseInt(resultsNumber1.getText());

        openPositionPage.listPositionCheck(driver,jobNumber);
        openPositionPage.listCountryCheck(driver,jobNumber);


    }

    @Test
    public void JobDetails(){
        CareerPage career = new CareerPage();
        career.careersPageOpen(driver,url);
        career.openPositionPage(driver);


        OpenPositionPage openPositionPage = new OpenPositionPage();
        openPositionPage.filterCountry(driver);
        openPositionPage.filterPosition(driver);
        String baseurl=openPositionPage.getBaseUrl(driver);
        openPositionPage.applyNowButtonAct(driver);

        LeverPage leverPage=new LeverPage();
        leverPage.elementCheck(driver,baseurl);

    }
    @Test
    public void jobFormAndButtonCheck(){
        CareerPage career = new CareerPage();
        career.careersPageOpen(driver,url);
        career.openPositionPage(driver);

        OpenPositionPage openPositionPage = new OpenPositionPage();
        openPositionPage.filterCountry(driver);
        openPositionPage.filterPosition(driver);
        openPositionPage.applyNowButtonAct(driver);

        LeverPage leverPage=new LeverPage();
        WebDriver driver1=leverPage.switchSecondSegment(driver);

        leverPage.jobFormAndButtonClick(driver1);

        LeverFormPage leverFormPage= new LeverFormPage();
        leverFormPage.formElementCheck(driver1);
        WebElement formelement= driver1.findElement(xpath("/html/body/div[3]/div/div[2]/form"));
        if(formelement!=null){
            System.out.println("Element bulundu!");
        }else
        {
            System.out.println("Element bulunamadı!");
        }



    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
