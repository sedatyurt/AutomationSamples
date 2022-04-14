package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTestsPOM extends BaseTest{

    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Test
    public void positiveLoginTest(){
        loginPage = new LoginPage(webDriver);
        secureAreaPage = loginPage.beLogin(BaseTest.username, BaseTest.password);
        Assert.assertTrue(secureAreaPage.getLoginMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void logoutTest(){
        loginPage = new LoginPage(webDriver);
        secureAreaPage = loginPage.beLogin(BaseTest.username, BaseTest.password);

        loginPage = secureAreaPage.beLogout();
        Assert.assertTrue(loginPage.getLogoutMessage().contains("You logged out of the secure area!"));

    }
}
