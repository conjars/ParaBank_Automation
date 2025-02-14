package stepDefinitions;



import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;
import hooks.Hooks;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.CommonMethodsUtils;
import utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class RegistrationSteps {
    WebDriver driver = Hooks.driver;
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage lp  = new LoginPage(driver);

    @Given("User is on the registration page")
    public void user_is_on_registration_page() {
    	//driver.get(ConfigReader.getProperty("app.url"));
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

//    @And("User clicks on Register button")
//    public void user_clicks_on_register_button() {
//        registrationPage.clickRegister();
//    }

    @Then("User should see a success message {string}")
    public void user_should_see_success_message(String message) {
        System.out.println("Registration successful");
    }
    
    
    @Given("user is on Parabank Page click on Register link under login button verify {string} section is displayed")
    public void user_is_on_parabank_page_click_on_register_link_under_login_button_verify_section_is_displayed(String expectedvalue) throws InterruptedException {
    	
    	//driver.get(ConfigReader.getProperty("QA"));
    	registrationPage.clickRegisterLink_verifysectionname(expectedvalue);
        
    }
    
    public  String randomusername;
    
    @When("user enter the below data to register")
    public void user_enter_the_below_data_to_register(DataTable dataTable) throws InterruptedException {
    	
    	
    	List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
    	  	
    	
    	//[{firstname:sahoo, lastname:jana, address:hyderbad]
    	
    	randomusername = "User" + new Random().nextInt(10000);
    	
    	System.out.println(randomusername);
    	
    	Map<String, String> user = userData.get(0);
    	
    	driver.findElement(By.xpath("//input[@name='customer.firstName']")).sendKeys(user.get("FirstName"));
    	driver.findElement(By.xpath("//input[@name='customer.lastName']")).sendKeys(user.get("LastName"));
    	driver.findElement(By.xpath("//input[@name='customer.address.street']")).sendKeys(user.get("Address"));
    	driver.findElement(By.xpath("//input[@name='customer.address.city']")).sendKeys(user.get("City"));
    	driver.findElement(By.xpath("//input[@name='customer.address.state']")).sendKeys(user.get("State"));
    	driver.findElement(By.xpath("//input[@name='customer.address.zipCode']")).sendKeys(user.get("ZipCode"));
    	driver.findElement(By.xpath("//input[@name='customer.phoneNumber']")).sendKeys(user.get("Phone"));
    	driver.findElement(By.xpath("//input[@name='customer.ssn']")).sendKeys(user.get("SSN"));
    	driver.findElement(By.xpath("//input[@name='customer.username']")).sendKeys(randomusername);
    	driver.findElement(By.xpath("//input[@name='customer.password']")).sendKeys(user.get("Password"));
    	driver.findElement(By.xpath("//input[@name='repeatedPassword']")).sendKeys(user.get("Confirm"));
    	driver.findElement(By.xpath("//input[@value='Register']")).click();
    	
    	
    	  	
    	
    	
    	
    	
       
    }

    @Then("user should navigate to home page verify {string} displayed, user clicks on logout button")
    public void user_should_navigate_to_home_page_verify_displayed_user_clicks_on_logout_button(String string) {
    	
    	
    	WebElement ele = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));
    	String expectedTitle = ele.getText().trim();    	
    	System.out.println(expectedTitle);
    	String actualvalue = "Welcome " + randomusername;
    	CommonMethodsUtils.highlightToElement(driver, ele);
    	Assert.isTrue(actualvalue.equals(expectedTitle), "Account user is not verifyed ", "Account user is verifyed ");
    	
    	//lp.verifyHomePage(string);
    	
    	//CommonMethodsUtils.highlightToElement(driver, ele)
    	lp.verifyLogoutScreen();
    	
    	
    	
    	
    	
        
    }

    
    
    
    
    
    
    
    
    
    
    
}

