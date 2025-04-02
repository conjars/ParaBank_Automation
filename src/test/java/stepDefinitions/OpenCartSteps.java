package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import hooks.Hooks;
import utils.ConfigReader;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.ComponentsPage;
import pages.LoginPage;

public class OpenCartSteps   {

    
	WebDriver driver = Hooks.driver;
	LoginPage loginPage = new LoginPage(Hooks.driver);
	ComponentsPage componentsPage = new ComponentsPage(driver);
	CartPage cartPage = new CartPage(driver);
	//CheckoutPage checkoutPage = new CheckoutPage(driver);
    @Given("User is on OpenCart login page")
    public void user_is_on_opencart_login_page() {
       
    	//driver.get(ConfigReader.getProperty("app.url"));
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("vedhamsk55@gmail.com", "VedhaMSK#55");
    }

    @When("User navigates to {string} tab and selects {string}")
    public void user_navigates_to_tab_and_selects(String tab, String category) {
        
        componentsPage.navigateToCategory(tab, category);
    }

    @When("User selects the first product and adds it to the cart")
    public void user_selects_the_first_product_and_adds_it_to_cart() {
        componentsPage.addFirstItemToCart();
    }

    @When("User searches for {string} and adds it to cart")
    public void user_searches_for_and_adds_it_to_cart(String product) {
        
        cartPage.searchAndAddProduct(product);
    }

    @When("User verifies the items in the cart")
    public void user_verifies_the_items_in_the_cart() {
        Assert.assertTrue(cartPage.verifyCartItems(), "Cart items verification failed!");
    }

//    @When("User proceeds to checkout")
//    public void user_proceeds_to_checkout() {
//        checkoutPage = new CheckoutPage(driver);
//        checkoutPage.completeCheckout();
//    }
//
//    @Then("User successfully logs out")
//    public void user_successfully_logs_out() {
//        logoutPage = new LogoutPage(driver);
//        logoutPage.logout();
//        teardown();
//    }
}
