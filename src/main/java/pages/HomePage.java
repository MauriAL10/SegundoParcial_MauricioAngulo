package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebElement cq = null;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartQuantity;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement sauceLabsBoltTShirtAddToCartButton;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement sauceLabsBoltTShirtRemoveButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement sauceLabsBikeLightAddToCartButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    WebElement sauceLabsBikeLightRemoveButton;
    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;

    @FindBy(id = "back-to-products")
    WebElement backToProductsButton;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement sauceLabsBackPack;

    @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
    WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
    WebElement sauceLabsBoltTShirt;

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(xpath = "//div[text()='29.99']")
    WebElement sauceLabsBackPackPriceLabel;

    @FindBy(xpath = "//div[text()='15.99']")
    WebElement sauceLabsBoltTShirtPriceLabel;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPricesLabel;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public boolean sauceLabsBackPackIsDisplayed(){
        boolean slbpIsDisplayed = sauceLabsBackPack.isDisplayed();
        return  slbpIsDisplayed;
    }

    public boolean sauceLabsBikeLightIsDisplayed(){
        boolean slblIsDisplayed = sauceLabsBikeLight.isDisplayed();
        return  slblIsDisplayed;
    }

    public boolean sauceLabsBoltTShirtIsDisplayed(){
        boolean slblIsDisplayed = sauceLabsBoltTShirt.isDisplayed();
        return  slblIsDisplayed;
    }
    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public boolean cartQuantityIsDisplayed(){
        boolean cqIsDisplayed = cartQuantity.isDisplayed();
        return cqIsDisplayed;
    }

    public String sauceLabsBackPackPrice(){
        String sauceLabsBackPackPrice = sauceLabsBackPackPriceLabel.getText();
        return sauceLabsBackPackPrice;
    }

    public String sauceLabsBoltTShirt(){
        String sauceLabsBoltTShirtPrice = sauceLabsBoltTShirtPriceLabel.getText();
        return sauceLabsBoltTShirtPrice;
    }
    public String getSauceLabsBackPackPriceText(){
        String labelPrice = sauceLabsBackPackPriceLabel.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(sauceLabsBackPackPriceLabel, "$29.99"));
        return labelPrice;
    }

    public String getSauceLabsBoltTShirtPriceText(){
        String labelPrice = sauceLabsBoltTShirtPriceLabel.getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(sauceLabsBoltTShirtPriceLabel, "$9.99"));
        return labelPrice;
    }
    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }
    public void clickOnAddSauceLabsBikeLightToCartButton(){
        sauceLabsBikeLightAddToCartButton.click();
    }
    public void clickOnAddSauceLabsBoltTShirtToCartButton(){
        sauceLabsBoltTShirtAddToCartButton.click();
    }

    public void clickOnSauceLabsBackPackLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sauceLabsBackPack));
        sauceLabsBackPack.click();
    }

    public void clickOnBackToProductsButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        backToProductsButton.click();
    }
    public void clickOnRemoveSauceLabsBackPackButton(){ sauceLabsBackPackRemoveButton.click();}
    public void clickOnRemoveSauceLabsBikeLightButton(){ sauceLabsBikeLightRemoveButton.click();}
    public void clickOnRemoveSauceLabsBoltTShirtButton(){ sauceLabsBoltTShirtRemoveButton.click();}

    public void clickOnCartButton(){ cartButton.click(); }

    public void selectProductFilter(String element){
        Select selectObject = new Select(productFilterDropDown);
        selectObject.selectByVisibleText(element);

    }

    public List<Double> getAllItemPrices(){
        List<Double> prices = new ArrayList<>();

        for (WebElement itemPrice: itemPricesLabel) {
            String itemPriceText = itemPrice.getText();
            StringBuilder sb = new StringBuilder(itemPriceText);
            sb.deleteCharAt(0);
            prices.add(Double.parseDouble(sb.toString()));
        }
        return prices;
    }
}
