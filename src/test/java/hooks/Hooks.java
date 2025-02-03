package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void setup() {
		String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/ChromeDriver/chromedriver.exe";
		// Ensure the file exists before setting the system property
		String browser = ConfigReader.getProperty("browser");
		String appUrl = ConfigReader.getEnvironmentURL();
		File driverFile = new File(chromeDriverPath);
		if (!driverFile.exists()) {
			
			throw new RuntimeException("ChromeDriver not found at: " + chromeDriverPath);
		}

		

		 // Select Browser Based on Config
        if (browser.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*"); // Fixes WebSocket connection issue
    		options.addArguments("--disable-extensions"); // Prevents browser conflicts
    		options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Invalid browser specified in config.properties");
        }
		//driver.manage().window().maximize();
		// implict  wait , explict wait fluent wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(appUrl);
		//driver.get("url");
	}
	
	//ParaBank_Automation/src/test/resources/ChromeDriver/chromedriver.exe

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
