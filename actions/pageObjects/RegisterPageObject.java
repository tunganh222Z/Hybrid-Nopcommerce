package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BaseActions {
    WebDriver driver;
    public RegisterPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void clickToRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

    }

    public String getErrorMsgByTextboxLabel(String label) {
        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_LABEL, label);
        return getWebElementText(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_LABEL, label);
    }

    public String getPasswordErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
    }

    public String getExistingEmailErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
    }

    public String getRegistrationCompletedMsg() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getWebElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
