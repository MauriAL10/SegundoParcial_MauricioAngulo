import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Sidebar;
import utilities.DriverManager;

public class SidebarTests extends BaseTest {

    @Test
    public void verifyAllItemsReturnToHomePage(){
        //Login with standard user
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        //Click on cart to go to another page
        HomePage homepage = new HomePage(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCartButton();
        //Click on all items link
        Sidebar sidebar = new Sidebar(DriverManager.getDriver().driver);
        sidebar.clickOnSidebarButton();
        sidebar.clickOnAllItemsLink();
        //Verify that returns to homepage
        Assert.assertTrue(homepage.appLogoIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBackPackIsDisplayed());
        Assert.assertTrue(homepage.sauceLabsBikeLightIsDisplayed());
    }
}
