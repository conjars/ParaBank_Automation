package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
	
	 public static String captureScreenshot(WebDriver driver) throws IOException {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String path = "reports/screenshots/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".png";
	        File destFile = new File(path);
	        Files.copy(srcFile.toPath(), destFile.toPath());
	        return path;
	    }

}
