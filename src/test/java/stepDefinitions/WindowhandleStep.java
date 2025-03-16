package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.failsafe.internal.util.Assert;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowhandlePage;

public class WindowhandleStep {

	WebDriver driver = Hooks.driver;
	WindowhandlePage whp = new WindowhandlePage(driver);

	JsonNode userData;

	@Given("user launches the browser and navigates to the {string}")
	public void user_launches_the_browser_and_navigates_to_the_window_handling_page(String title) {

		whp.verifyTheTitleOfthepage(title);
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String buttonName) throws InterruptedException {
		whp.verifyButtonWithtext(buttonName);

	}

	@Then("user switches to the newly opened window and verify the title of the page")
	public void user_switches_to_the_newly_opened_window_and_verify_the_title_of_the_page() {

		whp.switchToNewWindowandMaximizethescreen();
		whp.getPageTitlte();
		Assert.isTrue(whp.getPageTitlte().contains("Basic Control"), "title of the page is not validated",
				" title of the page is valdiated ");
	}

	@Then("user enter the basic details data by using JSON formart and click on  register button")
	public void user_enter_the_basic_details_data_by_using_json_formart_and_click_on_register_button()
			throws IOException {

		// load JSON Data

		ObjectMapper obj = new ObjectMapper();
		userData = obj.readTree(new File("src/test/resources/TestData/userData.json"));
		whp.enterFristname(userData.get("FirstName").asText());
		whp.enterlastname(userData.get("LastName").asText());
		whp.selectGender(userData.get("Gender").asText());

		List<String> selectedLangiuage = new ArrayList<>();

		for (JsonNode lang : userData.get("Languagesknown")) {

			selectedLangiuage.add(lang.asText());

		}

		//whp.selectlang(selectedLangiuage);

		whp.enteremailAdd(userData.get("Email").asText());
		whp.enteremailAdd(userData.get("Password").asText());

		whp.registerbutton();

	}

}
