package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCompareListPage;
import pages.HomePage;

import java.awt.*;
import java.time.Duration;

public class AddToCompareListTest extends TestBase{
    HomePage home;
    AddToCompareListPage compare;

    @Test
    public void searchForProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("sports watch");
    }

    @Test(priority = 1)
    public void addToCompareList(){
        compare = new AddToCompareListPage(driver);
        compare.addFirstProduct();
    }

    @Test(priority = 2)
    public void validateFirstProductAdded(){
        compare = new AddToCompareListPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(compare.validateFirstProduct(),"Dash Digital Watch");
    }
}
