package pageObjects.myAccount;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BaseActions {
    WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Female radio button")
    public void clickToFemaleRadioButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON);
        if (!getWebElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON).isSelected()){
            clickToElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON);
        }
    }

    @Step("Enter to Firstname textbox")
    public void enterToFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    @Step("Enter to Lastname textbox")
    public void enterToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    @Step("Enter to Email textbox is {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Company name textbox is {0}")
    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    @Step("Click to Save button is {0}")
    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }

    @Step("Verify Updated Successfully bar is displayed")
    public String isUpdatedSuccessfullyDisplayed() {
        waitForElementVisible(driver, CustomerInfoPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
        return getWebElementText(driver, CustomerInfoPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
    }

    @Step("Get Firstname value textbox")
    public String getFirstNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get Lastname value textbox")
    public String getLastNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Email value textbox")
    public String getEmailValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    @Step("Get Company name value textbox")
    public String getCompanyNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }

    @Step("Verify Female radio button is selected")
    public boolean isFemaleGenderSelected() {
        boolean isSelected = false;
        if (getWebElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON).isSelected()){
            isSelected = true;
        }
        return  isSelected;
    }
}
