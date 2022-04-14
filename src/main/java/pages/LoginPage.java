package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        System.out.println("LoginPage opened!");
    }

    By flashMessage  = By.id("flash");
    By usernameLabel = By.id("username");
    By passwordLabel = By.id("password");
    By loginButton   = By.xpath("//button[@type='submit']");

    public SecureAreaPage beLogin(String username, String password){
        System.out.println("beLogin method called!");
        sendKey(usernameLabel, username);
        sendKey(passwordLabel, password);
        click(loginButton);
        return new SecureAreaPage(webDriver);
    }

    public String getLogoutMessage(){
        System.out.println("getLogoutMessage method called!");
        return getText(flashMessage);
    }
}
