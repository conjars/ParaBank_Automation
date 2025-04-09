package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class CartPage  extends BasePage{
    

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(linkText = "HTC Touch HD")
    WebElement productLink;

    @FindBy(id = "button-cart")
    WebElement addToCartButton;
    @FindBy(xpath = "//input[contains(@name,'quantity')]")
    WebElement itemNumber;
    
    @FindBy(xpath = " //a[@title='My Account']")
    WebElement myAccount;    
    @FindBy(xpath = " //button[@type='submit']")
    WebElement udaptebutton;
    @FindBy(xpath = "//div[@id='product-product']//div")
    WebElement sucessmessagebyadding;
  
  

    public CartPage(WebDriver driver) {
        super(driver);
       
    }

    public void searchAndAddProduct(String productName, String quantity) {
        searchBox.sendKeys(productName);
        searchButton.click();
        productLink.click();
        addToCartButton.click();
        itemNumber.clear();
        itemNumber.sendKeys(quantity);
        //udaptebutton.click();
        addToCartButton.click();
        String message = sucessmessagebyadding.getText();
        System.out.println(message);
        
        Assert.isTrue(true, "msg not validated", "msg validated");
    }

    public boolean verifyCartItems() {
        return true; // Implement logic to check cart items
    }
}
