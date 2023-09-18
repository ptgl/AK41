package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class Browser {
    private static WebDriver driver;
    private static Actions action;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void launch(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(browser+" is not supported!!");
        }
        action = new Actions(driver);
    }

    public static void open(String url){
        driver.get(url);
    }
    public static void quit(){
        driver.quit();
    }

    public static void captureScreenshot(String filename) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot) driver);
        File file = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./target/screenshot/"+filename);
        FileUtils.copyFile(file, destFile);
    }

    public static void hoverElement(By locator){
        action.moveToElement(driver.findElement(locator)).perform();
    }

    public static void doubleClickElement(By locator){
        action.doubleClick(driver.findElement(locator)).perform();
    }




}
