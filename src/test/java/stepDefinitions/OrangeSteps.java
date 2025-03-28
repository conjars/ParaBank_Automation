package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OrangeLogin;
import pages.PIMPage;

public class OrangeSteps {
	
	
	WebDriver driver =Hooks.driver;
	DashboardPage dashboardPage;
	OrangeLogin loginPage ;
	LogoutPage logoutP = new LogoutPage(driver);
	PIMPage pimPage;
	
	@Given("the user is on the OrangeHRM login page")
    public void userOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new OrangeLogin(driver);
    }

    @When("the user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @And("clicks on the login button")
    public void userClicksLogin() {
    	
    }

    @Then("the user should be redirected to the Dashboard page")
    public void verifyDashboard() {
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Given("the user is logged into the OrangeHRM application")
    public void userLoggedIn() {
        userOnLoginPage();
        userEntersCredentials("Admin", "admin123");
        userClicksLogin();
        dashboardPage = new DashboardPage(driver);
    }

    @When("the user prints all menu links")
    public void printMenuLinks() {
        dashboardPage.printAllMenuLinks();
    }

    @Then("the system should display the total number of menu links")
    public void displayLinkCount() {
        // Already printed in printAllMenuLinks
    }

    @Given("the user is on the Employee List page under PIM")
    public void onEmployeeListPage() {
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Employee List']")).click();
        pimPage = new PIMPage(driver);
    }

    @When("the user selects {string} from the Employment Status dropdown")
    public void selectEmploymentStatus(String status) {
    	pimPage.searchByEmploymentStatus(status);
    }

    @And("clicks on the search button")
    public void clickSearchButton() {
        // already handled in search method
    }

    @Then("the employee list should be filtered accordingly")
    public void validateFilteredList() {
       WebElement ele = driver.findElement(By.xpath("//div[@class='oxd-table-card']//div[text()='Full-Time Contract']"));
      // assertEquals(ele.size()>=1, "the record displayed is greather than one ");
       String label = ele.getText();
       System.out.println(label);
     //assertEquals(ele.getText().trim().equalsIgnoreCase(label), "value  not verifyed ", "value is  verifed ");
       pimPage = new PIMPage(driver);
    }

    @Given("the user is on the OrangeHRM Dashboard page")
    public void userOnDashboardPage() {
        userLoggedIn();
    }

    @When("the user right-clicks the Dashboard link and opens it in a new tab")
    public void openInNewTab() {
        WebElement dashboardLink = driver.findElement(By.linkText("Dashboard"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(dashboardLink).keyUp(Keys.CONTROL).build().perform();
    }

    @And("logs out from the new tab")
    public void logoutFromNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();
    }

    @And("switches back to the main tab and logs out again")
    public void logoutFromMainTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        dashboardPage.logout();
    }

    @Then("the user should be logged out successfully")
    public void verifyLogout() {
       
    }


}
