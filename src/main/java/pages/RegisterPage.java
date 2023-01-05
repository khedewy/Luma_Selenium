package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    private final By firstNameTxt = By.id("firstname");
    private final By lastNameTxt = By.id("lastname");
    private final By newRegisterBtn = By.id("is_subscribed");
    private final By emailTxt = By.id("email_address");
    private final By passwordTxt = By.id("password");
    private final By confirmPassword = By.id("password-confirmation");
    private final By createAccountButton = By.cssSelector("button.action.submit.primary");
    private final By assertionMessage = By.cssSelector(".message-success > div:nth-child(1)");
    private final By OptionsList = By
            .cssSelector("ul.header:nth-child(2) > li:nth-child(2) > span:nth-child(1) > button:nth-child(1)");
    private final By logOutOption = By.linkText("Sign Out");
    private final By logOutAssertion = By.cssSelector("ul.header:nth-child(2) > li:nth-child(1) > span:nth-child(1)");

    public void EnterUserData(String firstName, String lastName, String email, String password){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(newRegisterBtn).click();
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPassword).sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        driver.findElement(createAccountButton).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }

}
