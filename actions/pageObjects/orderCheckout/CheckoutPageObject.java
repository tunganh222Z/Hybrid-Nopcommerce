package pageObjects.orderCheckout;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.CheckoutPageUI;

public class CheckoutPageObject extends BaseActions {
    WebDriver driver;

    public CheckoutPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Click to un-check same address checkbox")
    public void clickToUncheckShipToSameAddressCheckbox() {
        waitForElementClickable(driver, CheckoutPageUI.SAME_ADDRESS_CHECKBOX);
        if (isElementSelected(driver, CheckoutPageUI.SAME_ADDRESS_CHECKBOX)){
            clickToElement(driver, CheckoutPageUI.SAME_ADDRESS_CHECKBOX);
        }
    }

    @Step("Enter to billing firstname textbox {0}")
    public void enterToBillingFirstnameTextbox(String firstName) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter to billing last name textbox {0}")
    public void enterToBillingLastnameTextbox(String s) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_LAST_NAME_TEXTBOX, s);
    }

    @Step("Enter to billing email textbox {0}")
    public void enterToBillingEmailTextbox(String email) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_EMAIL_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_EMAIL_TEXTBOX, email);
    }

    @Step("Select country in Country dropdown {0}")
    public void selectBillingCountryDropdown(String country) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.COUNTRY_DROPDOWN, country);
    }

    @Step("Select state province in state province dropdown {0}")
    public void selectBillingStateProvinceDropdown(String stateProvince) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.STATE_PROVINCE_DROPDOWN, stateProvince);
    }

    @Step("Enter to billing city textbox {0}")
    public void enterToBillingCityTextbox(String city) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_CITY_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_CITY_TEXTBOX, city);
    }

    @Step("Enter to billing address1 textbox {0}")
    public void enterToBillingAddress1Textbox(String address1) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_ADDRESS1_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_ADDRESS1_TEXTBOX, address1);
    }

    @Step("Enter to billing zip postal code textbox {0}")
    public void enterToBillingZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
    }

    @Step("Enter to billing phone number textbox {0}")
    public void enterToBillingPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, CheckoutPageUI.BILLING_PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.BILLING_PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    @Step("Click to continue button")
    public void clickToContinueButton() {
        waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON);
    }

    @Step("Wait loading next step invisible")
    public void isLoadingNextStepInvisible() {
        waitForListElementsInvisible(driver, CheckoutPageUI.LOADING_NEXT_STEP);
    }

    @Step("Select address dropdown option {0}")
    public void selectAddressDropdown(String newAddress) {
        waitForElementClickable(driver, CheckoutPageUI.ADDRESS_DROPDOWN);
        selectItemInDefaultDropdown(driver, CheckoutPageUI.ADDRESS_DROPDOWN, newAddress);
    }

    @Step("enter to shipping address first name textbox {0}")
    public void enterToShippingFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_FIRST_NAME_TEXTBOX,firstName);
    }

    @Step("enter to shipping address last name textbox {0}")
    public void enterToShippingLastNameTextbox(String lastName) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_LAST_NAME_TEXTBOX,lastName);
    }

    @Step("enter to shipping address email textbox {0}")
    public void enterToShippingEmailTextbox(String email) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_EMAIL_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_EMAIL_TEXTBOX,email);
    }


    @Step("Select country in country dropdown {0}")
    public void selectShippingCountryDropdown(String country) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.SHIPPING_COUNTRY_DROPDOWN, country);
    }

    @Step("Select country in country dropdown {0}")
    public void selectShippingStateProvinceDropdown(String stateProvince) {
        selectItemInDefaultDropdown(driver, CheckoutPageUI.SHIPPING_STATE_PROVINCE_DROPDOWN, stateProvince);
    }

    @Step("enter to shipping address city textbox {0}")
    public void enterToShippingCityTextbox(String city) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_CITY_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_CITY_TEXTBOX,city);
    }

    @Step("enter to shipping address address1 textbox {0}")
    public void enterToShippingAddress1Textbox(String address1) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_ADDRESS1_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_ADDRESS1_TEXTBOX,address1);
    }

    @Step("enter to shipping address zip postal code textbox {0}")
    public void enterToShippingZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_ZIP_POSTAL_CODE_TEXTBOX,zipPostalCode);
    }

    @Step("enter to shipping address phone number textbox {0}")
    public void enterToShippingPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, CheckoutPageUI.SHIPPING_PHONE_NUMBER_TEXTBOX,phoneNumber);
    }

    @Step("Click to shipping method radio button {0}")
    public void clickToGroundRadioButton(String shippingMethod) {
        waitForElementClickable(driver, CheckoutPageUI.SHIPPING_METHOD_RADIOBUTTON, shippingMethod);
        clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_RADIOBUTTON,shippingMethod);
    }

    @Step("Click to payment method radio button {0}")
    public void clickToPaymentMethodRadioButton(String paymentMethod) {
        waitForElementClickable(driver, CheckoutPageUI.PAYMENT_METHOD_RADIOBUTTON, paymentMethod);
        clickToElement(driver, CheckoutPageUI.PAYMENT_METHOD_RADIOBUTTON,paymentMethod);
    }

    @Step("Get billing address first name & last name in Confirm order")
    public String getBillingAddressFirstNameLastName() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_FIRSTNAME_LASTNAME);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_FIRSTNAME_LASTNAME);
    }

    @Step("Get billing address email in Confirm order")
    public String getBillingAddressEmail() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_EMAIL);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_EMAIL);
    }

    @Step("Get billing address phone number in Confirm order")
    public String getBillingAddressPhone() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_PHONE_NUMBER);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_PHONE_NUMBER);
    }

    @Step("Get billing address country in Confirm order")
    public String getBillingAddressCountry() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_COUNTRY);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_COUNTRY);
    }

    @Step("Get billing address country in Confirm order")
    public String getBillingAddressProvinceState() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_PROVINCE_STATE);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_PROVINCE_STATE);
    }

    @Step("Get billing address city in Confirm order")
    public String getBillingAddressCity() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_CITY);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_CITY);
    }

    @Step("Get billing address address1 in Confirm order")
    public String getBillingAddressAddress1() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_ADDRESS1);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_ADDRESS1);
    }

    @Step("Get billing address zip code postal in Confirm order")
    public String getBillingAddressZipCode() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_ZIP_POSTAL_CODE);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_ZIP_POSTAL_CODE);
    }

    @Step("Get billing address payment method in Confirm order")
    public String getBillingAddressPaymentMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BILLING_PAYMENT_METHOD);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_BILLING_PAYMENT_METHOD);
    }

    @Step("Get shipping address first name & last name in Confirm order")
    public String getShippingAddressFirstNameLastName() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_FIRSTNAME_LASTNAME);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_FIRSTNAME_LASTNAME);
    }

    @Step("Get shipping address email in Confirm order")
    public String getShippingAddressEmail() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_EMAIL);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_EMAIL);
    }

    @Step("Get shipping address phone number in Confirm order")
    public String getShippingAddressPhone() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_PHONE);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_PHONE);
    }

    @Step("Get shipping address country in Confirm order")
    public String getShippingAddressCountry() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_COUNTRY);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_COUNTRY);
    }

    @Step("Get shipping address province state in Confirm order")
    public String getShippingAddressProvinceState() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_PROVINCE_STATE);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_PROVINCE_STATE);
    }

    @Step("Get shipping address city in Confirm order")
    public String getShippingAddressCity() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_CITY);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_CITY);
    }

    @Step("Get shipping address address1 in Confirm order")
    public String getShippingAddressAddress1() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_ADDRESS1);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_ADDRESS1);
    }

    @Step("Get shipping address zip postal code in Confirm order")
    public String getShippingAddressZipCode() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_ZIP_POSTAL_CODE);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_ZIP_POSTAL_CODE);
    }

    @Step("Get shipping address shipping method in Confirm order")
    public String getShippingAddressMethod() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_SHIPPING_METHOD);
        return getWebElementText(driver, CheckoutPageUI.CONFIRM_SHIPPING_METHOD);
    }

    @Step("Get product sku in cart table by Product name {0}")
    public String getSKUProduct(String productName) {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_SKU_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, CheckoutPageUI.PRODUCT_SKU_BY_PRODUCT_NAME, productName);
    }

    @Step("Get product name in cart table")
    public String getProductName(String productName) {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_NAME_IN_CART_TABLE,productName);
        return getWebElementText(driver, CheckoutPageUI.PRODUCT_NAME_IN_CART_TABLE, productName);
    }

    @Step("Get product price in cart table by Product name {0}")
    public String getProductPrice(String productName) {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_PRICE_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, CheckoutPageUI.PRODUCT_PRICE_BY_PRODUCT_NAME, productName);
    }

    @Step("Get product total price in cart table by Product name {0}")
    public String getTotalProductPrice(String productName) {
        waitForElementVisible(driver, CheckoutPageUI.PRODUCT_TOTAL_PRICE_BY_PRODUCT_NAME,productName);
        return getWebElementText(driver, CheckoutPageUI.PRODUCT_TOTAL_PRICE_BY_PRODUCT_NAME, productName);
    }

    @Step("Get sub total price in total info")
    public String getSubTotalPrice() {
        waitForElementVisible(driver, CheckoutPageUI.SUB_TOTAL_PRICE_IN_TOTAL_INFO);
        return getWebElementText(driver, CheckoutPageUI.SUB_TOTAL_PRICE_IN_TOTAL_INFO);
    }

    @Step("Get total price in total info")
    public String getTotalPrice() {
        waitForElementVisible(driver, CheckoutPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
        return getWebElementText(driver, CheckoutPageUI.TOTAL_PRICE_IN_TOTAL_INFO);
    }

    @Step("Click to confirm button")
    public void clickToConfirmButton() {
        waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BUTTON);
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
    }

    @Step("Get thank you title after successfully ordered")
    public String getThankYouTitle() {
        waitForElementVisible(driver, CheckoutPageUI.THANK_YOU_TITLE);
        return getWebElementText(driver, CheckoutPageUI.THANK_YOU_TITLE);
    }

    @Step("Get order successfully message")
    public String getOrderSuccessfullyMessage() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_SUCCESSFULLY_MESSAGE);
        return getWebElementText(driver, CheckoutPageUI.ORDER_SUCCESSFULLY_MESSAGE);
    }

    @Step("Get Order number after successfully ordered")
    public String getOrderNumber() {
        waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER);
        return getWebElementText(driver, CheckoutPageUI.ORDER_NUMBER);
    }
}
