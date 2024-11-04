package pageObjects.categories;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.ProductPageUI;

public class ProductPageObject extends BaseActions {
    WebDriver driver;
    public ProductPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get Date time reviewed")
    public String getDateReviewed() {
        return getDateTimeNow("MM/d/yyyy h:mm a");
    }

    @Step("Enter to Review Title textbox is {0}")
    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    @Step("Enter to Review Text textarea is {0}")
    public void enterToReviewTextTextArea(String reviewContent) {
        waitForElementVisible(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA);
        sendkeyToElement(driver, ProductPageUI.REVIEW_TEXT_TEXTAREA,reviewContent);
    }

    @Step("Select product rating by number rating from 1 - 5. Selected number rating is {0}")
    public void selectRatingByNumberRate(int numberRating) {
        if (numberRating >= 1 && numberRating <=5 ){

            waitForElementClickable(driver, ProductPageUI.PRODUCT_RATING_BY_NUMBER_RATING, String.valueOf(numberRating));
            clickToElement(driver, ProductPageUI.PRODUCT_RATING_BY_NUMBER_RATING, String.valueOf(numberRating));
        } else {
            throw new RuntimeException("please rating select rating from 1 - 5");
        }
    }

    @Step("Click to Submit Review button")
    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public void clickToAddToWishlistButton() {
        waitForElementClickable(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }
}
