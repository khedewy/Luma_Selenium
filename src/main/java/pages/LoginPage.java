package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("email");
    private final By passwordTxt = By.id("pass");
    private final By loginBtn = By.id("send2");
    private final By logAssertion = By.cssSelector("ul.header:nth-child(2) > li:nth-child(1) > span:nth-child(1)");

    public void EnterLoginData(String email,String password ){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String assertionText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logAssertion)));
        return driver.findElement(logAssertion).getText();
    }

}
