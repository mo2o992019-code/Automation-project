package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import utility.ExtentReportListener;
import utility.ScreenShots;
import utility.jsonReader;
import DriverManager.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import java.io.IOException;

public class SignInPage extends Actions {

   private final String dataPath = "src/main/resources/utils/data.json";
    By newAmazonTitle = By.xpath("//h1[@class='a-size-medium-plus a-spacing-small']");
    By continueButton = By.xpath("//input[@class='a-button-input']");
    By clickSignInButton = By.xpath("//span[@class='nav-action-inner']");
    By searchEmailBar = By.xpath("//input[@type='email']");

public SignInPage(WebDriver driver) {
        super(driver);
    }
public void signInbar() throws IOException, ParseException {
        clickOnButton(clickSignInButton);
        clickOnButton(searchEmailBar);
        String email = jsonReader.getJsonValueByKey(dataPath, "email");
        fillText(By.xpath("//input[@type='email']"), email);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user entered a valid email.");
        try {
            String testName = ExtentReportListener.getTest().getModel().getName();
            String path = ScreenShots.captureScreenshot(driver, testName + "_AccountClick");
        if (path != null) {
                ExtentReportListener.getTest().info("Evidence:",
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            }
        }
        catch (Exception e) {
            ExtentReportListener.getTest().log(Status.WARNING, "Failed to capture screenshot after clicking Accounts & Lists.");
        }
        clickOnButton(continueButton);
    }
public void checkIfNewToAmazon(){
        String expectedText ="Looks like you're new to Amazon";
        String actualText =driver.findElement(newAmazonTitle).getText();
        Assert.assertEquals(actualText,expectedText);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user can't log in.");
        try {
            String testName = ExtentReportListener.getTest().getModel().getName();
            String path = ScreenShots.captureScreenshot(driver, testName + "_AccountClick");
        if (path != null) {
                ExtentReportListener.getTest().info("Evidence:",
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            }
        }
        catch (Exception e) {
            ExtentReportListener.getTest().log(Status.WARNING, "Failed to capture screenshot after clicking Accounts & Lists.");
        }
         navigateBack();
         navigateBack();
}
}