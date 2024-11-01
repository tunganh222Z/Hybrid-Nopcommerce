package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.RegisterPageObject;
import pageUIs.BaseActionsPageUI;

public class BaseActions extends BasePage{
    WebDriver driver;
    public BaseActions (WebDriver driver){
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, BaseActionsPageUI.REGISTER_LINK);
        clickToElement(driver, BaseActionsPageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    public HomePageObject clickNopcommerceLogo() {
        waitForElementClickable(driver, BaseActionsPageUI.NOPCOMMERCE_LOGO);
        clickToElement(driver, BaseActionsPageUI.NOPCOMMERCE_LOGO);
        return PageGenerator.getHomePage(driver);
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, BaseActionsPageUI.LOGOUT_LINK);
        clickToElement(driver, BaseActionsPageUI.LOGOUT_LINK);
        return PageGenerator.getHomePage(driver);
    }

    public LoginPageObjects clickToLoginLink() {
        waitForElementClickable(driver, BaseActionsPageUI.LOGIN_LINK);
        clickToElement(driver, BaseActionsPageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }
}
