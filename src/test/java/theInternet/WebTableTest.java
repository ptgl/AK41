package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    @Test
    void findLargestDue(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> dues = driver.findElements(By.cssSelector("table#table1 tbody tr td:nth-child(4)"));
        List<Float> dueNumbers = dues
                                    .stream()
                                    .map(WebElement::getText)
                                    .map(t -> t.replace("$",""))
                                    .map(Float::parseFloat)
                                    .collect(Collectors.toList());
        //dueNumbers.forEach(System.out::println);
        Float maxDue = dueNumbers.stream().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
        int indexMaxDue = dueNumbers.indexOf(maxDue);
        String lastName = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(1)",indexMaxDue+1))).getText();
        String firstName = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(2)",indexMaxDue+1))).getText();

        Assert.assertEquals("Doe Jason",lastName+ " "+firstName);

        driver.quit();
    }
}
