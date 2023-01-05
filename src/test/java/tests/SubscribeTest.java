package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.awt.*;

public class SubscribeTest extends TestBase{
    HomePage home;

    @Test
    public void testSubscription() throws AWTException {
        home = new HomePage(driver);
        home.subscribeForNewsLetter("MahmoudKhedewyE2001@gmail.com");
        Assert.assertEquals(home.getSubscriptionAssertion(),"Thank you for your subscription.");
    }
}
