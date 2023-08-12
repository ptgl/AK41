package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BMIPage;

public class BMITest {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @Test
    public void bmiTestPOM() {
        BMIPage bmiPage = new BMIPage(driver);
        bmiPage.selectMetricTab();
        bmiPage.clearForm();
        bmiPage.fillCalculationForm("29", "Female","143", "45");
        Assert.assertEquals("BMI = 22 kg/m2",bmiPage.getResult());
    }

    @Test
    public void bmiTestLinear(){

        driver.findElement(By.id("menuon")).click();

        driver.findElement(By.cssSelector("img.clearbtn")).click();

        driver.findElement(By.id("cage")).sendKeys("29");

        driver.findElement(By.xpath("//input[@id='csex2']/following-sibling::span")).click();

        driver.findElement(By.id("cheightmeter")).sendKeys("143");

        driver.findElement(By.id("ckg")).sendKeys("45");

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        String result = driver.findElement(By.cssSelector("div.rightresult div > b")).getText();
        System.out.println(result);

        Assert.assertEquals("BMI = 22 kg/m2",result);
    }

    @AfterClass
    void teardown(){
        driver.quit();
    }
}
