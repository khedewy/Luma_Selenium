package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private Robot robot;
    JavascriptExecutor js;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By registerBtn = By.linkText("Create an Account");
    private final By loginBtn = By.linkText("Sign In");
    private final By searchBox = By.id("search");
    private final By subscribeBox = By.id("newsletter");
    private final By subscriptionAssertion = By.cssSelector(".message-success > div:nth-child(1)");
    private final By searchAssertion = By.xpath("/html/body/div[2]/main/div[1]/h1/span");

    public RegisterPage navigateToRegisterPage(){
        driver.findElement(registerBtn).click();
        return new RegisterPage(driver);
    }
    public LoginPage navigateToLoginPage(){
        driver.findElement(loginBtn).click();
        return new LoginPage(driver);
    }

    public void searchForProduct(String product) throws AWTException {
        driver.findElement(searchBox).sendKeys(product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        driver.findElement(searchBox).clear();
    }

    public String getSearchAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchAssertion)));
        return driver.findElement(searchAssertion).getText();
    }

    public void subscribeForNewsLetter(String email) throws AWTException {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(subscribeBox));
        driver.findElement(subscribeBox).sendKeys(email);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String getSubscriptionAssertion(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(subscriptionAssertion));
        return driver.findElement(subscriptionAssertion).getText();
    }
}
