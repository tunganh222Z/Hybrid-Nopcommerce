package pageObjects.myAccount;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BaseActions {
    WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToFemaleRadioButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON);
        if (!getWebElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON).isSelected()){
            clickToElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON);
        }
    }

    public void enterToFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    public void enterToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
    }

    public String isUpdatedSuccessfullyDisplayed() {
        waitForElementVisible(driver, CustomerInfoPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
        return getWebElementText(driver, CustomerInfoPageUI.UPDATED_SUCCESSFULLY_NOTIFY);
    }

    public String getFirstNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameValueTextbox() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX );
        return getWebElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
    }

    public boolean isFemaleGenderSelected() {
        boolean isSelected = false;
        if (getWebElement(driver, CustomerInfoPageUI.FEMALE_RADIO_BUTTON).isSelected()){
            isSelected = true;
        }
        return  isSelected;
    }
}
