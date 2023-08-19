package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BMIPage {
    private WebDriver driver;
    private By metricUnitTab = By.id("menuon");
    private By clearButton = By.cssSelector("img.clearbtn");
    private By ageTextBox = By.id("cage");
    private By heightTextBox = By.id("cheightmeter");
    private By weightTextBox = By.id("ckg");
    private By femaleRadioButton = By.xpath("//input[@id='csex2']/following-sibling::span");
    private By maleRadioButton = By.xpath("//input[@id='csex1']/following-sibling::span");
    private By calculateButton = By.xpath("//input[@value='Calculate']");
    private By resultLabel = By.cssSelector("div.rightresult div > b");

    public BMIPage() {
        this.driver = Browser.getDriver();
    }

    public void selectMetricTab(){
        driver.findElement(metricUnitTab).click();
    }

    public void clearForm(){
        driver.findElement(clearButton).click();
    }

    public void fillCalculationForm(String age, String gender, String height, String weight){
        driver.findElement(ageTextBox).sendKeys(age);

        if(gender.equals("Female")){
            driver.findElement(femaleRadioButton).click();
        }else{
            driver.findElement(maleRadioButton).click();
        }

        driver.findElement(heightTextBox).sendKeys(height);

        driver.findElement(weightTextBox).sendKeys(weight);

        driver.findElement(calculateButton).click();
    }

    public String getResult(){
        String result = driver.findElement(resultLabel).getText();
        return result;
    }
}
