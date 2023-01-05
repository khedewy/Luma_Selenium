package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateMyProfile {
    private WebDriver driver;
    public UpdateMyProfile(WebDriver driver){
        this.driver = driver;
    }

    private final By Options = By.cssSelector("button.action.switch");
    private final By myAccount = By.linkText("My Account");
    private final By editAddressBtn = By.cssSelector(".box-billing-address > div:nth-child(3) > a:nth-child(1) > span:nth-child(1)");
    private final By regionTxt = By.id("region");
    private final By companyTxt = By.id("company");
    private final By zipCodeTxt = By.id("zip");
    private final By saveBtn = By.cssSelector("button.action.save.primary");
    private final By UpdateAssertionMessage = By.cssSelector(".message-success > div:nth-child(1)");

    public void navigateToUpdateProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Options));
        driver.findElement(Options).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myAccount)));
        driver.findElement(myAccount).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(editAddressBtn)));
        driver.findElement(editAddressBtn).click();
    }

    public void updateProfile(String region, String company, String zip){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(regionTxt)));

        driver.findElement(regionTxt).clear();
        driver.findElement(regionTxt).sendKeys(region);

        driver.findElement(companyTxt).clear();
        driver.findElement(companyTxt).sendKeys(company);

        driver.findElement(zipCodeTxt).clear();
        driver.findElement(zipCodeTxt).sendKeys(zip);

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();
    }

    public String getAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(UpdateAssertionMessage).getText();
    }
}
