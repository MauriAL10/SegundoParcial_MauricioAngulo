package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sidebar {
    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sidebarButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsLink;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public Sidebar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSidebarButton() { sidebarButton.click(); }
    public void clickOnLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public void clickOnAllItemsLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(allItemsLink));
        allItemsLink.click();
    }
}
