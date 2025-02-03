package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginStep {
	
	WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(Hooks.driver);
	
	
	
	@Given("user loging into parabank page sucessfully verify home page as {string}")
	public void loginintoparabankApplication(String lablename) {
		driver.get(ConfigReader.getEnvironmentURL()); // Read URL dynamically
		lp.enterUsername();
		lp.enterpassword();
		lp.verifyClickButton(); 		
		lp.verifyHomePage(lablename);
	}

	
	
	
	
	

}
