package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;
    Select select;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    private By checkOutBtn = By.cssSelector("ul.checkout > li:nth-child(1) > button:nth-child(1)");
    private final By companyTxt = By.name("company");
    private final By address1TxT = By.name("street[0]");
    private final By address2Txt = By.name("street[1]");
    private final By address3Txt = By.name("street[2]");
    private final By cityTxt = By.name("city");
    private final By country = By.name("country_id");
    private final By stateTxt = By.name("region");
    private final By postCodeTxt = By.name("postcode");
    private final By numberTxt = By.name("telephone");
    private final By radioBtn = By.name("ko_unique_3");
    private final By nextBtn = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button/span");
    private final By assertionMessage = By.cssSelector(".payment-method-title > label:nth-child(2) > span:nth-child(1)");
    private final By placeOrderBtn = By.cssSelector("button.action.primary.checkout");
    private final By placeOrderAssertion = By.xpath("/html/body/div[2]/main/div[1]/h1/span");


    public void navigateToShipAddress(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkOutBtn)));
        driver.findElement(checkOutBtn).click();
    }
    public void shippingAddress(String company, String address1, String address2, String address3, String city,
                               String state, String postCode, String number) {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(companyTxt)));

        driver.findElement(companyTxt).sendKeys(company);
        driver.findElement(address1TxT).sendKeys(address1);
        driver.findElement(address2Txt).sendKeys(address2);
        driver.findElement(address3Txt).sendKeys(address3);
        driver.findElement(cityTxt).sendKeys(city);
        select = new Select(driver.findElement(country));
        select.selectByVisibleText("Egypt");
        driver.findElement(stateTxt).sendKeys(state);
        driver.findElement(postCodeTxt).sendKeys(postCode);
        driver.findElement(numberTxt).sendKeys(number);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(radioBtn)));
        driver.findElement(radioBtn).click();
        driver.findElement(nextBtn).click();
    }

    public String ShippingAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return  driver.findElement(assertionMessage).getText();
    }

    public void clickPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(placeOrderBtn)));
        driver.findElement(placeOrderBtn).click();
    }

    public String placeOrderAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(placeOrderAssertion).getText();
    }

}
