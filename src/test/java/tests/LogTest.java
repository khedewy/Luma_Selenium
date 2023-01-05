package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class LogTest extends TestBase{
    HomePage home;
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
        Assert.assertEquals(log.assertionText(),"Welcome, Mahmoud Khedewy!");
    }
}
