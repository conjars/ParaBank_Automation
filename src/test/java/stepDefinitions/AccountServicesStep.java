package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.AccountServicePage;

public class AccountServicesStep {

	WebDriver driver = Hooks.driver;
	AccountServicePage asp = new AccountServicePage(Hooks.driver);

	List<String> links;

	@When("user retives all navigation link")
	public void user_retives_all_navigation_link() {

		links = asp.getAllNavigatioinLink();

	}

	@When("user clicks on each link verifies the page")
	public void user_clicks_on_each_link_verifies_the_page() {

		for (int i = 0; i < links.size(); i++) {

			String linktext = links.get(i);
			asp.clickLinkByName(linktext);

		}

	}

	
	@When("user clicks on the following navigation links verifes the page name:")
	public void user_clicks_on_the_following_navigation_links_verifes_the_page_name(DataTable dataTable) {
	   
		
		
		
		
	}
	
	
	
}
