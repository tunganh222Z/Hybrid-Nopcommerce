package pageObjects.categories;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.CompareProductsListPageUI;

public class CompareProductsListPageObject extends BaseActions {
    WebDriver driver;
    public CompareProductsListPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Verify added product to compare undisplayed")
    public boolean isAddedProductToCompareUnDisplayed(String productName) {
        return isELementUndisplayed(driver, CompareProductsListPageUI.DYNAMIC_PRODUCT_NAME, productName);
    }

    @Step("Get product price by Product name is {0}")
    public String getProductPriceByProductName(String productName) {
        waitForListElementsVisible(driver, CompareProductsListPageUI.DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME, productName);

        int index = getListElementsSize(driver, CompareProductsListPageUI.DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME, productName) + 1;

        waitForElementVisible(driver, CompareProductsListPageUI.PRODUCT_PRICE_BY_INDEX, String.valueOf(index));

        return getWebElementText(driver, CompareProductsListPageUI.PRODUCT_PRICE_BY_INDEX, String.valueOf(index));
    }

    @Step("Click to Clear list button")
    public void clickToClearListButton() {
        waitForElementClickable(driver, CompareProductsListPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductsListPageUI.CLEAR_LIST_BUTTON);
    }

    @Step("Get Empty Compare products message")
    public String getEmptyCompareProductsMessage() {
        sleepInSecond(1);
        waitForElementVisible(driver, CompareProductsListPageUI.EMPTY_COMPARE_PRODUCTS_MESSAGE);
        return getWebElementText(driver, CompareProductsListPageUI.EMPTY_COMPARE_PRODUCTS_MESSAGE);
    }

    @Step("Verify added product to compare displayed {0}")
    public boolean isAddedProductToCompareDisplayed(String productName) {
        if (isELementUndisplayed(driver, CompareProductsListPageUI.DYNAMIC_PRODUCT_NAME, productName) == false){
            return true;
        } else {
            return false;
        }
    }
}
