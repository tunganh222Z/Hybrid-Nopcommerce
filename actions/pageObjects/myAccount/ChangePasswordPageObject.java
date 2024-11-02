package pageObjects.myAccount;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.ChangePasswordPageUI;

public class ChangePasswordPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    public ChangePasswordPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Current Password to Old Password textbox is {0}")
    public void enterToOldPasswordTextbox(String currentPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, currentPassword );
    }

    @Step("Enter New Password to New Password textbox is {0}")
    public void enterToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword );
    }

    @Step("Enter New Password to Confirm Password textbox is {0}")
    public void enterToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword );
    }

    @Step("Click to Change Password button")
    public void clickToChangePasswordButton() {
        waitForElementVisible(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }
}
