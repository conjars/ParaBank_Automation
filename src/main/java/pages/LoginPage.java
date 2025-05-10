package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;
import utils.CommonMethodsUtils;
import utils.ConfigReader;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Log In']")
	public WebElement LogIn;
	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement logout;

	@FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
	private WebElement HomePage;

	CommonMethodsUtils cmu = new CommonMethodsUtils();

	public void login(String email, String password) {
		CommonMethodsUtils.highlightToElement(driver, emailField);
		emailField.sendKeys(email);
		CommonMethodsUtils.highlightToElement(driver, passwordField);
		passwordField.sendKeys(password);
		CommonMethodsUtils.highlightToElement(driver, loginButton);
		loginButton.click();
	}

	public void verifyHomePage(String expcted) {
		String actual = HomePage.getText();
		System.out.println("Expected value " + actual);

		CommonMethodsUtils.highlightToElement(driver, HomePage);

		Assert.isTrue(actual.equals(expcted), "Home page is not verifyed succesfully",
				"Home page  verifyed  sucessfully");

	}

	public void verifyLogoutScreen() {
		CommonMethodsUtils.highlightToElement(driver, logout);
		logout.click();

	}

	public void enterUsername() {
		userName.sendKeys(ConfigReader.getProperty("username"));

	}

	public void enterpassword() {
		password.sendKeys(ConfigReader.getProperty("password"));

	}

	public void verifyClickButton() {
		LogIn.click();

	}

}
