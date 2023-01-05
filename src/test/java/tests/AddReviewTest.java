package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductsPage;

import java.awt.*;
import java.time.Duration;

public class AddReviewTest extends TestBase{
    HomePage home;
    ProductsPage productsPage;
    AddReviewPage review;



    @Test
    public void searchForProduct() throws AWTException {
        home = new HomePage(driver);
        home.searchForProduct("short men");
        productsPage = new ProductsPage(driver);
        productsPage.chooseFirstProduct();
    }

    @Test(priority = 1)
    public void addReviewForProducts() throws InterruptedException {
        review = new AddReviewPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        review.addReview("Khedewy","this a review about product","This a very good product a I recommend that for u");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(review.getAssertionMessage(),"You submitted your review for moderation.");
    }

}
