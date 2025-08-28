package pages;

import DriverManager.Actions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ExtentReportListener;
import utility.ScreenShots;

public class ListScreen extends Actions {

    By yourOrders= By.xpath("//*[@id='nav_prefetch_yourorders']/span");
    By yourAddresses= By.xpath("//*[@id='nav_prefetch_youraddresses']/span");
    By checkSignIn = (By.xpath("//h1[@class='a-spacing-small']"));
    By checkAddresses = (By.xpath("//*[@id='claim-collection-container']/h1"));
    By checkListAppears = (By.xpath("//*[@id='my-lists-tab']/a/div"));
    By yourLists= By.xpath("//*[@id='nav-al-your-account']/ul/li[4]/a/span");

public ListScreen(WebDriver driver) {
    super(driver);
}

public void yourOrder(){
    clickOnButton(yourOrders);
}

public void clickYourAddress(){
    clickOnButton(yourAddresses);
}

public void yourList(){
    clickOnButton(yourLists);
}

public void CheckSignIn() {
        Assert.assertEquals(driver.findElement(checkSignIn).getText(), "Sign in");
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user can't see orders when not signed in.");
    try {
            String testName = ExtentReportListener.getTest().getModel().getName();
            String path = ScreenShots.captureScreenshot(driver, testName + "_AccountClick");
    if (path != null) {
                ExtentReportListener.getTest().info("Evidence:",
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());}
    }
    catch (Exception e) {
            ExtentReportListener.getTest().log(Status.WARNING, "Failed to capture screenshot after clicking Accounts & Lists.");
    }
        navigateBack();}

public void Addresses() {
        String expectedText = "Sign in or create account";
        String actualText = driver.findElement(checkAddresses).getText();
        Assert.assertEquals(actualText, expectedText);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user can't see addresses when not signed in..");
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
        navigateBack();}

public void Lists() {
        String expectedText = "Your Lists";
        String actualText = driver.findElement(checkListAppears).getText();
        Assert.assertEquals(actualText, expectedText);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user can see the list screen.");
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
      navigateBack();}
}