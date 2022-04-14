package digitaldepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DDIntroPage extends DDBasePage{

    public DDIntroPage(AndroidDriver androidDriver) {
        super(androidDriver);
        System.out.println("DDIntroPage opened!");
    }

    public By skipButton = By.id("tr.com.turktelekom.dijitaldepo:id/skip_tv");
    public By loginButton = By.id("tr.com.turktelekom.dijitaldepo:id/loginBut");

    public void clickSkipButton(){
        System.out.println("clickSkipButton called!");
        click(skipButton);
    }

    public DDLoginPage clickLoginButton(){
        System.out.println("clickLoginButton called!");
        click(loginButton);
        return new DDLoginPage(androidDriver);
    }
}
