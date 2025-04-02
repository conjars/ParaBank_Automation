package stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.FramesExamplePage;
import pages.GoogleDoodlePage;
import utils.ExtentReportUtil;

public class FrameExampleSteps {
	
	WebDriver driver = Hooks.driver;
    FramesExamplePage framesExamplePage = new  FramesExamplePage(driver);
    ExtentTest test;
	
public FrameExampleSteps() {
        
        
        this.test = ExtentReportUtil.getTest();
    }

   
	
	@When("User click on {string} link")
	public void user_click_on_link(String linkName) {
		framesExamplePage.veifyframeButtonClick();
		test.log(Status.INFO, "Clicked on " + linkName + " link");
	}

	@When("user handle the iframe")
	public void user_handle_the_iframe() {
		framesExamplePage.userhanleNestedFrameLink();
	}

	@When("user handle  the nested frames")
	public void user_handle_the_nested_frames() {
	    
	}


}
