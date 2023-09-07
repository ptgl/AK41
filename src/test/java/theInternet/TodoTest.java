package theInternet;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TodoTest {

    WebDriver driver;
    Actions action;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        action = new Actions(driver);
    }

    @BeforeMethod
    void open(){
        driver.get("https://todomvc.com/examples/vanillajs/");
    }

    @Test
    void createANewTodoSuccessfully(){


        String taskName = "Task 1";
        driver.findElement(By.cssSelector("input.new-todo")).sendKeys(taskName, Keys.RETURN);

        //Verify the new task display with correct text
        WebElement taskLabel = driver.findElement(By.xpath("//ul//li//label[.='"+taskName+"']"));
        Assert.assertTrue(taskLabel.isDisplayed());

        taskName = "Task 2";
        driver.findElement(By.cssSelector("input.new-todo")).sendKeys(taskName, Keys.RETURN);
        WebElement lastTodoItem = driver.findElement(By.cssSelector("ul.todo-list>li:last-child"));
        //Verify the newest task is shown at the end of the list
        Assert.assertEquals(lastTodoItem.getText(),taskName);

    }

    @Test
    void ableMarkATaskComplete(){
        driver.findElement(By.cssSelector("input.new-todo")).sendKeys("Task 3", Keys.RETURN);
        driver.findElement(By.xpath("//label[.='Task 3']/preceding-sibling::input[@type='checkbox']")).click();
        driver.findElement(By.linkText("Completed")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[.='Task 3']")).isDisplayed(), true);
    }

    @Test
    void deleteATaskSuccessfully(){
        driver.findElement(By.cssSelector("input.new-todo")).sendKeys("Task 4", Keys.RETURN);
        String beforeCount = driver.findElement(By.cssSelector(".todo-count strong")).getText();
        action.moveToElement(driver.findElement(By.xpath("//label[.='Task 4']"))).perform();
        driver.findElement(By.xpath("//label[.='Task 4']/following-sibling::button")).click();
        String afterCount = driver.findElement(By.cssSelector(".todo-count strong")).getText();
        if(afterCount.equalsIgnoreCase("")){
            afterCount = "0";
        }

        Assert.assertEquals(Integer.parseInt(afterCount), Integer.parseInt(beforeCount)-1);
    }

    @Test
    void updateATaskNameSuccessfully(){
        driver.findElement(By.cssSelector("input.new-todo")).sendKeys("Task 6", Keys.RETURN);
        action.doubleClick(driver.findElement(By.xpath("//label[.='Task 6']"))).perform();
        driver.findElement(By.cssSelector("input.edit"));
        WebElement editTaskBtn = driver.findElement(By.cssSelector("input.edit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=''", editTaskBtn);
        editTaskBtn.sendKeys("Updated Task", Keys.RETURN);

        Assert.assertEquals(driver.findElement(By.xpath("//label[.='Updated Task']")).isDisplayed(), true);
    }

    @AfterMethod
    void close(){
       driver.quit();
    }
}
