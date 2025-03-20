package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.GoogleDoodlePage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import utils.ExtentReportUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import hooks.Hooks;

import java.util.List;
import java.util.Map;

public class GoogleDoodleSteps {

	WebDriver driver = Hooks.driver;
    GoogleDoodlePage googleDoodlePage = new  GoogleDoodlePage(driver);
    ExtentTest test;

    public GoogleDoodleSteps() {
        
        
        this.test = ExtentReportUtil.getTest();
    }

    @Given("I navigate to Doodle {string}")
    public void i_navigate_to(String url) {
        googleDoodlePage.navigateToPage(url);
        test.log(Status.INFO, "Navigated to " + url);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_library_link(String linkName) {
        googleDoodlePage.clickLibrary();
        test.log(Status.INFO, "Clicked on " + linkName + " link");
    }

    @When("I click on the {string} filter")
    public void i_click_on_the_color_filter(String filterName) {
    	
    	
        googleDoodlePage.selectFilter(filterName);
        test.log(Status.INFO, "Clicked on " + filterName + " filter");
   
    }

    @When("I select {string} {string} and {string}")
    public void i_select_multiple_colors(String label, String color1, String color2) {
    	
    	if(label.equals("colors")) {
        googleDoodlePage.selectTwoColors(color1, color2);
        test.log(Status.INFO, "Selected colors: " + color1 + " and " + color2);
    	}
    	else
    	{
    		googleDoodlePage.selectTwoTopic(color1, color2);
            test.log(Status.INFO, "Selected colors: " + color1 + " and " + color2);
    	}
    }

    @Then("I verify that doodles are filtered based on the selected colors")
    public void i_verify_color_filter() {
        boolean isFiltered = googleDoodlePage.isFilterApplied();
        Assert.assertTrue("Doodles should be filtered by selected colors", isFiltered);
        test.log(Status.PASS, "Doodles are filtered successfully based on selected colors");
    }
}
