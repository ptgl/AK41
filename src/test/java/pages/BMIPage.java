package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BMIPage {
    WebDriver driver;
    By metricUnitTab = By.id("menuon");
    By clearButton = By.cssSelector("img.clearbtn");
    By ageTextBox = By.id("cage");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By femaleRadioButton = By.xpath("//input[@id='csex2']/following-sibling::span");
    By maleRadioButton = By.xpath("//input[@id='csex1']/following-sibling::span");
    By calculateButton = By.xpath("//input[@value='Calculate']");
    By resultLabel = By.cssSelector("div.rightresult div > b");

    public BMIPage(WebDriver driver) {
        this.driver = driver;
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
