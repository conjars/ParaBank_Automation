package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountServicePage extends BasePage {

	public AccountServicePage(WebDriver driver) {
		super(driver);

	}

//	@FindBy(xpath = "//div[@id='leftPanel']//a")
//    private List<WebElement> leftnavLinks;

	public List<String> getAllNavigatioinLink() {

		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='leftPanel']//a"));

		List<String> lintext = new ArrayList<>();
		for(int i=0; i< elements.size(); i++)
		{
			lintext.add(elements.get(i).getText());
			
			System.out.println(elements.get(i).getText());
		}
		return lintext;

	}
	
	
	
	public  void clickLinkByName(String  lintext)
	{
		WebElement link = driver.findElement(By.xpath("//a[text()='"+lintext+"']"));
		link.click();
		// homework to verify the page name 
		
	}
	
	

}
