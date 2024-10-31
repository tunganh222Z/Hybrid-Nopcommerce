package pageObjects;

import commons.BaseActions;
import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObjects extends BaseActions {
    WebDriver driver;
    public LoginPageObjects (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getLoginErrorMsg() {
        String errorLoginMsg ="";
        errorLoginMsg = getWebElementText(driver, LoginPageUI.ERROR_LOGIN_MSG_1) + "\n" + getWebElement(driver,LoginPageUI.ERROR_LOGIN_MSG_2);
        errorLoginMsg.trim();
        return errorLoginMsg;
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON());
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON());
        return PageGenerator.getHomePage(driver);
    }

    public String getErrorEmailMsg() {
        waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MSG);
        return getWebElementText(driver, LoginPageUI.ERROR_EMAIL_MSG);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }
}
