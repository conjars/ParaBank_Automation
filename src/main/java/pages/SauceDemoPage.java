package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SauceDemoPage  extends BasePage {

	public SauceDemoPage(WebDriver driver) {
		super(driver);
		
	}

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

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By totalPriceLabel = By.className("summary_total_label");
    private By finishButton = By.id("finish");
    private By orderConfirmation = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public void enterUsername(String username) {
        WebElement element = driver.findElement(usernameField);
        highlightElement(element);
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        highlightElement(element);
        element.sendKeys(password);
    }

    public void clickLogin() {
        WebElement element = driver.findElement(loginButton);
        highlightElement(element);
        element.click();
    }

    public void selectSortingOption(String option) {
        WebElement element = driver.findElement(sortDropdown);
        highlightElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public void addFirstProductToCart() {
        WebElement element = driver.findElement(addToCartButton);
        highlightElement(element);
        element.click();
    }

    public void clickCart() {
        WebElement element = driver.findElement(cartIcon);
        highlightElement(element);
        element.click();
    }

    public boolean isProductInCart() {
        return !driver.findElements(addToCartButton).isEmpty();
    }

    public void clickCheckout() {
        WebElement element = driver.findElement(checkoutButton);
        highlightElement(element);
        element.click();
    }

    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(firstNameField);
        highlightElement(element);
        element.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(lastNameField);
        highlightElement(element);
        element.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        WebElement element = driver.findElement(zipCodeField);
        highlightElement(element);
        element.sendKeys(zipCode);
    }

    public void clickContinue() {
        WebElement element = driver.findElement(continueButton);
        highlightElement(element);
        element.click();
    }

    public String getTotalPrice() {
        WebElement element = driver.findElement(totalPriceLabel);
        highlightElement(element);
        return element.getText();
    }

    public void clickFinish() {
        WebElement element = driver.findElement(finishButton);
        highlightElement(element);
        element.click();
    }

    public String getOrderConfirmationText() {
        WebElement element = driver.findElement(orderConfirmation);
        highlightElement(element);
        return element.getText();
    }

    public void clickBackHome() {
        WebElement element = driver.findElement(backHomeButton);
        highlightElement(element);
        element.click();
    }

    public void logout() {
        WebElement menu = driver.findElement(menuButton);
        highlightElement(menu);
        menu.click();

        WebElement logout = driver.findElement(logoutButton);
        highlightElement(logout);
        logout.click();
    }
}
