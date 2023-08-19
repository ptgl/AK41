package pageObjectModel;
import common.BaseTest;
import common.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BMIPage;

import java.io.File;
import java.io.IOException;

public class BMITest extends BaseTest {

    @Parameters({"browser"})
    @BeforeClass
    void setUp(String browser) {
        Browser.launch(browser);
        Browser.open("https://www.calculator.net/bmi-calculator.html");
    }

    @DataProvider
    Object[][] data (){
        return new Object[][]{
                {"29", "Female","143", "45", "BMI = 22 kg/m2"},
                {"30", "Male","163", "55", "BMI = 20.7 kg/m2"},
                {"65", "Female","143", "50", "BMI = 24.5 kg/m2"}
        };
    }

    @Test(dataProvider = "data")
    public void bmiTestPOM(String age, String gender, String height, String weight, String expectedResult) {
        BMIPage bmiPage = new BMIPage();
        bmiPage.selectMetricTab();
        bmiPage.clearForm();
        bmiPage.fillCalculationForm(age, gender,height, weight);
        Assert.assertEquals(expectedResult,bmiPage.getResult());
    }

    @Test
    public void bmiTestLinear(){

        WebDriver driver = Browser.getDriver();

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





}
