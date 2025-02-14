package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;
import utils.CommonMethodsUtils;

public class RegistrationPage extends BasePage {
	
	CommonMethodsUtils cmu = new CommonMethodsUtils();

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    
    
    @FindBy(xpath =  "//a[text()='Register']")
    private WebElement registerLink;
    
    @FindBy(xpath =  "//h1[text()='Signing up is easy!']")
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

   
    
    public void clickRegisterLink_verifysectionname(String expectedvalue) throws InterruptedException
    {
    	
    	CommonMethodsUtils.highlightToElement(driver, registerLink);
    	Thread.sleep(3000);
    	registerLink.click();
    	String str = sectionNameTitle.getText().trim();
    	System.out.println("###################"+str);
    	Thread.sleep(3000);
    	CommonMethodsUtils.highlightToElement(driver, sectionNameTitle);
    	Assert.isTrue(str.equals(expectedvalue), "section name displayed incorrect", "section name displayed correctly");
    	
    	
    	
    }
    
    
    
    
    
    
}
