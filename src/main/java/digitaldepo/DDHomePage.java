package digitaldepo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DDHomePage extends DDBasePage{

    public DDHomePage(AndroidDriver androidDriver) {
        super(androidDriver);
        System.out.println("DDHomePage opened!");
    }

    By pageTitle = By.id("tr.com.turktelekom.dijitaldepo:id/toolbarTitle");

    public String getPageTitleText(){
        System.out.println("getPageTitleText called!");
        return getText(pageTitle);
    }
}
