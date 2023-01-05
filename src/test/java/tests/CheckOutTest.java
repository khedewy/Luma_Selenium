package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class CheckOutTest extends TestBase{
    HomePage home;
    AddToCartPage add;
    CheckOutPage check;
    LoginPage log;


    @Test
    public void navigateToLogin(){
        home = new HomePage(driver);
        home.navigateToLoginPage();
    }
    @Test(priority = 1)
    public void testLogin() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.userData();
        log = new LoginPage(driver);
        log.EnterLoginData(data.email, data.password);
        //Assert.assertEquals(log.assertionText(),"Welcome, Mahmoud Khedewy!");
    }

    @Test(priority = 2)
    public void searchForProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("short men");
    }

    @Test(priority = 3)
    public void addToCart(){
        add = new AddToCartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        add.addFirstProduct();
    }
    @Test(priority = 4)
    public void completeShippingAddress(){
        check = new CheckOutPage(driver);
        check.navigateToShipAddress();
        check.shippingAddress("Microsoft","Egypt","Sohag","Maragha","Maragha","SOHAG",
                "1234","01205456789");
        Assert.assertEquals(check.ShippingAssertionMessage(),"Check / Money order");
    }

    @Test(priority = 5)
    public void completeCheckOut() throws InterruptedException {
        check = new CheckOutPage(driver);
        Thread.sleep(2000);
        check.clickPlaceOrder();
        Assert.assertEquals(check.placeOrderAssertionMessage(),"Thank you for your purchase!");
    }
}
