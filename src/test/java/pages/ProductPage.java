package pages;

import DriverManager.Actions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.testng.Assert;
import utility.ExtentReportListener;
import utility.ScreenShots;

public class ProductPage extends Actions {

    By actualCartPrice = By.xpath("//div[@data-name='Subtotals']//span[@id='sc-subtotal-amount-activecart']");
    By openCount = By.xpath("//span[@class='a-button-text a-declarative']");
    By addOne = By.xpath("//a[@id='quantity_1']");
    By addToCart = By.xpath("//input[@id='add-to-cart-button']");
    By cart= By.xpath("//a[@href='/-/en/cart?ref_=ox_ewc_ret_gtc_dsk_eg']");
    By noThanksButton = By.xpath("//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attachSiNoCoverage-announce']");
    By getProductPriceText=By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]");

public ProductPage(WebDriver driver) {
        super(driver);
    }
public void addToCart() {
        clickOnButton(openCount);
        clickOnButton(addOne);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure user add Qty from product.");
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
            clickOnButton(addToCart);
        try {
            clickOnButton(noThanksButton);
        }
        catch (Exception e) {
        System.out.println("Protection plan popup not found or not clickable, continuing.");}
        clickOnButton(cart);
        ExtentReportListener.getTest().log(Status.PASS, "Make sure price,name and Qty are correct.");
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
public double getPrice(){
            String priceText= getElementText(getProductPriceText);
            priceText=priceText.replace("EGP","").replace(",", "").trim();
            return Double.parseDouble(priceText);
    }
public void CheckQtyAndPrice() {
        ProductPage productPage = new ProductPage(driver);
        double priceTotal = productPage.calculateExpectedTotalPrice();
        String actualTotalText = getElementText(actualCartPrice);
        actualTotalText=actualTotalText.replace("EGP","").replace(",","").trim();
        double actualTotal=Double.parseDouble(actualTotalText);
        Assert.assertEquals(actualTotal, priceTotal);}
public double calculateExpectedTotalPrice() {
        return getPrice();}
}