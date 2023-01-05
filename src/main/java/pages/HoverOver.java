package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverOver {
    private WebDriver driver;
    Actions actions;
    public HoverOver(WebDriver driver){
        this.driver = driver;
    }

    private final By men = By.id("ui-id-5");
    private final By top = By.id("ui-id-17");
    private final By jacket = By.id("ui-id-19");
    private final By menAssertion = By.xpath("/html/body/div[2]/main/div[1]/h1/span");

    public void HooverOverMenProducts(){
        actions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement menProducts = driver.findElement(men);
        WebElement topProducts = driver.findElement(top);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(menProducts).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions.moveToElement(topProducts).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(jacket).click();
    }

    public String getMenAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(menAssertion)));
        return driver.findElement(menAssertion).getText();
    }
    // gear
    private final By gear = By.id("ui-id-6");
    private final By bags = By.id("ui-id-25");
    private final By GearAssertion = By.xpath("/html/body/div[2]/main/div[1]/h1/span");

    public void hoverOverGear(){
        actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gear)));

        WebElement gearProduct = driver.findElement(gear);
        actions.moveToElement(gearProduct).perform();


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(gear)));
        driver.findElement(bags).click();
    }

    public String getGearAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(GearAssertion)));
        return driver.findElement(GearAssertion).getText();
    }

}
