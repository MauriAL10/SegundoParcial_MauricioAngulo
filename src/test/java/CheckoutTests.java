import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class CheckoutTests extends BaseTest {
    @Test
    public void verifyCheckoutProcedure(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Products added to cart
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCartButton();
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        //Checkout procedure
        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.setFirstNameTextBox("Mauricio");
        checkoutPage.setLastNameTextBox("Angulo");
        checkoutPage.setPostalCodeTextBox("0000");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        checkoutPage.clickOnFinishButton();
        //Verify that the icon of checkout is displayed
        Assert.assertTrue(checkoutPage.checkoutIconIsDisplayed());
        //Back Home
        checkoutPage.clickOnBackHomeButton();
        Assert.assertTrue(homepage.appLogoIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBikeLightIsDisplayed());
        try{
            Assert.assertFalse(homepage.cartQuantityIsDisplayed());
        } catch (Exception e){}
    }

    @Test
    public void verifyCheckoutWithoutItems(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Click on cart empty
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnCartButton();
        //Checkout procedure
        CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.setFirstNameTextBox("Mauricio");
        checkoutPage.setLastNameTextBox("Angulo");
        checkoutPage.setPostalCodeTextBox("0000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        //Verify that the icon of checkout is displayed
        Assert.assertTrue(checkoutPage.checkoutIconIsDisplayed());
    }
}
