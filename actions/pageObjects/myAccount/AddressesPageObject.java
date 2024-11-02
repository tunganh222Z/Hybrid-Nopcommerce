package pageObjects.myAccount;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.AddressesPageUI;
import pageUIs.myAccount.CustomerInfoPageUI;

public class AddressesPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    public AddressesPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("CLick to ADD NEW button")
    public void clickToAddNewButton() {
        waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
    }

    @Step("Enter to Firstname textbox is {0}")
    public void enterToFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    @Step("Enter to Lastname textbox is {0}")
    public void enterToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, AddressesPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    @Step("Enter to Email textbox is {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, AddressesPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Company textbox is {0}")
    public void enterToCompanyTextbox(String company) {
        waitForElementVisible(driver, AddressesPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.COMPANY_TEXTBOX, company);
    }

    @Step("Select Country dropdown is {0}")
    public void selectCountryDropdown(String country) {
        selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWN, country);
    }

    @Step("Select State/Province dropdown is {0}")
    public void selectStateProvinceDropdown(String stateProvince) {
        selectItemInDefaultDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN, stateProvince);
    }

    @Step("Enter to City textbox is {0}")
    public void enterToCityTextbox(String city) {
        waitForElementVisible(driver, AddressesPageUI.CITY_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.CITY_TEXTBOX, city);
    }

    @Step("Enter to Address 1 textbox is {0}")
    public void enterToAddress1Textbox(String address1) {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS_1_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.ADDRESS_1_TEXTBOX, address1);
    }

    @Step("Enter to Address 2 textbox is {0}")
    public void enterToAddress2Textbox(String address2) {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS_2_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.ADDRESS_2_TEXTBOX, address2);
    }

    @Step("Enter to Zip/Postal Code textbox is {0}")
    public void enterToZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
    }

    @Step("Enter to Phone Number textbox is {0}")
    public void enterToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    @Step("Enter to Fax Number textbox is {0}")
    public void enterToFaxNumberTextbox(String faxNumber) {
        waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX);
        sendkeyToElement(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
    }

    @Step("Click to Save Button")
    public void clickToSaveButton() {
        waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
    }

    @Step("Verify Firstname input correctly")
    public String getFirstNameValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.FIRST_LAST_NAME_INFO);
        return getWebElementText(driver, AddressesPageUI.FIRST_LAST_NAME_INFO);
    }

    @Step("Verify Email input correctly")
    public String getEmailValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.EMAIL_INFO);
        return getWebElementText(driver, AddressesPageUI.EMAIL_INFO);
    }

    @Step("Verify Company input correctly")
    public String getCompanyValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.COMPANY_INFO);
        return getWebElementText(driver, AddressesPageUI.COMPANY_INFO);
    }

    @Step("Verify Country selected correctly")
    public String getCountryValueDropdown() {
        waitForElementVisible(driver, AddressesPageUI.COUNTRY_INFO);
        return getWebElementText(driver, AddressesPageUI.COUNTRY_INFO);
    }

    @Step("Verify State/Province selected correctly")
    public String getStateProvinceValueDropdown() {
        waitForElementVisible(driver, AddressesPageUI.STATE_PROVINCE_INFO);
        return getWebElementText(driver, AddressesPageUI.STATE_PROVINCE_INFO);
    }

    @Step("Verify City input correctly")
    public String getCityValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.CITY_INFO);
        return getWebElementText(driver, AddressesPageUI.CITY_INFO);
    }

    @Step("Verify Address 1 input correctly")
    public String getAddress1ValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS_1_INFO);
        return getWebElementText(driver, AddressesPageUI.ADDRESS_1_INFO);
    }

    @Step("Verify Address 2 input correctly")
    public String getAddress2ValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.ADDRESS_2_INFO);
        return getWebElementText(driver, AddressesPageUI.ADDRESS_2_INFO);
    }

    @Step("Verify Zip/Postal Code input correctly")
    public String getZipPostalCodeValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_CODE_INFO);
        return getWebElementText(driver, AddressesPageUI.ZIP_POSTAL_CODE_INFO);
    }

    @Step("Verify Phone Number input correctly")
    public String getPhoneNumberValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_INFO);
        return getWebElementText(driver, AddressesPageUI.PHONE_NUMBER_INFO);
    }

    @Step("Verify Fax Number input correctly")
    public String getFaxNumberValueTextbox() {
        waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_INFO);
        return getWebElementText(driver, AddressesPageUI.FAX_NUMBER_INFO);
    }

    @Step("Verify Address has been Updated Successfully bar is displayed")
    public String isUpdatedSuccessfullyDisplayed() {
        waitForElementVisible(driver, AddressesPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
        return getWebElementText(driver, AddressesPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
    }
}
