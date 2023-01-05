package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCompareListPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    public AddToCompareListPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstProduct = By.linkText("Dash Digital Watch");
    private final By addBtn = By.cssSelector(".tocompare");
    private final By showCompareList = By.linkText("comparison list");

    public void addFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(firstProduct));
        driver.findElement(firstProduct).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addBtn)));
        driver.findElement(addBtn).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(showCompareList).click();
    }

    public String validateFirstProduct(){

        return  driver.findElement(firstProduct).getText();
    }

}
