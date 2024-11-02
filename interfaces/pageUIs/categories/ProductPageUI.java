package pageUIs.categories;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class ProductPageUI  {
    public static final String REVIEW_TITLE_TEXTBOX = "css=input#AddProductReview_Title";
    public static final String REVIEW_TEXT_TEXTAREA = "css=textarea#AddProductReview_ReviewText";
    public static final String PRODUCT_RATING_BY_NUMBER_RATING = "xpath=//div[@class='rating-options']/input[@value='%s']";
    public static final String SUBMIT_REVIEW_BUTTON = "css=button#add-review";
}
