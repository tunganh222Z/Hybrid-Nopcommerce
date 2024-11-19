package pageObjects.orderCheckout;

import commons.BaseActions;
import commons.PageGenerator;
import commons.ShoppingCartPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.OrderDetailPageUI;

public class OrderDetailPageObject extends BaseActions {
    WebDriver driver;

    public OrderDetailPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get order total in order overview")
    public String getOrderTotalInOrderOverview() {
        waitForElementVisible(driver, OrderDetailPageUI.ORDER_TOTAL_OVERVIEW);
        return getWebElementText(driver, OrderDetailPageUI.ORDER_TOTAL_OVERVIEW);
    }

    @Step("Get billing address first name & last name in Confirm order")
    public String getBillingAddressFirstNameLastName() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_FIRSTNAME_LASTNAME);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_FIRSTNAME_LASTNAME);
    }

    @Step("Get billing address email in Confirm order")
    public String getBillingAddressEmail() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_EMAIL);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_EMAIL);
    }

    @Step("Get billing address phone number in Confirm order")
    public String getBillingAddressPhone() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_PHONE_NUMBER);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_PHONE_NUMBER);
    }

    @Step("Get billing address country in Confirm order")
    public String getBillingAddressCountry() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_COUNTRY);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_COUNTRY);
    }

    @Step("Get billing address country in Confirm order")
    public String getBillingAddressProvinceState() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_PROVINCE_STATE);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_PROVINCE_STATE);
    }

    @Step("Get billing address city in Confirm order")
    public String getBillingAddressCity() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_CITY);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_CITY);
    }

    @Step("Get billing address address1 in Confirm order")
    public String getBillingAddressAddress1() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_ADDRESS1);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_ADDRESS1);
    }

    @Step("Get billing address zip code postal in Confirm order")
    public String getBillingAddressZipCode() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_ZIP_POSTAL_CODE);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_ZIP_POSTAL_CODE);
    }

    @Step("Get billing address payment method in Confirm order")
    public String getBillingAddressPaymentMethod() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_BILLING_PAYMENT_METHOD);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_BILLING_PAYMENT_METHOD);
    }

    @Step("Get shipping address first name & last name in Confirm order")
    public String getShippingAddressFirstNameLastName() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_FIRSTNAME_LASTNAME);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_FIRSTNAME_LASTNAME);
    }

    @Step("Get shipping address email in Confirm order")
    public String getShippingAddressEmail() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_EMAIL);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_EMAIL);
    }

    @Step("Get shipping address phone number in Confirm order")
    public String getShippingAddressPhone() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_PHONE);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_PHONE);
    }

    @Step("Get shipping address country in Confirm order")
    public String getShippingAddressCountry() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_COUNTRY);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_COUNTRY);
    }

    @Step("Get shipping address province state in Confirm order")
    public String getShippingAddressProvinceState() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_PROVINCE_STATE);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_PROVINCE_STATE);
    }

    @Step("Get shipping address city in Confirm order")
    public String getShippingAddressCity() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_CITY);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_CITY);
    }

    @Step("Get shipping address address1 in Confirm order")
    public String getShippingAddressAddress1() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_ADDRESS1);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_ADDRESS1);
    }

    @Step("Get shipping address zip postal code in Confirm order")
    public String getShippingAddressZipCode() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_ZIP_POSTAL_CODE);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_ZIP_POSTAL_CODE);
    }

    @Step("Get shipping address shipping method in Confirm order")
    public String getShippingAddressMethod() {
        waitForElementVisible(driver, OrderDetailPageUI.CONFIRM_SHIPPING_METHOD);
        return getWebElementText(driver, OrderDetailPageUI.CONFIRM_SHIPPING_METHOD);
    }

    @Step("Get product sku in cart table by Product name {0}")
    public String getSKUProductByProductName(String productName) {
        waitForElementVisible(driver, OrderDetailPageUI.PRODUCT_SKU_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, OrderDetailPageUI.PRODUCT_SKU_BY_PRODUCT_NAME, productName);
    }

    @Step("Get product name in cart table")
    public String getProductName() {
        waitForElementVisible(driver, OrderDetailPageUI.PRODUCT_NAME_IN_CART_TABLE);
        return getWebElementText(driver, OrderDetailPageUI.PRODUCT_NAME_IN_CART_TABLE);
    }

    @Step("Get product price in cart table by Product name {0}")
    public String getProductPriceByProductName(String productName) {
        waitForElementVisible(driver, OrderDetailPageUI.PRODUCT_PRICE_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, OrderDetailPageUI.PRODUCT_PRICE_BY_PRODUCT_NAME, productName);
    }

    @Step("Get product total price in cart table by Product name {0}")
    public String getTotalProductPriceByProductName(String productName) {
        waitForElementVisible(driver, OrderDetailPageUI.PRODUCT_TOTAL_PRICE_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, OrderDetailPageUI.PRODUCT_TOTAL_PRICE_BY_PRODUCT_NAME, productName);
    }

    @Step("Get sub total price in total info")
    public String getSubTotalPrice() {
        waitForElementVisible(driver, OrderDetailPageUI.SUB_TOTAL_PRICE_IN_TOTAL_INFO);
        return getWebElementText(driver, OrderDetailPageUI.SUB_TOTAL_PRICE_IN_TOTAL_INFO);
    }

    @Step("Get total price in total info")
    public String getTotalPrice() {
        waitForElementVisible(driver, OrderDetailPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
        return getWebElementText(driver, OrderDetailPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
    }

    @Step("Click to reOrder button")
    public ShoppingCartPageObject clickToReOrder() {
        waitForElementClickable(driver, OrderDetailPageUI.REORDER_BUTTON);
        clickToElement(driver, OrderDetailPageUI.REORDER_BUTTON);
        return PageGenerator.getShoppingCartPage(driver);
    }
}
