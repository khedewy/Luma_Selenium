package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.awt.*;

public class SearchTest extends TestBase{
    HomePage home;

    @Test
    public void searchForJackets() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("Jackets");
        Assert.assertEquals(home.getSearchAssertionMessage(),"Search results for: 'Jackets'");
    }
}
