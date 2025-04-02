package pages;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollPage extends BasePage {

	public ScrollPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By HoverLink = By.xpath("//a[text()='Hovers']");
	By imageHover1 = By.xpath("//div[@class='figure'][1]");
	By profileText = By.xpath("//div[@class='figcaption']//h5[1]");

	public void scrolltoHoverLink() {

		WebElement ele = driver.findElement(HoverLink);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

		driver.findElement(HoverLink).click();

	}

	public void hoverImage() {

		WebElement element = driver.findElement(imageHover1);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}
	
	public boolean isprofileNameIsDisplayed()
	{
		
		return driver.findElement(profileText).isDisplayed();
		
	}
	
		public String  takeScreenshot(WebDriver driver, String name)
	{
		//  cucumer html reporting 
		try {
			
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("screenshot/"+name + ".png");
			FileUtils.copyFile(src, dest);
			
			byte[] filecontent = FileUtils.readFileToByteArray(dest);
			return "data:image/png;base64,"+
			Base64.getEncoder().encodeToString(filecontent);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	}


