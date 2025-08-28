package testRunner;

import DriverManager.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utility.ExtentReportListener;

public class CantSeePagesIfNotUserNotLogIn {
    private WebDriver driver;
    private HomePage homePage;
    private Browsers browsers;
    private ListScreen listScreen;
@BeforeTest
public void setup() {
        browsers = new Browsers();
        driver= browsers.getBrowserName("chrome");
        ExtentReportListener.setDriver(driver);
        homePage = new HomePage(driver);
        listScreen = new ListScreen(driver);
    }
@Test (description = "Verify that you cannot see (Your Orders) and (Your Addresses) pages if you are not logged in.But you can see (Your Lists) intro screen")
public void check()  {
        homePage.ClickOnAccAndList();
        listScreen.yourOrder();
        listScreen.CheckSignIn();
        homePage.ClickOnAccAndList();
        listScreen.clickYourAddress();
        listScreen.Addresses();
        homePage.ClickOnAccAndList();
        listScreen.yourList();
        listScreen.Lists();
        }
@AfterTest
public void close() {
    browsers.closeBrowser();
    }
}