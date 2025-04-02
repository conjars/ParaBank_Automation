package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
	@FindBy(xpath = "//div[@id='app']//ul//li//span") List<WebElement> menuLinks;
    @FindBy(xpath = "//p[contains(text(),'mand')]") WebElement welcomeMenu;
    @FindBy(xpath = "//a[text()='Logout']") WebElement logoutLink;
    public DashboardPage(WebDriver driver) {
       super(driver);
        
    }
    
  
  

    public void printAllMenuLinks() {
        for (WebElement link : menuLinks) {
            System.out.println(link.getText());
        }
        System.out.println("Total menu links: " + menuLinks.size());
    }

    public void logout() {
        welcomeMenu.click();
        logoutLink.click();
    }
}
