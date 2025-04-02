package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage  extends BasePage{
    

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    @FindBy(linkText = "HTC Touch HD")
    WebElement productLink;

    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
       
    }

    public void searchAndAddProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
        productLink.click();
        addToCartButton.click();
    }

    public boolean verifyCartItems() {
        return true; // Implement logic to check cart items
    }
}
