package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonMethodsUtils;

public class WebTablePage extends BasePage {

	CommonMethodsUtils cmu = new CommonMethodsUtils();

	public WebTablePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(text(),'Automation Practice | WebTable')]")
	private WebElement titleofAutomationPtactice; 
	
	private By tableRows = By.xpath("//table[@id='countries']//tbody//tr");
	private  By tableColumns = By.xpath("//table[@id='countries']//tbody//tr[1]//td");
	private  By checkboxes = By.xpath("//table[@id='countries']//tbody//tr//td[1]//input[@type='checkbox']");
	
	public  void  printTheWebtableData()
	{
		
		List<WebElement> rows = driver.findElements(tableRows);
		int rowCount = rows.size();
		
		for( int i =1; i<=rowCount; i++) {
			
			List<WebElement> columns = driver.findElements(By.xpath("//table[@id='countries']//tbody//tr["+i+"]/td"));
			
			for(WebElement col : columns)
			{
				System.out.println(col.getText() +  "|");
			}
			
			System.out.println();
			
		}
		
		
	}
	
	
	public  void CheckTheFristFiveCheckboxes() throws InterruptedException
	{
	List<WebElement> checkboxele = driver.findElements(checkboxes);	 
	
	
	for(int i=0 ; i< 5 && i < checkboxele.size(); i++)
	{
		if(!checkboxele.get(i).isSelected())
		{
			checkboxele.get(i).click();
		}
	}
	
	Thread.sleep(60000);
		
		
	}
	

	
	
	
	
	
	
	

}
