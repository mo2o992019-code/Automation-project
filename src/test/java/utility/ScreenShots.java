package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public static String captureScreenshot(WebDriver driver, String testName) {
        String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";
        String fileName = testName + "_" + System.currentTimeMillis() + ".png";
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationDir = new File(screenshotDir);
            File destinationFile = new File(screenshotDir + fileName);
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();}
            FileHandler.copy(sourceFile, destinationFile);
            return "../Screenshots/" + fileName;}
        catch (IOException | WebDriverException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return null;}}
}
