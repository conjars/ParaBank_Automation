package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import utils.ExtentReportUtil;

public class CheckoutPage extends BasePage{
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountMenu;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    public boolean isCheckoutPageDisplayed() {
        return driver.getTitle().contains("Checkout");
    }

    public void completeOrder() {
        // Simulate order completion if needed
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public void proceedToCheckout() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/checkout");
        wait.until(ExpectedConditions.titleContains("Checkout"));
    }



}
