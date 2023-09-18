package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TodoPage;

public class TodoTest extends BaseTest {
    TodoPage todoPage;


    @BeforeClass
    void setup(){
        Browser.launch("Chrome");
        todoPage = new TodoPage();



    }

    @BeforeMethod
    void open(){
        Browser.open("https://todomvc.com/examples/vanillajs/");
    }

    @Test
    void createANewTodoSuccessfully(){


        String taskName = "Task 1";
        todoPage.createNewTask(taskName);

        //Verify the new task display with correct text
        Assert.assertTrue(todoPage.isTaskLabelDisplayed(taskName));

        taskName = "Task 2";
        todoPage.createNewTask(taskName);
        WebElement lastTodoItem = todoPage.getTheLastTask();
        //Verify the newest task is shown at the end of the list
        Assert.assertEquals(lastTodoItem.getText(),taskName);

    }

    @Test
    void ableMarkATaskComplete(){
        todoPage.createNewTask("Task 3");
        todoPage.markTaskCompleted("Task 3");
        Assert.assertEquals(todoPage.isTaskLabelDisplayed("Task 3"), true);
    }

    @Test
    void deleteATaskSuccessfully(){
        todoPage.createNewTask("Task 4");
        int beforeCount = todoPage.getTheTotalTasks();
        todoPage.deleteATask("Task 4");
        int afterCount = todoPage.getTheTotalTasks();;

        Assert.assertEquals(afterCount, beforeCount-1);
    }

    @Test
    void updateATaskNameSuccessfully(){
        todoPage.createNewTask("Task 5");
        todoPage.updateTaskName("Task 5", "Updated Task");

        Assert.assertEquals(todoPage.isTaskLabelDisplayed("Updated Task"), true);
    }

}
