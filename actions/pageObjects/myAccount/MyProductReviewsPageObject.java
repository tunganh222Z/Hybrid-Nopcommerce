package pageObjects.myAccount;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    public MyProductReviewsPageObject (WebDriver driver){
        super(driver);
        this.driver =  driver;
    }

    @Step("Get Reviewed title")
    public String getReviewedTitle() {
        waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_TITLE);
        return getWebElementText(driver, MyProductReviewsPageUI.REVIEW_TITLE);
    }

    @Step("Get Reviewed Text content")
    public String getReviewedText() {
        waitForElementVisible(driver, MyProductReviewsPageUI.REVIEW_TEXT);
        return getWebElementText(driver, MyProductReviewsPageUI.REVIEW_TEXT);
    }

    @Step("Get Reviewed Date")
    public String getReviewedDate() {
        waitForElementVisible(driver, MyProductReviewsPageUI.REVIEWED_DATE);
        return getWebElementText(driver, MyProductReviewsPageUI.REVIEWED_DATE);
    }

    @Step("Get Reviewed Product name")
    public String getReviewedProductName() {
        waitForElementVisible(driver, MyProductReviewsPageUI.REVIEWED_PRODUCT);
        return getWebElementText(driver, MyProductReviewsPageUI.REVIEWED_PRODUCT);
    }
}
