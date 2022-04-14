package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage{

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
        System.out.println("SecureAreaPage opened!");
    }

    By flashMessage  = By.id("flash");
    By logoutButton  = By.xpath("//a[@href='/logout']");

    public String getLoginMessage(){
        System.out.println("getLoginMessage method called!");
        return getText(flashMessage);
    }

    public LoginPage beLogout(){
        System.out.println("beLogout method called!");
        click(logoutButton);
        return new LoginPage(webDriver);
    }
}
