package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import ultilities.FakerConfig;

@Feature("Register")
public class Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    public static String firstName, lastName, password, email;
    private String invalidEmail, invalidPassword;
    private FakerConfig fakerConfig;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();

        firstName = fakerConfig.getFirstName();

        lastName = fakerConfig.getLastName();

        email = fakerConfig.getEmail();

        password = fakerConfig.getPassword();

        invalidEmail = email + "@@#!";

        invalidPassword = "1tug@";

        homePage = PageGenerator.getHomePage(driver);
        registerPage = homePage.clickToRegisterLink();
    }
    @Description("Register 01_Register with empty data")
    @Story("Register")
    @Test
    public void Register_01_Register_With_Empty_Data(){
        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("First name"), "First name is required.");

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("Last name"), "Last name is required.");

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("Email"), "Email is required.");

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("Confirm password"), "Password is required.");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Description("Register 02_Register with invalid email")
    @Story("Register")
    @Test
    public void Register_02_Register_With_Invalid_Email(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(invalidEmail);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("Email"), "Please enter a valid email address.");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Description("Register 03_Register with valid data")
    @Story("Register")
    @Test
    public void Register_03_Register_With_Valid_Data(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getRegistrationCompletedMsg(), "Your registration completed");

        homePage=  registerPage.clickToLogoutLink();
    }

    @Description("Register 04_Register with existing email")
    @Story("Register")
    @Test
    public void Register_04_Register_With_Existing_Email(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getExistingEmailErrorMsg(), "The specified email already exists");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Description("Register 05_Register with password less than 6 characters")
    @Story("Register")
    @Test
    public void Register_05_Register_With_Password_Less_Than_6_Chars(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(invalidPassword);

        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getPasswordErrorMsg(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Description("Register 06_Register with confirm password not match")
    @Story("Register")
    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        registerPage.clickToRegisterButton();

        verifyEqual(registerPage.getErrorMsgByTextboxLabel("Confirm password"), "The password and confirmation password do not match.");

        homePage = registerPage.clickNopcommerceLogo();
    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
