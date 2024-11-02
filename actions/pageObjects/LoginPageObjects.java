package pageObjects;

import commons.BaseActions;
import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObjects extends BaseActions {
    WebDriver driver;
    public LoginPageObjects (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get Login Error Message")
    public String getLoginErrorMsg() {
        waitForElementVisible(driver, LoginPageUI.ERROR_LOGIN_MSG);
        return getWebElementText(driver, LoginPageUI.ERROR_LOGIN_MSG) ;
    }

    @Step("Click to Login button")
    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }

    @Step("Get Email Error Message")
    public String getErrorEmailMsg() {
        waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MSG);
        return getWebElementText(driver, LoginPageUI.ERROR_EMAIL_MSG);
    }

    @Step("Enter to Email textbox is {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    @Step("Enter to Password textbox is {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter valid data to Login")
    public HomePageObject loginForm(WebDriver driver, String email, String password) {
        enterToEmailTextbox(email);

        enterToPasswordTextbox(password);

        clickToLoginButton();

        return PageGenerator.getHomePage(driver);
    }
}
