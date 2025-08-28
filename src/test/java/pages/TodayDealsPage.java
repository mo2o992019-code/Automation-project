package pages;

import DriverManager.Actions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.ExtentReportListener;
import utility.ScreenShots;

public class TodayDealsPage extends Actions {
        By searchBar= By.xpath("//input[@type='text']");
        By searchButton=By.xpath("//input[@id='nav-search-submit-button']");
        By objPhoto=By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]");
public TodayDealsPage(WebDriver driver) {
        super(driver);
        }
public void searchBar(){
        clickOnButton(searchBar);
        fillText(By.xpath("//input[@type='text']"),"wormekite");
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user search for a product.");
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
        clickOnButton(searchButton);
        ExtentReportListener.getTest().log(Status.PASS, "check product");
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
        clickOnButton(objPhoto);
        }
}