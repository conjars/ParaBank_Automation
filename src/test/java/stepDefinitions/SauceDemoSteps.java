package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import hooks.Hooks;
import pages.LoginPage;
import pages.SauceDemoPage;

import java.util.List;
import java.util.Random;

public class SauceDemoSteps {
	WebDriver driver = Hooks.driver;
	//LoginPage lp = new LoginPage(Hooks.driver);
    SauceDemoPage sauceDemo = new SauceDemoPage(Hooks.driver);

    @Given("I open the SauceDemo login page")
    public void i_open_saucedemo_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter login credentials")
    public void i_enter_login_credentials(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        sauceDemo.enterUsername(data.get(1).get(0));
        sauceDemo.enterPassword(data.get(1).get(1));
    }

    @When("I click on the login button")
    public void i_click_on_login_button() {
        sauceDemo.clickLogin();
    }

    @When("I handle any popup if present")
    public void i_handle_any_popup_if_present() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No popup detected.");
        }
    }

    @When("I select filter option {string}")
    public void i_select_filter_option(String filterOption) {
        sauceDemo.selectSortingOption(filterOption);
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        sauceDemo.addFirstProductToCart();
    }

    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        sauceDemo.clickCart();
    }

    @Then("I verify the product in the cart")
    public void i_verify_the_product_in_the_cart() {
        Assert.assertTrue("Product not found in cart!", sauceDemo.isProductInCart());
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        sauceDemo.clickCheckout();
    }

    @When("I enter shipping details")
    public void i_enter_shipping_details() {
        sauceDemo.enterFirstName(generateRandomString());
        sauceDemo.enterLastName(generateRandomString());
        sauceDemo.enterZipCode(generateRandomZipCode());
    }

    @When("I click on continue button")
    public void i_click_on_continue_button() {
        sauceDemo.clickContinue();
    }

    @Then("I print the total price on the console")
    public void i_print_the_total_price_on_the_console() {
        System.out.println("Total Price: " + sauceDemo.getTotalPrice());
    }

    @When("I complete the order")
    public void i_complete_the_order() {
        sauceDemo.clickFinish();
    }

    @Then("I verify the order confirmation message {string}")
    public void i_verify_the_order_confirmation_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, sauceDemo.getOrderConfirmationText());
    }

    @When("I return to the homepage")
    public void i_return_to_the_homepage() {
        sauceDemo.clickBackHome();
    }

    @When("I logout from the application")
    public void i_logout_from_the_application() {
        sauceDemo.logout();
    }

    // Utility methods for random data generation
    private String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        return chars.charAt(random.nextInt(chars.length())) + "Test";
    }

    private String generateRandomZipCode() {
        return String.valueOf(new Random().nextInt(90000) + 10000);
    }
}
