package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DDBaseTest {

    public AndroidDriver<MobileElement> androidDriver;
    public static String username = "Your username";
    public static String password = "Your password";

    @BeforeMethod
    public void setUp(){
        System.out.println("Starting Dijital Depo App.");
        System.setProperty("file.encoding","UTF-8");
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "HVY0118608000169");
            caps.setCapability("udid", "HVY0118608000169");
            caps.setCapability("platformName","Android");
            caps.setCapability("platformVersion","10");
            caps.setCapability("appPackage", "tr.com.turktelekom.dijitaldepo");
            caps.setCapability("appActivity", "tr.com.turktelekom.dijitaldepo.MainActivity");
            caps.setCapability("autoAcceptAlerts", "true");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("unicodeKeyboard", true);
            caps.setCapability("resetKeyboard", true);
            caps.setCapability("automationName","uiautomator2");
            System.out.println(caps);

            Runtime.getRuntime().exec("adb shell am start -n io.appium.unlock/.Unlock");
            androidDriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        System.err.println("androidDriver closing...");
        androidDriver.quit();
    }
}
