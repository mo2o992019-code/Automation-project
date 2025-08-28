package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.ConfigReader;

import java.util.Locale;
public class Browsers {
    private WebDriver driver;
    public WebDriver getBrowserName(String browserName) {
    switch (browserName.toLowerCase(Locale.ROOT)) {
        case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                this.driver = new ChromeDriver(options);
                break;
        case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options1 = new FirefoxOptions();
                this.driver = new FirefoxDriver(options1);
                break;
        default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        this.driver.manage().window().maximize();
        String url = ConfigReader.getProperty("url");
        this.driver.navigate().to(url);
        return this.driver;
    }
public void closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();}
    }
}