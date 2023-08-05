package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestFrameTest {
    @Test
    void verifyFrame() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().parentFrame(); //back to top
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().parentFrame(); //back to top
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.switchTo().defaultContent(); //back to origin
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());

        driver.quit();
    }
    }
