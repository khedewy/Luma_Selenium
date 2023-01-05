package tests;

import data.RegisterData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToWishListPage;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class AddToWishListTest extends TestBase{
    HomePage home;
    LoginPage log;
    AddToWishListPage wishListPage;

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void UserLogin() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.userData();
        home = new HomePage(driver);
        home.navigateToLoginPage();
        log = new LoginPage(driver);
        log.EnterLoginData(data.email, data.password);
    }

    @Test(priority = 1)
    public void searchForProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("jacket");
    }

    @Test(priority = 2)
    public void addToWishList(){
        wishListPage = new AddToWishListPage(driver);
        wishListPage.addFirstProductToWishList();
    }
    @Test(priority = 3)
    public void validationOfFirstProduct(){
        wishListPage = new AddToWishListPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(wishListPage.validateFirstProductAdded(),"Lando Gym Jacket has been added to your Wish List. Click here to continue shopping.");
    }

    @Test(priority = 4)
    public void searchForAnotherProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("shirt");
    }

    @Test(priority = 5)
    public void addSecondProductToWishList(){
        wishListPage = new AddToWishListPage(driver);
        wishListPage.AddSecondProduct();
    }

    @Test(priority = 6)
    public void validateSecondProductAdded(){
        wishListPage = new AddToWishListPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(wishListPage.secondProductAssertion(),"Balboa Persistence Tee");
    }
}
