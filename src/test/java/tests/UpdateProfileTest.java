package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UpdateMyProfile;

import java.io.IOException;

public class UpdateProfileTest extends TestBase{
    HomePage home;
    LoginPage log;
    UpdateMyProfile update;

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
    public void navigateToUpdateProfile(){
        update = new UpdateMyProfile(driver);
        update.navigateToUpdateProfile();
        update.updateProfile("Ciro","Vodafone","9876");
        Assert.assertEquals(update.getAssertionMessage(),"You saved the address.");
    }
}
