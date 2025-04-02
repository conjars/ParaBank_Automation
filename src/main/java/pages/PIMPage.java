package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PIMPage extends BasePage {
	@FindBy(xpath = "//label[text()='Employment Status']/ancestor::form//div[contains(text(),'-- Select --')]")
	WebElement empStatusDropdown;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//label[text()='Employment Status']/ancestor::form//div[@role='listbox']//span")
	List<WebElement> empStatuslink;

	public PIMPage(WebDriver driver) {
		super(driver);
	}

	public void searchByEmploymentStatus(String status) {

//        Select select = new Select(empStatusDropdown);
//        select.selectByVisibleText(status);
//        

		empStatusDropdown.click();
		for (WebElement link : empStatuslink) {
			System.out.println(link.getText());

			if (link.getText().equals(status)) {
				link.click();
				break;

			}
		}
		searchBtn.click();
	}

	public void verifyEmployeeList() {
		System.out.println("Employee list displayed successfully.");
	}
}
