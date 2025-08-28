package DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Actions {
    public WebDriver driver;
    public  WebDriverWait wait;
    public Actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
public  void waitForElement(By locator){
         wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
public  void clickOnButton(By locator){
        waitForElement(locator);
        driver.findElement(locator).click();
    }
public  void fillText(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }
public String getElementText(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }
public void navigateBack() {
        driver.navigate().back();
    }
public void refreshPage() {
        driver.navigate().refresh();
    }
}