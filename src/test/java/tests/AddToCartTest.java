package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;

import java.awt.*;
import java.time.Duration;

public class AddToCartTest extends TestBase{

    HomePage home;
    AddToCartPage add;

    @Test
    public void searchForProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("short men");
    }

    @Test(priority = 1)
    public void addToCart(){
        add = new AddToCartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        add.addFirstProduct();
    }
    @Test(priority = 2)
    public void validateFirstProductAdded(){
        add = new AddToCartPage(driver);
        Assert.assertEquals(add.getFirstProductAssertionMessage(),"Sol Active Short");
    }

    @Test(priority = 3)
    public void searchForSecondProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("pants");
    }

    @Test(priority = 4)
    public void addAgainToCart(){
        add = new AddToCartPage(driver);
        add.addSecondProduct();
    }
    @Test(priority = 5)
    public void validateSecondProductAdded(){
        add = new AddToCartPage(driver);
        Assert.assertEquals(add.getSecondProductAssertion(),"Livingston All-Purpose Tight");
    }
}
