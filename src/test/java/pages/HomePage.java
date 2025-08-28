package pages;

import DriverManager.Actions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.ExtentReportListener;
import utility.ScreenShots;

public class HomePage extends Actions {

        By todayDealButton= By.xpath("//a[@href='/-/en/deals?ref_=nav_cs_gb']");
        By accAndListButton = By.xpath("//button[@class='nav-flyout-button nav-icon nav-arrow' and @aria-label='Expand Account and Lists']");

public HomePage(WebDriver driver) {
        super(driver);
    }
public void ClickOnAccAndList() {
        clickOnButton(accAndListButton);
        ExtentReportListener.getTest().log(Status.PASS, "Clicked on Accounts & Lists.");

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
        }
public void clickOnTodayDeals(){
        clickOnButton(todayDealButton);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure clicked on today deals.");
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
        }
}