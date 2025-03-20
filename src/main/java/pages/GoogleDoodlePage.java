package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    private By topicFilter = By.xpath("//span[contains(text(),'Topic')]");
    private By yearDropdown = By.xpath("//select[@name='date_like_year']");
    private By monthDropdown = By.xpath("//select[@name='date_like_month']");
    private By dayDropdown = By.xpath("//select[@name='date_like_day']");
    private By searchButton = By.xpath("//span[contains(text(),'Search')]");
    private By clearAllButton = By.xpath("//button[contains(text(),'Clear All')]");
    private By colorLabels = By.xpath("//label[contains(@class,'search-doodle__filter-panel__content-circle__input-label')]");
    private By topicOptions = By.xpath("//label[contains(@class,'search-doodle__tag-item as-input input-topic')]");
    private By colorFilter = By.xpath("//span[contains(text(),'Color')]");
    private String colorCheckboxXpath = "//input[@class='search-doodle__filter-panel__content-circle__input-checkbox' and @value='%s']";

    public GoogleDoodlePage(WebDriver driver) {
       super(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
       this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void clickLibrary() {
        driver.findElement(libraryLink).click();
    }

    public void clickColorFilter() {
        driver.findElement(colorFilter).click();
    }
    
    public void clickTopicFilter() {
        driver.findElement(topicFilter).click();
    }
    
    public void selectTwoTopic(String topic1, String topic2) {
        List<WebElement> colorElements = driver.findElements(topicOptions);

        WebElement firstColor = null, secondColor = null;

        for (WebElement colorElement : colorElements) {
            String colorText = colorElement.getText().trim();
            if (colorText.equalsIgnoreCase(topic1)) {
                firstColor = colorElement;
            }
            if (colorText.equalsIgnoreCase(topic2)) {
                secondColor = colorElement;
            }
        }

        if (firstColor != null) {
            firstColor.click();
        }

        if (secondColor != null) {
            secondColor.click();
        }
    }

    public void selectTwoColors(String color1, String color2) {
        List<WebElement> colorElements = driver.findElements(colorLabels);

        WebElement firstColor = null, secondColor = null;

        for (WebElement colorElement : colorElements) {
            String colorText = colorElement.getText().trim();
            if (colorText.equalsIgnoreCase(color1)) {
                firstColor = colorElement;
            }
            if (colorText.equalsIgnoreCase(color2)) {
                secondColor = colorElement;
            }
        }

        if (firstColor != null) {
            firstColor.click();
        }

        if (secondColor != null) {
            secondColor.click();
        }
    }

    public boolean isColorFilterApplied() {
        return driver.findElements(By.xpath("//label[contains(@class,'search-doodle__filter-panel__content-circle__input-label')]")).size() > 0;
    }
}
