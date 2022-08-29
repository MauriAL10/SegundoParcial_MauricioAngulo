package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;

    @FindBy(id="last-name")
    WebElement lastNameTextBox;

    @FindBy(id = "postal-code")
    WebElement postalCodeTextBox;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "pony_express")
    WebElement checkoutIcon;

    @FindBy(tagName = "h3")
    WebElement checkoutInformationError;

    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

    public void setFirstNameTextBox(String firstName){ firstNameTextBox.sendKeys(firstName); }

    public void setLastNameTextBox(String lastName){
        lastNameTextBox.sendKeys(lastName);
    }

    public void setPostalCodeTextBox(String postalCode){
        postalCodeTextBox.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }
    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }


    public boolean checkoutIconIsDisplayed() {
        boolean checkoutIconIsDisplayed = checkoutIcon.isDisplayed();
        return checkoutIconIsDisplayed;
    }
    public String getCheckoutInformationErrorMessage(){
        String errorMessage = checkoutInformationError.getText();
        return errorMessage;
    }
}
