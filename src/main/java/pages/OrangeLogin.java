package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLogin extends BasePage {
    public OrangeLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



    @FindBy(xpath = "//div//input[@name='username']") WebElement usernameField;
    @FindBy(xpath = "//div//input[@name='password']") WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;

   

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}

