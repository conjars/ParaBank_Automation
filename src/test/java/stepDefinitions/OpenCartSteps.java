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

    @When("user selects {string} from show dropdown, adds first product to cart, verifies specification, adds to wishlist, and sees success message")
    public void user_selects_the_first_product_and_adds_it_to_cart(String value) {
        componentsPage.addFirstItemToCart(value);
    }

    @When("user searches for {string}, adds it to cart, updates quantity to {string}, and clicks on update button")
    //user searches for "HTC Touch HD", adds it to cart, updates quantity to "3", and clicks on update button
    public void user_searches_for_and_adds_it_to_cart(String product, String quantity) {
        
        cartPage.searchAndAddProduct(product, quantity);
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
