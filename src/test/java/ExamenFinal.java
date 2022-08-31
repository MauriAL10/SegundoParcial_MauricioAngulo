import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class ExamenFinal extends BaseTest{
    @Test
    public void testSegundoParcial(){
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
        //Verify that products were added
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBoltTShirtIsDisplayed());
        //Verify that prices are correct
        Assert.assertEquals("$29.99", homepage.sauceLabsBackPackPrice());
        Assert.assertEquals("$15.99", homepage.sauceLabsBoltTShirt());
        //Verify that cart quantity is correct
        Assert.assertEquals( "2", homepage.getCartIconText());
        //Remove items
        homepage.clickOnRemoveSauceLabsBackPackButton();
        homepage.clickOnRemoveSauceLabsBoltTShirtButton();
        //Verify that items are removed and cart quantity is empty
        try{
            Assert.assertFalse(homepage.cartQuantityIsDisplayed());
            Assert.assertFalse(homepage.sauceLabsBackPackIsDisplayed());
            Assert.assertFalse(homepage.sauceLabsBoltTShirtIsDisplayed());
        } catch (Exception e){}
    }
}
