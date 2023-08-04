package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest {
    @Test
    void createANewTodoSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/vanillajs/");

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

        driver.quit();
    }
}
