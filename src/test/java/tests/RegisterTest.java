package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;
import java.time.Duration;

public class RegisterTest extends TestBase{
    HomePage home;
    RegisterPage register;

    @Test
    public void NavigateToRegister(){
        home = new HomePage(driver);
        home.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterUserData() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.userData();
        register = new RegisterPage(driver);
        register.EnterUserData(data.firstName, data.lastName, data.email, data.password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(register.getAssertionMessage(),"Thank you for registering with Fake Online Clothing Store.");

    }

}
