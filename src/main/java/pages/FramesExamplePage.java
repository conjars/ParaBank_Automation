package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.failsafe.internal.util.Assert;
import utils.CommonMethodsUtils;

public class FramesExamplePage extends BasePage {

	public FramesExamplePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//a[text()='Frames']")
    public WebElement frameLink;
	
	
	@FindBy(xpath = "//h3[text()='Frames']")
    public WebElement frameTitle;
	@FindBy(xpath = "//a[text()='iFrame']")
    public WebElement iframeLink;
	
	
	
	public  void veifyframeButtonClick()
	{
		CommonMethodsUtils.highlightToElement(driver, frameLink);		
		frameLink.click();
		
		CommonMethodsUtils.highlightToElement(driver, frameTitle);
		Assert.isTrue(frameTitle.getText().equals("Frames"), "Frames is not verifyed ", "Frames is verifyed");
		
		
	}
	
	public void userhanleNestedFrameLink()
	{
		
		CommonMethodsUtils.highlightToElement(driver, iframeLink);	
		iframeLink.click();
		driver.switchTo().frame("mce_0_ifr");
		String str = driver.findElement(By.xpath("//body[@id='tinymce']//p")).getText();
		System.out.println("pring the value inside the frames "+str);
		//driver.findElement(By.id("tinymce")).sendKeys("test example");		
		driver.switchTo().defaultContent();
		
		
		
		
		
	}
	
	
	
	
	

}
