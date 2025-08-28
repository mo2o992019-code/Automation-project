package testRunner;

import DriverManager.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utility.ExtentReportListener;
import pages.*;
import pages.*;
import java.io.IOException;
@Listeners(ExtentReportListener.class)

public class AllTests {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private Browsers browsers;
    private ListScreen listScreen;
    private TodayDealsPage todayDealsPage;
    private ProductPage productPage;
@BeforeMethod
public void setup(){
        browsers = new Browsers();
        driver =browsers.getBrowserName("chrome");
        ExtentReportListener.setDriver(driver);
        todayDealsPage=new TodayDealsPage(driver);
        productPage=new ProductPage(driver);
        homePage=new HomePage(driver);
        listScreen = new ListScreen(driver);
        signInPage = new SignInPage(driver);}
@Test (description = "Verify that user cannot log in with valid but not registered email",priority = 1)
public void signInFlow() throws IOException, org.json.simple.parser.ParseException {
        homePage.ClickOnAccAndList();
        signInPage.signInbar();
        signInPage.checkIfNewToAmazon();
}
@Test (description = "Verify that items are added to cart correctly ", priority = 3)
public void addCart(){
        homePage.clickOnTodayDeals();
        todayDealsPage.searchBar();
        productPage.addToCart();
}
@Test (description = "Verify that you cannot see (Your Orders) and (Your Addresses) pages if you are not logged in.But you can see (Your Lists) intro screen", priority = 2)
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
        homePage.ClickOnAccAndList();
}
@AfterMethod
public void close(){
    browsers.closeBrowser();
     }
}

