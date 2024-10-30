package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import ultilities.FakerConfig;

public class Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String firstName, lastName, password, email;
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

    @Test
    public void Register_01_Register_With_Empty_Data(){
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("First name"), "First name is required.");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("Last name"), "Last name is required.");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("Email"), "Email is required.");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("Confirm password"), "Password is required.");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Test
    public void Register_02_Register_With_Invalid_Email(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(invalidEmail);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("Email"), "Please enter a valid email address.");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Test
    public void Register_03_Register_With_Valid_Data(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationCompletedMsg(), "Your registration completed");

        homePage=  registerPage.clickToLogoutLink();
    }

    @Test
    public void Register_04_Register_With_Existing_Email(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getExistingEmailErrorMsg(), "The specified email already exists");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Test
    public void Register_05_Register_With_Password_Less_Than_6_Chars(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(invalidPassword);

        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getPasswordErrorMsg(), "<p>must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

        homePage = registerPage.clickNopcommerceLogo();
    }

    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match(){
        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(email);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(invalidPassword);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel("Confirm password"), "The password and confirmation password do not match.");
    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
