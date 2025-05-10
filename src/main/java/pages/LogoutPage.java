package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    WebDriver driver;
    By dropdownButton = By.xpath("//i[@class='oxd-icon bi-caret-down-fill']");
    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        driver.findElement(dropdownButton).click();
        driver.findElement(logoutButton).click();
    }

    public void switchTabAndLogout() {
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        logout();
    }
}
