package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethodsUtils;

public class ComponentsPage extends BasePage{
    

    @FindBy(linkText = "Components")
    WebElement componentsTab;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    WebElement monitorsCategory;

    @FindBy(xpath = "//button[contains(@onclick,'cart')]")
    WebElement firstAddToCartButton;

    public ComponentsPage(WebDriver driver) {
        
        super(driver);
    }

    public void navigateToCategory(String tab, String category) {
    	CommonMethodsUtils.highlightToElement(driver, componentsTab);
        componentsTab.click();
        CommonMethodsUtils.highlightToElement(driver, monitorsCategory);
        monitorsCategory.click();
    }

    public void addFirstItemToCart() {
    	 CommonMethodsUtils.highlightToElement(driver, firstAddToCartButton);
        firstAddToCartButton.click();
    }
}
