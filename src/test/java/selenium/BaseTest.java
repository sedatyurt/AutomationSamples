package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver webDriver;
    public static String url = "http://the-internet.herokuapp.com/login";
    public static String username = "tomsmith";
    public static String password = "SuperSecretPassword!";

    @Parameters({ "browser" })
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser){

        switch (browser) {
            case "chrome" -> {
                System.out.println("Starting with Chrome Driver.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                webDriver = new ChromeDriver();
            }
            case "firefox" -> {
                System.out.println("Starting with Firefox Driver.");
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
            }
            default -> {
                System.out.println("Driver not undefined! Starting with Chrome Driver.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                webDriver = new ChromeDriver();
            }
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        System.err.println("webDriver closing...");
        webDriver.quit();
    }
}
