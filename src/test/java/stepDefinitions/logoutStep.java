package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import utils.ExtentReportUtil;

public class logoutStep  {
	
	WebDriver driver = Hooks.driver;
	 CheckoutPage checkoutPage = new CheckoutPage(driver);
	

	
	@When("User proceeds to checkout")
	public void proceedToCheckout() {
	    CheckoutPage checkoutPage = new CheckoutPage(driver);
	    checkoutPage.proceedToCheckout();
//	    ExtentReportUtil.logStep("Proceeded to Checkout page");
//	    ScreenshotUtil.captureScreenshot(driver, "proceed_checkout");
	}

	@Then("User successfully logs out")
	public void userLogsOut() {
	    CheckoutPage checkoutPage = new CheckoutPage(driver);
	    checkoutPage.logout();
//	    ExtentReportUtil.logStep("User successfully logged out");
//	    ScreenshotUtil.captureScreenshot(driver, "logout_success");
	}
}
