/*
 * package stepDefinitions;
 * 
 * import java.sql.DriverManager;
 * 
 * import org.junit.Assert; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebDriver;
 * 
 * import hooks.Hooks; import io.cucumber.java.en.And; import
 * io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
 * io.cucumber.java.en.When; import pages.ButtonsPage; import pages.LoginPage;
 * 
 * 
 * public class ButtonSteps { WebDriver driver = Hooks.driver; ButtonsPage
 * buttonsPage = new ButtonsPage(Hooks.driver);
 * 
 * @Given("I navigate to {string}") public void i_navigate_to(String url) {
 * driver.get(url); }
 * 
 * @When("I click on {string}") public void i_click_on(String linkText) {
 * driver.findElement(By.linkText(linkText)).click(); }
 * 
 * @And("I add an element") public void i_add_an_element() {
 * buttonsPage.clickAddElement(); }
 * 
 * @And("I delete an element") public void i_delete_an_element() {
 * buttonsPage.clickDeleteElement(); }
 * 
 * @And("I select a checkbox") public void i_select_a_checkbox() {
 * buttonsPage.selectCheckbox(); }
 * 
 * @And("I select {string} from the dropdown") public void
 * i_select_from_the_dropdown(String option) {
 * buttonsPage.selectDropdownOption(option); }
 * 
 * @Then("I verify {string} is selected") public void
 * i_verify_is_selected(String expectedOption) {
 * Assert.assertEquals(expectedOption, buttonsPage.getSelectedDropdownOption());
 * }
 * 
 * @And("I navigate back") public void i_navigate_back() {
 * driver.navigate().back(); } }
 */