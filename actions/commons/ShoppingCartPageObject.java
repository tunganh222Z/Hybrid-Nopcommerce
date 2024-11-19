package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.categories.ProductPageObject;
import pageObjects.orderCheckout.CheckoutPageObject;
import pageUIs.BaseActionsPageUI;
import pageUIs.ShoppingCartPageUI;

import java.util.List;

public class ShoppingCartPageObject extends  BaseActions{
    public Object getNumberProductsInShoppingCartLink;
    WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get Added product name to cart by Product title column index")
    public String getAddedProductNameToCart() {
        String productColumnTitle = "Product(s)";

        waitForListElementsVisible(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_INDEX_BY_COLUMN, productColumnTitle);

        int index = getListElementsSize(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_INDEX_BY_COLUMN, productColumnTitle) + 1;

        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAME_BY_INDEX, String.valueOf(index));

        return getWebElementText(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAME_BY_INDEX, String.valueOf(index));
    }

    @Step("Click to edit product by product name {0}")
    public ProductPageObject clickToEditByProductName(String productName) {
        waitForElementClickable(driver, ShoppingCartPageUI.EDIT_BUTTON,productName);
        clickToElement(driver, ShoppingCartPageUI.EDIT_BUTTON,productName);
        return PageGenerator.getProductPage(driver);
    }

    @Step("Click to remove product by product name {0}")
    public void clickToRemoveButtonByProductName(String productName) {
        waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON,productName);
        clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON,productName);
    }

    @Step("Get empty message in Shopping cart page")
    public String getEmptyShoppingCartMsg() {
        waitForElementVisible(driver, ShoppingCartPageUI.EMPTY_SHOPPING_CART_MSG);
        return getWebElementText(driver, ShoppingCartPageUI.EMPTY_SHOPPING_CART_MSG);
    }

    @Step("Verify removed product un displayed")
    public boolean isAddedProductUnDisplayedByProductName(String productName) {
        return isELementUndisplayed(driver, ShoppingCartPageUI.PRODUCT_NAME,productName);
    }

    @Step("Get total price in total info")
    public String getTotalPriceInTotalInfo() {
        waitForElementVisible(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
        return getWebElementText(driver, ShoppingCartPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
    }

    @Step("Select gift wrapping item in dropdown {0}")
    public void selectGiftWrappingDropdown(String expectedGiftWrapping) {
        selectItemInDefaultDropdown(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, expectedGiftWrapping);
    }

    @Step("Click to estimate shipping button to open Shipping popup")
    public void clickToEstimateShipping() {
        waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
    }

    @Step("Select country in shipping popup")
    public void selectCountryInShipToDropdown(String country) {
        selectItemInDefaultDropdown(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN, country);
    }

    @Step("Select state in shipping popup")
    public void selectStateInShipToDropdown(String state) {
        selectItemInDefaultDropdown(driver, ShoppingCartPageUI.STATE_DROPDOWN, state);
    }

    @Step("Enter to Zip postal code textbox in shipping popup {0}")
    public void enterZipPostalCodeInShipToTextbox(String zipPostalCode) {
        waitForElementVisible(driver, ShoppingCartPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
    }

    @Step("Click to shipping method radio button in shipping popup {0}")
    public void clickToShippingMethodRadioButton(String shippingMethod) {
        String label = "Name";
        List<WebElement> shippingMethodColumnLabels= getListWebElements(driver, ShoppingCartPageUI.DYNAMIC_SHIPPINGMETHOD_COLUMN_BY_LABEL, label);

        int index = shippingMethodColumnLabels.size() +1;

        waitForElementClickable(driver, ShoppingCartPageUI.DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON, String.valueOf(index), shippingMethod);
        if (!getWebElement(driver, ShoppingCartPageUI.DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON, String.valueOf(index), shippingMethod).isSelected()){
            clickToElement(driver, ShoppingCartPageUI.DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON, String.valueOf(index), shippingMethod);
        }
    }

    @Step("Click to apply in shipping popup")
    public void clickToApply() {
        waitForElementClickable(driver, ShoppingCartPageUI.APPLY_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.APPLY_BUTTON);
    }

    @Step("Click to Agree check box in total info")
    public void clickToAgreeCheckbox() {
        waitForElementClickable(driver, ShoppingCartPageUI.AGREE_CHECKBOX);
        if (!getWebElement(driver, ShoppingCartPageUI.AGREE_CHECKBOX).isSelected()){
            clickToElement(driver, ShoppingCartPageUI.AGREE_CHECKBOX);
        }
    }

    @Step("Click to check out button")
    public CheckoutPageObject clickToCheckoutButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGenerator.getCheckoutPage(driver);
    }

    @Step("Wait Shipping pop up invisible")
    public void waitShippingPopupInvisible() {
        waitForElementInvisible(driver, ShoppingCartPageUI.SHIPPING_POPUP);
    }

    @Step("Enter to quantity textbox {0}")
    public void enterToQuantityTextbox(String quantity) {
        waitForElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
        sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, quantity);
    }
}
