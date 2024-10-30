package pageUIs;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class RegisterPageUI {

    public static final String FIRSTNAME_TEXTBOX = "Css=input#FirstName";
    public static final String LASTNAME_TEXTBOX = "Css=input#LastName";
    public static final String EMAIL_TEXTBOX = "Css=input#Email";
    public static final String PASSWORD_TEXTBOX = "css=input#Password";
    public static final String CONFIRM_PASSWORD_TEXTBOX = "css=input#ConfirmPassword";
    public static final String DYNAMIC_ERROR_MSG_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::span/span";
    public static final String PASSWORD_ERROR_MSG = "xpath=//label[contains(text(),'Password')]/following-sibling::span[@class='field-validation-error']";
    public static final String EXISTING_EMAIL_ERROR_MSG = "xpath=//div[@class='message-error validation-summary-errors']/ul/li";
    public static final String REGISTRATION_COMPLETED_MSG = "css=div.result";
    public static final String REGISTER_BUTTON = "css=button#register-button";
}
