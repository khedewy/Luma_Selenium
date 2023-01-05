package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {

    public static WebDriver driver;
    private String Url = "https://magento.softwaretestingboard.com/";

    @BeforeClass
    @Parameters({"browser"})
    public void setDriver(@Optional("chrome")  String browserName){
        if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(Url);
        }

        else if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(Url);
        }
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }

    @AfterMethod
    public void takeScreenShots(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot screenshot =(TakesScreenshot) driver;
            File file = screenshot.getScreenshotAs(OutputType.FILE);
            Files.move(file,new File("resources/screenshots"+result.getName()+".png"));
        }

    }
}
