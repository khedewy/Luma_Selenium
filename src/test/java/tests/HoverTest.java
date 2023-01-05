package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverOver;

public class HoverTest extends TestBase {
    HoverOver hover;

    @Test
    public void HoverOverMen(){
        hover = new HoverOver(driver);
        hover.HooverOverMenProducts();
        Assert.assertEquals(hover.getMenAssertionMessage(),"Jackets");
    }

    @Test(priority = 1,dependsOnMethods = "HoverOverMen")
    public void hoverHoverGearProducts(){
        hover = new HoverOver(driver);
        hover.hoverOverGear();
        Assert.assertEquals(hover.getGearAssertionMessage(),"Bags");
    }

}
