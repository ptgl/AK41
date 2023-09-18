package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    @AfterMethod
    public void captureScreen(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()){
            System.out.println("Test failed");
            Browser.captureScreenshot(testResult.getMethod().getMethodName()+  "-"+System.currentTimeMillis()+".png");
        }
    }

    @AfterClass
    protected void teardown(){
        Browser.quit();
    }
}
