package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {
    WebDriver driver;
    Actions action;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        action = new Actions(driver);
    }

    @Test
    void hover() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> avatars = driver.findElements(By.cssSelector("div.figure img"));
        for (WebElement e:avatars){
            Thread.sleep(1000);
            action.moveToElement(e).perform();
        }

    }

    @Test
    void rightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        action.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
    }
}
