package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import utils.CommonMethodsUtils;
import utils.UserDataList;

public class RegistrationPage extends BasePage {

	CommonMethodsUtils cmu = new CommonMethodsUtils();

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;

	@FindBy(xpath = "//h1[text()='Signing up is easy!']")
	private WebElement sectionNameTitle;

	@FindBy(id = "customer.firstName")
	private WebElement firstNameField;

	@FindBy(id = "customer.lastName")
	private WebElement lastNameField;

	@FindBy(id = "customer.address.street")
	private WebElement addressField;

	@FindBy(id = "customer.address.city")
	private WebElement cityField;

	@FindBy(id = "customer.address.state")
	private WebElement stateField;

	@FindBy(id = "customer.address.zipCode")
	private WebElement zipCodeField;

	@FindBy(id = "customer.phoneNumber")
	private WebElement phoneNumberField;

	@FindBy(id = "customer.ssn")
	private WebElement ssnField;

	@FindBy(id = "customer.username")
	private WebElement usernameField;

	@FindBy(id = "customer.password")
	private WebElement passwordField;

	@FindBy(id = "repeatedPassword")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;

	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	public void enterState(String state) {
		stateField.sendKeys(state);
	}

	public void enterZipCode(String zipCode) {
		zipCodeField.sendKeys(zipCode);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberField.sendKeys(phoneNumber);
	}

	public void enterSSN(String ssn) {
		ssnField.sendKeys(ssn);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	LoginPage lp = new LoginPage(driver);

	private List<By> inputFields = Arrays.asList(

			By.name("customer.firstName"), By.name("customer.lastName"), By.name("customer.address.street"),
			By.name("customer.address.city"), By.name("customer.address.state"), By.name("customer.address.zipCode"),
			By.name("customer.phoneNumber"), By.name("customer.ssn"), By.name("customer.username"),
			By.name("customer.password"), By.name("repeatedPassword")

	);
	
	public String registserusername =null;
	public  String password = null;
	
	public  void fillingRegistrationPage(UserDataList userdata)
	{
	
		
		registserusername = userdata.getUsername();
		password = userdata.getPassword();
		
		List<String> values = Arrays.asList(
			userdata.getFirstName(), userdata.getLastName(),userdata.getAddress(),userdata.getCity(), userdata.getState(),
			userdata.getZipCode(),userdata.getPhone(), userdata.getSSN(),registserusername,userdata.getPassword(), userdata.getConfirm()
				
				);
		for(int i =0; i<inputFields.size(); i++)
		{
			
			enterText(inputFields.get(i), values.get(i));
			
		}
				
				
		System.out.println("username #################"+registserusername);
		
	}
	
	public  void verifyTheHomeByenteringUserandpass(String titleName)
	{
		CommonMethodsUtils.highlightToElement(driver, lp.userName);
		lp.userName.sendKeys(registserusername);
		CommonMethodsUtils.highlightToElement(driver, lp.password);
		lp.password.sendKeys(password);
		CommonMethodsUtils.highlightToElement(driver, lp.LogIn);
		lp.LogIn.click();
		lp.verifyHomePage(titleName);
	}
	
	
	public  void verifytheTitleOfThePage(String lable)
	{
		
		CommonMethodsUtils.highlightToElement(driver, registerButton);
		registerButton.click();
		
		WebElement ele = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));
    	String expectedTitle = ele.getText().trim();    	
    	System.out.println(expectedTitle);
    	String actualvalue = lable+" "+ registserusername;
    	CommonMethodsUtils.highlightToElement(driver, ele);
    	
    	
    	Assert.isTrue(actualvalue.equals(expectedTitle), "not verifyed the home page ", "verify the Home Page");
    	lp.verifyLogoutScreen();
    	
    	
    			
	}
	
	
	public void enterText(By lcoator, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(lcoator));
		element.sendKeys(value);
		
		
	}
	
	
	
	
	

	public void clickRegisterLink_verifysectionname(String expectedvalue) throws InterruptedException {

		CommonMethodsUtils.highlightToElement(driver, registerLink);
		
		registerLink.click();
		//CommonMethodsUtils.waitForElementTobeVisibilty(driver,sectionNameTitle, 10);
		String str = sectionNameTitle.getText().trim();
		System.out.println("###################" + str);
		Thread.sleep(3000);
		CommonMethodsUtils.highlightToElement(driver, sectionNameTitle);
		Assert.isTrue(str.equals(expectedvalue), "section name displayed incorrect",
				"section name displayed correctly");

	}

}
