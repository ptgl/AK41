package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    void openBrowser(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
}
