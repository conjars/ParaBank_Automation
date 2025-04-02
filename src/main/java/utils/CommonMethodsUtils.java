package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class CommonMethodsUtils {

	public static void waitForElementTobeClick(WebDriver driver, WebElement element, int timeeout)

	{
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeeout));
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void waitForElementTobeVisibilty(WebDriver driver, WebElement element, int timeeout)

	{
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeeout));
			 wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void waitForElementTobepresenceofElement(WebDriver driver, WebElement element, int timeeout)

	{
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeeout));
			 wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	

	public static void highlightToElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red';", ele);

	}
	
	
		
public static  String  takeScreenshot(WebDriver driver, String name)
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
	

	public static String getCellValue(Row row, Integer collIndex) {

		if (collIndex == null)
			return "";

		Cell cell = row.getCell(collIndex);
		if (cell == null)
			return "";

		switch (cell.getCellType()) {

		case STRING:
			return cell.getStringCellValue().trim();

		case NUMERIC:
			return cell.getStringCellValue().trim();

		case BOOLEAN:
			return cell.getStringCellValue().trim();

		default:
			return "";

		}

	}
}