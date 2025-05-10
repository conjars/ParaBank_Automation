package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethodsUtils;

public class ComponentsPage extends BasePage{
    

    @FindBy(linkText = "Components")
    WebElement componentsTab;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    WebElement monitorsCategory;

    @FindBy(xpath = "//button[contains(@onclick,'cart')]")
    WebElement firstAddToCartButton;
    
    @FindBy(id = "input-limit")
    WebElement showDropdownLimit;
    
    @FindBy(xpath = "//button[@onclick=\"cart.add('42', '2');\"]")
    WebElement addtoCart;
    @FindBy(xpath = "//button[@onclick=\"wishlist.add('42');\"]")
    WebElement favIcon;
    
    @FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible\"]")
    WebElement sucessMessage;
    
    
  
    
  
    
  
    WebDriverWait wait;
    public ComponentsPage(WebDriver driver) {
        
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    public void selectShowLimit(String value) {
    	
    	Select select = new Select(showDropdownLimit);
    	select.selectByVisibleText(value);
    	wait.until(ExpectedConditions.visibilityOf(addtoCart));
    	CommonMethodsUtils.highlightToElement(driver, addtoCart);
    	
    	addtoCart.click();
    	wait.until(ExpectedConditions.visibilityOf(favIcon));
    	CommonMethodsUtils.highlightToElement(driver, favIcon);
    	favIcon.click();
    	wait.until(ExpectedConditions.visibilityOf(sucessMessage));
    	CommonMethodsUtils.highlightToElement(driver, sucessMessage);
    	
    	String str = sucessMessage.getText();
    	
    	System.out.println("#########################3"+str);
    	
    	
    }

    public void navigateToCategory(String tab, String category) {
    	CommonMethodsUtils.highlightToElement(driver, componentsTab);
        componentsTab.click();
        CommonMethodsUtils.highlightToElement(driver, monitorsCategory);
        monitorsCategory.click();
    }

    public void addFirstItemToCart(String value) {
//    	 CommonMethodsUtils.highlightToElement(driver, firstAddToCartButton);
//        //firstAddToCartButton.click();
//    	 //wait.until(ExpectedConditions.elementToBeClickable(showDropdownLimit)).click();
    	wait.until(ExpectedConditions.visibilityOf(showDropdownLimit));
        selectShowLimit(value);
    }
}
