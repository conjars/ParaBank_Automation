package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleDoodlePage extends BasePage {
  
	WebDriverWait wait;
	 JavascriptExecutor jsExecutor;
    // Locators
    private By libraryLink = By.xpath("//a[contains(text(),'Library')]");
    private By dateFilter = By.xpath("//span[contains(text(),'Date')]");
    private By topicLink = By.xpath("//span[contains(text(),'Topic')]");
    private By yearDropdown = By.xpath("//select[@name='date_like_year']");
    private By monthDropdown = By.xpath("//select[@name='date_like_month']");
    private By dayDropdown = By.xpath("//select[@name='date_like_day']");
    private By searchButton = By.xpath("//span[contains(text(),'Search')]");
    private By clearAllButton = By.xpath("//button[contains(text(),'Clear All')]");
    private By colorLabels = By.xpath("//div[@class=\"search-doodle__filter-panel__content-circle\"]//label");
    private By topicOptions = By.xpath("//label[@class=\"search-doodle__tag-item as-input input-topic\" and //span[contains(text(),'Animation')]]");
    private By colorLink = By.xpath("//span[contains(text(),'Color')]");
    private String colorCheckboxXpath = "//input[@class='search-doodle__filter-panel__content-circle__input-checkbox' and @value='%s']";
    private By filteredDoodles = By.xpath("//div[@class=\"search-doodle__box__tag has-elements\"]//span"); // Update this based on actual DOM

    public GoogleDoodlePage(WebDriver driver) {
       super(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
       this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void highlightElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // ✅ Clicks on the Library link, ensuring visibility
    public void clickLibrary() {
        WebElement libraryElement = wait.until(ExpectedConditions.elementToBeClickable(libraryLink));
        highlightElement(libraryElement); // Highlight before clicking
        libraryElement.click();
    }
    
 // ✅ Function to select "Color" or "Topic" link
    public void selectFilter(String filterType) {
        By filterLocator = filterType.equalsIgnoreCase("Color") ? colorLink : topicLink;
        WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(filterLocator));
        
        highlightElement(filterElement); // Highlight before clicking
        try {
            filterElement.click(); // Normal click
        } catch (Exception e) {
            jsExecutor.executeScript("arguments[0].click();", filterElement); // JavaScript Click as fallback
        }
    }
 // ✅ Function to check if doodles are filtered based on Color or Topic
    public boolean isFilterApplied() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(filteredDoodles));
            return driver.findElements(filteredDoodles).size() > 0;
        } catch (TimeoutException e) {
            return false; // No filtered doodles found
        }
    }

    
    public void selectTwoTopic(String color1, String color2) {
        wait.until(ExpectedConditions.presenceOfElementLocated(topicOptions));
        List<WebElement> colorElements = driver.findElements(topicOptions);
        
        
        for(int i =0; i< 2 ; i++)
        {
        	 highlightElement(colorElements.get(i));
        	colorElements.get(i).click();
        }
        
        
    }
    // ✅ Selects two colors using JavaScript for stability
    public void selectTwoColors(String color1, String color2) {
        wait.until(ExpectedConditions.presenceOfElementLocated(colorLabels));
        List<WebElement> colorElements = driver.findElements(colorLabels);
        for(int i =0; i< 2 ; i++)
        {
        	 highlightElement(colorElements.get(i));
        	colorElements.get(i).click();
        }
//        WebElement firstColor = null, secondColor = null;
//
//        for (WebElement colorElement : colorElements) {
//            String colorText = colorElement.getText().trim();
//            if (colorText.equalsIgnoreCase(color1)) {
//                firstColor = colorElement;
//            }
//            if (colorText.equalsIgnoreCase(color2)) {
//                secondColor = colorElement;
//            }
//        }
//
//        if (firstColor != null) {
//            highlightElement(firstColor);
//            jsExecutor.executeScript("arguments[0].click();", firstColor); // ✅ JavaScript Click
//        }
//
//        if (secondColor != null) {
//            highlightElement(secondColor);
//            jsExecutor.executeScript("arguments[0].click();", secondColor); // ✅ JavaScript Click
//        }
    }
}
