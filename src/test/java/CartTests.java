import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.Sidebar;
import utilities.DriverManager;

public class CartTests extends BaseTest {

    @Test
    public void verifyCartStatusAfterLogout(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Products added to cart
        HomePage homepage = new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnAddSauceLabsBikeLightToCartButton();
        //Logout
        Sidebar sidebar = new Sidebar(DriverManager.getDriver().driver);
        sidebar.clickOnSidebarButton();
        sidebar.clickOnLogoutLink();
        //Login with standard user
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Verify that the status of the cart was saved
        Assert.assertEquals( "2", homepage.getCartIconText());
        homepage.clickOnCartButton();
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBikeLightIsDisplayed());
    }

    @Test
    public void verifyItemsAreRemoved(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Products added to cart
        HomePage homepage = new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnAddSauceLabsBoltTShirtToCartButton();
        homepage.clickOnCartButton();
        //Products removed from cart
        homepage.clickOnRemoveSauceLabsBackPackButton();
        homepage.clickOnRemoveSauceLabsBoltTShirtButton();
        //Verify that cart is empty
        try{
            Assert.assertFalse(homepage.cartQuantityIsDisplayed());
        } catch (Exception e){}
    }
}
