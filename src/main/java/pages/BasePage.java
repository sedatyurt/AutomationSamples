package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void click(By by){
        try {
            webDriver.findElement(by).click();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key){
        try {
            webDriver.findElement(by).sendKeys(key);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getText(By by){
        try {
            return webDriver.findElement(by).getText();
        }   catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
