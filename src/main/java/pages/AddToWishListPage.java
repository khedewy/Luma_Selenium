package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToWishListPage {
    private final WebDriver driver;
    public AddToWishListPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstProduct = By.linkText("Lando Gym Jacket");
    private final By addToWishListBtn = By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[5]/div/a[1]");
    private final By firstProductAssertion  = By.cssSelector(".message-success > div:nth-child(1)");

    public void addFirstProductToWishList(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));
        driver.findElement(firstProduct).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToWishListBtn)));
        driver.findElement(addToWishListBtn).click();
    }

    public String validateFirstProductAdded(){
        return driver.findElement(firstProductAssertion).getText();
    }

    // second product

    private final By secondProduct = By.linkText("Balboa Persistence Tee");
    public void AddSecondProduct(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(secondProduct)));

        driver.findElement(secondProduct).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToWishListBtn)));
        driver.findElement(addToWishListBtn).click();
    }

    public String secondProductAssertion(){
        return driver.findElement(secondProduct).getText();
    }


}
