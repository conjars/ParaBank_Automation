package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;
import utils.CommonMethodsUtils;

public class WindowhandlePage extends BasePage {
	WebDriver driver;

	String mainWindowhandle;

	public WindowhandlePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// PageFactory.initElements(driver, this);
		this.mainWindowhandle = driver.getWindowHandle();
	}

	@FindBy(xpath = "//h1[contains(text(),'Window Handles Practice')]")
	private WebElement windowhandletitlePage;

	@FindBy(xpath = "//button[@id='newWindowBtn']")
	private WebElement newWindowButton;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstNamefield;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastNamefield;

	@FindBy(xpath = "//input[@id='malerb']")
	private WebElement genderselectionradio;

	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> langCheckBoxselection;
	
	@FindBy(xpath = "//div[@class=\"basicControls\"]//input[@class=\"bcCheckBox\"]")
	private List<WebElement> labels;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[@id='registerbtn']")
	private WebElement RegisterButton;

	public void enterFristname(String firstName) {

		CommonMethodsUtils.highlightToElement(driver, firstNamefield);
		firstNamefield.sendKeys(firstName);

	}

	public void enterlastname(String lastName) {

		CommonMethodsUtils.highlightToElement(driver, lastNamefield);
		lastNamefield.sendKeys(lastName);

	}

	public void selectGender(String gender) {

		if (gender.equalsIgnoreCase("Male")) {
			CommonMethodsUtils.highlightToElement(driver, genderselectionradio);
			genderselectionradio.click();
		} else {
			// female radio button click function
		}

	}
	
	
	public  static Map<String, WebElement> getCheckBoxes(WebDriver driver)
	{
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox"));
		
		Map<String, WebElement> map = new HashMap<>();
		for(WebElement ele : checkBoxes)
		{
			String labeltext = ele.findElement(By.xpath("following-sibling::text()[1]")).getText().trim();
			map.put(labeltext, ele);
		}
		
		return map;
		
	}

//	public void selectlang(List<String> languages) {
//		
//		for(int i =0; i< langCheckBoxselection.size(); i++)
//		{
//			String labeltext = labels.get(i).getText().trim();
//			if (languages.contains(labeltext)) {
//				
//				langCheckBoxselection.get(i).click();
//			}
//			
//		}
		
		
//		for (WebElement checkbox : langCheckBoxselection) {
//			String lang = checkbox.getAttribute("value").trim();
//
//			if (languages.contains(lang)) {
//				//CommonMethodsUtils.highlightToElement(driver, genderselectionradio);
//				checkbox.click();
//			}
//
//		}
	//}
	
	public void enteremailAdd(String email) {

		CommonMethodsUtils.highlightToElement(driver, emailfield);
		emailfield.sendKeys(email);

	}
	
	
	public void enterpassword(String password) {

		CommonMethodsUtils.highlightToElement(driver, passwordfield);
		passwordfield.sendKeys(password);

	}
	
	public void registerbutton() {

		CommonMethodsUtils.highlightToElement(driver, RegisterButton);
		RegisterButton.click();

	}
	
	
	
	


	public void switchToNewWindowandMaximizethescreen() {

		Set<String> windowHandles = driver.getWindowHandles();

		// [101,102]

		for (String handle : windowHandles) {

			if (!handle.equals(mainWindowhandle)) {

				driver.switchTo().window(handle);
				driver.manage().window().maximize();

				return;
			}

		}
		throw new RuntimeException("new window not found");
	}

	public void switchToMainWindow() {

		driver.switchTo().window(mainWindowhandle);
	}

	public String getPageTitlte() {
		System.out.println("########################" + driver.getTitle());
		return driver.getTitle();
	}

	public void verifyButtonWithtext(String buttonName) {

		if (newWindowButton.getText().trim().equals(buttonName.trim())) {
			// Assert.isTrue(actualbuttontext.equals(buttonName), "verifyed the button is
			// incorrect", "verifyted the button name is correct");
			CommonMethodsUtils.highlightToElement(driver, newWindowButton);
			System.out.println(newWindowButton.getText().trim());
			newWindowButton.click();

		}

	}

	public void verifyTheTitleOfthepage(String tilte) {
		String actualText = windowhandletitlePage.getText();

		CommonMethodsUtils.highlightToElement(driver, windowhandletitlePage);

		System.out.println("##################" + actualText);
		WebElement ele = driver.findElement(By.xpath("//h1[contains(text(),'Window Handles Practice')]"));
		// CommonMethodsUtils.waitForElementTobepresenceofElement(driver, ele, 20);

		Assert.isTrue(actualText.equals(tilte), "Title is not verifyed sucessfully", "title is verifyed sucessfully");

		// taking screenshot , scroll to the element, window handle , entering data
		// through json .

	}

}
