package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {

    @Test
    void validateCheckboxIsChecked(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes>input:first-child"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes>input:last-child"));

        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());
        check(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());

        driver.quit();
    }

    @Test
    void validateCheckboxIsUnChecked(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes>input:first-child"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes>input:last-child"));

        unCheck(checkbox1);
        Assert.assertFalse(checkbox1.isSelected());
        unCheck(checkbox2);
        Assert.assertFalse(checkbox2.isSelected());

        driver.quit();
    }

    void check(WebElement checkbox){
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }

    void unCheck(WebElement checkbox){
        if(checkbox.isSelected()){
            checkbox.click();
        }
    }
}
