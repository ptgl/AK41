package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    /*
    * Login successful with valid credentials
        1. Open browser
        2. Navigate to https://the-internet.herokuapp.com/login
        3. Fill in username with tomsmith
        4. Fill in the password with SuperSecretPassword!
        5. Click on Login button
        6. And the home page is appear
    *
    * */
    @Test
    void successfullyWithCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
        //driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type=submit]")).click();
        //driver.findElement(By.xpath("//*[.=' Login']")).click();
        //driver.findElement(By.xpath("//button[contains(.,' Login')]")).click();

        String message = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(message.contains("You logged into a secure area!"));
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        driver.quit();

    }
}
