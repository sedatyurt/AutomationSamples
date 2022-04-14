package selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void positiveLoginTest(){

        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(
                "Welcome to the Secure Area. When you are done click logout below.",
                webDriver.findElement(By.xpath("//h4[@class='subheader']")).getText());
    }

    @Test
    public void negativeLoginTest(){
        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPasswo");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(webDriver.findElement(By.id("flash-messages")).getText().contains("Your password is invalid!"));
    }
}
