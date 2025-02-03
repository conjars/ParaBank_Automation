package stepDefinitions;



import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import pages.RegistrationPage;
import utils.ConfigReader;
import io.cucumber.java.en.*;

public class RegistrationSteps {
    WebDriver driver = Hooks.driver;
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("User is on the registration page")
    public void user_is_on_registration_page() {
    	driver.get(ConfigReader.getProperty("app.url"));
    	String str = driver.getTitle();
    	System.out.println(str);
    }

    @When("User enters First Name {string}")
    public void user_enters_first_name(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @And("User enters Last Name {string}")
    public void user_enters_last_name(String lastName) {
        registrationPage.enterLastName(lastName);
    }

    @And("User clicks on Register button")
    public void user_clicks_on_register_button() {
        registrationPage.clickRegister();
    }

    @Then("User should see a success message {string}")
    public void user_should_see_success_message(String message) {
        System.out.println("Registration successful");
    }
}

