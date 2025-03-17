package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


public class ButtonsPage extends BasePage {

	public ButtonsPage(WebDriver driver) {
		super(driver);
		
	}

    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButton = By.xpath("//button[text()='Delete']");
    private By checkbox = By.xpath("//form[@id='checkboxes']/input[1]");
    private By dropdown = By.id("dropdown");

    
    // Highlight Function inside Page Class
    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        try {
            Thread.sleep(500); // Pause for better visibility
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickAddElement() {
    	
        driver.findElement(addButton).click();
    }

    public void clickDeleteElement() {
        driver.findElement(deleteButton).click();
    }

    public void selectCheckbox() {
        WebElement check = driver.findElement(checkbox);
        if (!check.isSelected()) {
            check.click();
        }
    }

    public void selectDropdownOption(String option) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(option);
    }

    public String getSelectedDropdownOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}
