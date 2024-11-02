package pageObjects;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BaseActions {
    WebDriver driver;
    public RegisterPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Click to Register button")
    public void clickToRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Enter to Firstname textbox is {0}")
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter to Lastname textbox is {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter to Email textbox is {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Password textbox is {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter to Confirm Password textbox is {0}")
    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

    }

    @Step("Get Error Message is {0}")
    public String getErrorMsgByTextboxLabel(String label) {
        waitForElementVisible(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_LABEL, label);
        return getWebElementText(driver, RegisterPageUI.DYNAMIC_ERROR_MSG_BY_LABEL, label);
    }

    @Step("Get Password Error Message")
    public String getPasswordErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.PASSWORD_ERROR_MSG);
    }

    @Step("Get Existing Email Error Message")
    public String getExistingEmailErrorMsg() {
        waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
        return getWebElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
    }

    @Step("Get Registration Completed Message")
    public String getRegistrationCompletedMsg() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getWebElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
