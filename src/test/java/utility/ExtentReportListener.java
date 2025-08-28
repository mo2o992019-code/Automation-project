package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    public static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);}
    @Override
    public void onStart(ITestContext context){
        String reportPath = System.getProperty("user.dir") + "/Reports/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Amazon Automation Test Report");
        spark.config().setDocumentTitle("Test Run Report");
        extent = new ExtentReports();
        extent.attachReporter(spark);}
    private void attachScreenshotToReport(ITestResult result){
        try {
            WebDriver driver = driverThreadLocal.get();
            String testName = result.getMethod().getMethodName();
            String screenshotPath = ScreenShots.captureScreenshot(driver, testName);
            if (screenshotPath != null) {
                getTest().info("Evidence:",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());}}
        catch (Exception e) {
            getTest().log(Status.WARNING, "Could not attach screenshot: " + e.getMessage());}}
    @Override
    public  void onFinish(ITestContext context){
        extent.flush();}
    @Override
    public void onTestStart(ITestResult result) {
        String finalTestName = result.getMethod().getDescription();
        if (finalTestName == null || finalTestName.isEmpty()) {
            finalTestName = result.getMethod().getMethodName();}
        ExtentTest test = extent.createTest(finalTestName);
        extentTest.set(test);}
    @Override
    public void onTestFailure(ITestResult result) {
        getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
        attachScreenshotToReport(result);}
    public static ExtentTest getTest() {
        return extentTest.get();}

}
