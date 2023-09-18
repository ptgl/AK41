package pages;

import common.Browser;
import org.openqa.selenium.*;

public class TodoPage {

    private WebDriver driver;
    private By taskNameField = By.cssSelector("input.new-todo");
    private By lastTask = By.cssSelector("ul.todo-list>li:last-child");


    public TodoPage() {
        this.driver = Browser.getDriver();
    }

    public void createNewTask(String taskName){
        driver.findElement(taskNameField).sendKeys(taskName, Keys.RETURN);
    }

    public WebElement getTheLastTask(){
        return driver.findElement(lastTask);
    }

    public void deleteATask(String taskName){
        Browser.hoverElement(By.xpath("//label[.='"+taskName+"']"));
        driver.findElement(By.xpath("//label[.='"+taskName+"']/following-sibling::button")).click();
    }

    public void updateTaskName(String taskName, String newName){
        Browser.doubleClickElement(By.xpath("//label[.='"+taskName+"']"));
        driver.findElement(By.cssSelector("input.edit"));
        WebElement editTaskBtn = driver.findElement(By.cssSelector("input.edit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=''", editTaskBtn);
        editTaskBtn.sendKeys(newName, Keys.RETURN);
    }

    public int getTheTotalTasks(){
        String total = driver.findElement(By.cssSelector(".todo-count strong")).getText();
        if(total.equalsIgnoreCase("")) return 0;
        return Integer.parseInt(total);
    }

    public void  markTaskCompleted(String taskName){
        driver.findElement(By.xpath("//label[.='"+taskName+"']/preceding-sibling::input[@type='checkbox']")).click();
        driver.findElement(By.linkText("Completed")).click();
    }

    public boolean isTaskLabelDisplayed(String taskName){
        WebElement taskLabel = driver.findElement(By.xpath("//ul//li//label[.='"+taskName+"']"));
        return taskLabel.isDisplayed();
    }
}
