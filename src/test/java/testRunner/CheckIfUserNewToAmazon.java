package testRunner;

import DriverManager.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import java.io.IOException;
import utility.ExtentReportListener;

public class CheckIfUserNewToAmazon {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private Browsers browsers;
@BeforeTest
public void browserInitialization(){
        browsers = new Browsers();
        driver=browsers.getBrowserName("chrome");
        ExtentReportListener.setDriver(driver);
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
}
@Test(description = "Verify that user cannot log in with valid but not registered email")
public void signInFlow() throws IOException, org.json.simple.parser.ParseException {
        homePage.ClickOnAccAndList();
        signInPage.signInbar();
        signInPage.checkIfNewToAmazon();
}
@AfterTest
public void close(){browsers.closeBrowser();}
}

