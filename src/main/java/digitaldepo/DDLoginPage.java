package digitaldepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DDLoginPage extends DDBasePage{

    public DDLoginPage(AndroidDriver androidDriver) {
        super(androidDriver);
        System.out.println("DDLoginPage opened!");
    }

    public By usernameField = By.id("tr.com.turktelekom.dijitaldepo:id/eMailText");
    public By passwordField = By.id("tr.com.turktelekom.dijitaldepo:id/passwordText");
    public By loginButton = By.id("tr.com.turktelekom.dijitaldepo:id/loginBut");

    public DDHomePage loginMethod(String username, String password){
        System.out.println("loginMethod called!");
        sendKey(usernameField, username);
        sendKey(passwordField, password);
        click(loginButton);
        return new DDHomePage(androidDriver);
    }
}
