package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebTablePage;

public class WebTableSteps {
	
	WebDriver driver = Hooks.driver;
	WebTablePage wtp = new WebTablePage(driver);
	
	@Given("I navigate to the web table page")
	public void i_navigate_to_the_web_table_page() {
	    
	}

	@When("I retriev all the table data based on row and column")
	public void i_retriev_all_the_table_data_based_on_row_and_column() {
		
	//wtp.printTheWebtableData();	
	    
	}

	@When("I check first five checkboxes in the webtable")
	public void i_check_first_five_checkboxes_in_the_webtable() throws InterruptedException {
	   wtp.CheckTheFristFiveCheckboxes();
	}

	@Then("I verify the checkboxes are checked or not")
	public void i_verify_the_checkboxes_are_checked_or_not() {
	    
	}

}
