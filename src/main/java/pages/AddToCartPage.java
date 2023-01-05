package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    // first product
    private final By firstProduct = By.linkText("Sol Active Short");
    private final By size = By.id("option-label-size-143-item-176");
    private final By color = By.id("option-label-color-93-item-50");
    private final By addToCartBtn = By.id("product-addtocart-button");
    private final By showCartList = By.linkText("shopping cart");


    public void addFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(firstProduct));

        driver.findElement(firstProduct).click();
        driver.findElement(size).click();
        driver.findElement(color).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCartBtn)));
        driver.findElement(addToCartBtn).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(showCartList)));
        driver.findElement(showCartList).click();
    }

    public String getFirstProductAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));
        return driver.findElement(firstProduct).getText();
    }

    // second product

    private final By secondProduct = By.linkText("Livingston All-Purpose Tight");
    private final By size2 = By.id("option-label-size-143-item-176");
    private final By color2 = By.id("option-label-color-93-item-58");

    public void addSecondProduct(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(secondProduct)));
        driver.findElement(secondProduct).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(size2)));
        driver.findElement(size2).click();
        driver.findElement(color2).click();
        driver.findElement(addToCartBtn).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(showCartList)));
        driver.findElement(showCartList).click();
    }

    public String getSecondProductAssertion(){
        return driver.findElement(secondProduct).getText();
    }
}
