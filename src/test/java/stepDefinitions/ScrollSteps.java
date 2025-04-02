package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ScrollPage;

public class ScrollSteps {
	
	WebDriver driver = Hooks.driver;
	ScrollPage sc = new ScrollPage(driver);
	
	
	@Given("user launches the heroApp HomePage")
	public void user_launches_the_hero_app_home_page() {
	    driver.get("https://the-internet.herokuapp.com/");
	}
	
	@When("user scrolls down to the Hvers section")
	public void user_scrolls_down_to_the_hvers_section() {
	   sc.scrolltoHoverLink();
	}
	
	@When("user hovers over the first image")
	public void user_hovers_over_the_first_image() {
	  sc.hoverImage();
	  String screenshotbase = sc.takeScreenshot(driver, "hover-action");
	}
	
	@Then("user should see the user profile name")
	public void user_should_see_the_user_profile_name() {
	  sc.isprofileNameIsDisplayed();  
	}


}
