package pageObjects.admin.catalog;

import commons.BaseActionsAdmin;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.catalog.ProductsPageUI;

public class ProductsPageObject extends BaseActionsAdmin {
    WebDriver driver;

    public ProductsPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("enter product name to textbox {0}")
    public void enterToProductNameTextbox(String productName) {
        waitForElementVisible(driver, productName);
        sendkeyToElement(driver, ProductsPageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    @Step("click to search button")
    public void clickToSearchButton() {
        waitForElementClickable(driver, ProductsPageUI.SEARCH_BUTTON);
        clickToElement(driver, ProductsPageUI.SEARCH_BUTTON);
    }

    @Step("Verify only one product is displayed in product table")
    public boolean isOnlyProductDisplayedInProductTable() {
    }

    @Step("Select item in category dropdown {0}")
    public void selectItemInCategoryDropdown(String itemCategory) {
        waitForElementClickable(driver, ProductsPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductsPageUI.CATEGORY_DROPDOWN,itemCategory);
    }

    @Step("Click to uncheck sub categories checkbox")
    public void clickToUncheckSubCategoriesCheckbox() {
        waitForElementClickable(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
        if (isElementSelected(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX)){
            clickToElement(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
        }
    }

    @Step("Verify product table empty")
    public boolean isProductTableEmpty() {

    }

    @Step("Get no data message")
    public String getNoDataMessage() {
        waitForElementVisible(driver, ProductsPageUI.NO_DATA_MESSAGE);
        return  getWebElementText(driver, ProductsPageUI.NO_DATA_MESSAGE);
    }

    @Step("Click to check sub-categories checkbox")
    public void clickToCheckSubCategoriesCheckbox() {
        waitForElementClickable(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
        if (!isElementSelected(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX)){
            clickToElement(driver, ProductsPageUI.SUB_CATEGORY_CHECKBOX);
        }
    }

    @Step("Select item in manufacturer dropdown {0}")
    public void selectItemInManufacturerDropdown(String itemManufacturer) {
        waitForElementClickable(driver, ProductsPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductsPageUI.MANUFACTURER_DROPDOWN,itemManufacturer);
    }

    @Step("Get product name in product table")
    public String getProductNameInProductTable() {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_NAME);
        return  getWebElementText(driver, ProductsPageUI.PRODUCT_NAME);
    }

    @Step("Get product publish status in product table")
    public String getProductPublishedStatusInProductTable() {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_PUBLISH_STATUS);
        return  getWebElementText(driver, ProductsPageUI.PRODUCT_PUBLISH_STATUS);
    }

    @Step("Get product stock in product table")
    public String getProductStockInProductTable() {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_STOCK);
        return  getWebElementText(driver, ProductsPageUI.PRODUCT_STOCK);
    }

    @Step("Get product price in product table")
    public String getProductPriceInProductTable() {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_PRICE);
        return  getWebElementText(driver, ProductsPageUI.PRODUCT_PRICE);
    }

    @Step("Get product SKU in product table")
    public String getProductSKUInProductTable() {
        waitForElementVisible(driver, ProductsPageUI.PRODUCT_SKU);
        return  getWebElementText(driver, ProductsPageUI.PRODUCT_SKU);
    }
}
