package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SauceDemoPage extends BasePage{
   

    public SauceDemoPage(WebDriver driver) {
    	super(driver);
    }

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
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void selectSortingOption(String option) {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText(option);
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isProductInCart() {
        return !driver.findElements(addToCartButton).isEmpty();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPriceLabel).getText();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getOrderConfirmationText() {
        return driver.findElement(orderConfirmation).getText();
    }

    public void clickBackHome() {
        driver.findElement(backHomeButton).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
    }
}
