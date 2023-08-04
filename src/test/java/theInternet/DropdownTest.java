package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest {

    @Test
    void validateOption1IsSelected(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        //dropdown.selectByValue("1");

        Assert.assertTrue(driver.findElement(By.xpath("//select/option[.='Option 1']")).isSelected());
        driver.quit();
    }

    @Test
    void selectMultipleOptionsSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select dropdown = new Select(driver.findElement(By.id("fruits")));

        if(dropdown.isMultiple()){
            System.out.println("able to select multiple");
        }else {
            System.out.println("Cannot select multiple");
        }

        dropdown.selectByVisibleText("Banana"); //index=0
        dropdown.selectByIndex(1); //text=Apple

        //dropdown.deselectByIndex(1);
        dropdown.deselectAll();
    }
}
