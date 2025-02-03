package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}
