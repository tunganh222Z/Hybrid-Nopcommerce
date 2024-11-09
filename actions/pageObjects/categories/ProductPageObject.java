package pageObjects.categories;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.categories.ProductPageUI;

import java.time.Duration;
import java.util.List;

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

    @Step("Click to Add to wishlist button")
    public void clickToAddToWishlistButton() {
        waitForElementClickable(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    @Step("Select Processor dropdown {0}")
    public void selectProcessorDropdown(String processor) {
        selectItemInDefaultDropdown(driver, ProductPageUI.PROCESSOR_DROPDOWN, processor);
    }

    @Step("Select Ram dropdown {0}")
    public void selectRAMDropdown(String ram) {
        selectItemInDefaultDropdown(driver, ProductPageUI.RAM_DROPDOWN, ram);
    }

    @Step("Select HDD radio button by HDD label {0}")
    public void selectHDDRadiobutton(String hdd) {
        waitForElementClickable(driver,ProductPageUI.HDD_RADIO_BUTTON_BY_LABEL,hdd);
        if (!isElementSelected(driver, ProductPageUI.HDD_RADIO_BUTTON_BY_LABEL,hdd)){
            clickToElement(driver, ProductPageUI.HDD_RADIO_BUTTON_BY_LABEL,hdd);
        }
    }

    @Step("Select OS radio button by OS label {0}")
    public void selectOSRadiobutton(String os) {
        waitForElementClickable(driver, ProductPageUI.OS_RADIO_BUTTON_BY_LABEL,os );
        if (!isElementSelected(driver, ProductPageUI.OS_RADIO_BUTTON_BY_LABEL,os)){
            clickToElement(driver, ProductPageUI.OS_RADIO_BUTTON_BY_LABEL,os);
        }
    }
    @Step("Click to select software list")
    public void selectSoftwareCheckbox(List<String> softwareList) {
        List<WebElement> listCheckboxElement = getListWebElements(driver, ProductPageUI.SOFTWARE_CHECKBOX);

        for (WebElement checkboxElement : listCheckboxElement){
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(checkboxElement));

            if (checkboxElement.isSelected()){
                checkboxElement.click();
            }
        }

        for (String software : softwareList){
            waitForElementClickable(driver, ProductPageUI.DYNAMIC_SOFTWARE_CHECKBOX, software);

            if (!isElementSelected(driver, ProductPageUI.DYNAMIC_SOFTWARE_CHECKBOX, software)){
                clickToElement(driver, ProductPageUI.DYNAMIC_SOFTWARE_CHECKBOX, software);
            }
        }
    }

    @Step("Click to add product to cart")
    public void clickToAddToCartButton() {
        waitForElementClickable(driver, ProductPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
    }

    @Step("Click to update product order")
    public void clickToUpdateButton() {
        waitForElementClickable(driver, ProductPageUI.UPDATE_BUTTON);
        clickToElement(driver, ProductPageUI.UPDATE_BUTTON);
    }

    @Step("Enter quantity to quantity textbox {0}")
    public void enterToQuantityTextbox(String quantity) {
        waitForElementVisible(driver, ProductPageUI.QUANTITY_TEXTBOX);
        sendkeyToElement(driver, ProductPageUI.QUANTITY_TEXTBOX, quantity);
    }

    @Step("Get product price in product page")
    public String getProductPrice() {
        waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
        return getWebElementText(driver, ProductPageUI.PRODUCT_PRICE);
    }
}
