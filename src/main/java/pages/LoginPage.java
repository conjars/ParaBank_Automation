package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;
import utils.ConfigReader;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@name='username']")
    private WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
    private WebElement password;
	@FindBy(xpath = "//input[@value='Log In']")
    private WebElement LogIn;
	
	@FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
    private WebElement HomePage;
	
	
	public  void verifyHomePage(String expcted)
	{
		String actual = HomePage.getText();
		System.out.println("Expected value "+actual);
		
		Assert.isTrue(actual.equals(expcted), "Home page is not verifyed succesfully", "Home page  verifyed  sucessfully");
		
		
		
	}
	
	 		
	
	
	public void enterUsername()
	{
		userName.sendKeys(ConfigReader.getProperty("username"));
		
	}
	
	public void enterpassword()
	{
		password.sendKeys(ConfigReader.getProperty("password"));
		
	}
	
	public void verifyClickButton()
	{
		LogIn.click();
		
	}
	
	
	

	
	

}
