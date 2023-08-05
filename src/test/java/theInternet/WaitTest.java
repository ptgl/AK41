package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test
    void implicitWait() throws InterruptedException {
        driver.findElement(By.cssSelector("#start button")).click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(),"Hello World!");
    }

    @Test
    void explicitWait(){
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String message = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish")))
                .getText();
        Assert.assertEquals(message,"Hello World!");


    }
}
