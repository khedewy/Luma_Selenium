package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddReviewPage {
    private WebDriver driver;
    Actions actions;
    public AddReviewPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addReviewBtn = By.linkText("Be the first to review this product");
    private final By titleTxt = By.id("nickname_field");
    private final By summaryTxt = By.id("summary_field");
    private final By messageTxt = By.id("review_field");
    private final By rateOptions = By.id("Rating_4_label");
    private final By sendBtn = By.cssSelector(".submit");
    private final By assertionMessage = By.cssSelector(".message-success > div:nth-child(1)");

    public void addReview(String title,String summary,String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addReviewBtn)));
        driver.findElement(addReviewBtn).click();


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleTxt)));
        driver.findElement(titleTxt).sendKeys(title);

        actions = new Actions(driver);
        WebElement rate = driver.findElement(rateOptions);
        wait.until(ExpectedConditions.elementToBeClickable(rateOptions));
        actions.moveToElement(rate).perform();
        driver.findElement(rateOptions).click();


        driver.findElement(summaryTxt).sendKeys(summary);
        driver.findElement(messageTxt).sendKeys(message);

        wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        driver.findElement(sendBtn).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
