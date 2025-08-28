package testRunner;

import DriverManager.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utility.ExtentReportListener;

public class AddProductsToCart {
    private WebDriver driver;
    private TodayDealsPage todayDealsPage;
    private ProductPage productPage;
    private Browsers browsers;
    private HomePage homePage;
@BeforeTest
public void setup(){
        browsers = new Browsers();
        driver =browsers.getBrowserName("chrome");
        ExtentReportListener.setDriver(driver);
        todayDealsPage=new TodayDealsPage(driver);
        productPage=new ProductPage(driver);
        homePage=new HomePage(driver);
}
@Test(description = "Verify that items are added to cart correctly ")
public void addCart(){
        homePage.clickOnTodayDeals();
        todayDealsPage.searchBar();
        productPage.addToCart();
}
@AfterTest
public void close() {
        browsers.closeBrowser();
    }
}