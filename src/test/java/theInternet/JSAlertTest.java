package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JSAlertTest {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void verifyJSAlert(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
    }

    @Test
    void verifyJSConfirm(){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
    }

    @Test
    void verifyJSPrompt(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: Hello World");
        driver.quit();
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
