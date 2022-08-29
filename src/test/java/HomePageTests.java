import com.google.common.collect.Ordering;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

import java.util.Collections;
import java.util.List;

public class HomePageTests extends BaseTest {
    @Test
    public void verifyBackToProductsReturnsToHomePage(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Click on Link of Sauce Labs Backpack
        HomePage homepage = new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnSauceLabsBackPackLink();
        homepage.clickOnBackToProductsButton();
        //Verify that the button returns to homepage
        Assert.assertTrue(homepage.appLogoIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBikeLightIsDisplayed());
    }
    /*
    @Test
    public void verifyHighToLowPriceItemsFilter(){
        // Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        // Filtering by price
        HomePage homepage= new HomePage(DriverManager.getDriver().driver);
        homepage.selectProductFilter("Price (high to low)");
        List<Double> prices = homepage.getAllItemPrices();
        Collections.sort(prices);
        Collections.reverse(prices);
        boolean pricesAreSorted = Ordering.reverse.isOrdered(prices);
        //Assert.assertTrue(pricesAreSorted);
    }
     */
}
