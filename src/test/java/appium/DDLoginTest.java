package appium;

import digitaldepo.DDHomePage;
import digitaldepo.DDIntroPage;
import digitaldepo.DDLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDLoginTest extends DDBaseTest{

    DDIntroPage ddIntroPage;
    DDLoginPage ddLoginPage;
    DDHomePage ddHomePage;

    @Test
    public void positiveLoginTest(){

        ddIntroPage = new DDIntroPage(androidDriver);
        ddIntroPage.clickSkipButton();
        ddLoginPage = ddIntroPage.clickLoginButton();

        ddHomePage = ddLoginPage.loginMethod(DDBaseTest.username, DDBaseTest.password);
        Assert.assertEquals("Dijital Depo", ddHomePage.getPageTitleText());
        System.out.println("Title of the page is " + ddHomePage.getPageTitleText());
    }
}
