package digitaldepo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DDBasePage {

    AndroidDriver<MobileElement> androidDriver;

    public DDBasePage(AndroidDriver<MobileElement> androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void click(By by){
        try {
            androidDriver.findElement(by).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key){
        try {
            androidDriver.findElement(by).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(By by){
        try {
            return androidDriver.findElement(by).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
