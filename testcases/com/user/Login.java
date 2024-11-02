package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;

import java.util.logging.Logger;
@Feature("Login")
public class Login extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private String email, password;
    private String invalidEmail, emailNotRegiestered, incorrectPassword;
    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        email = Register.email;
        password = Register.password;
        invalidEmail = Register.email+"@@##!";
        emailNotRegiestered = "tunganh222224@gmail.com";
        incorrectPassword = Register.password + "123";
    }
    @Description("Login with empty data then verify error message")
    @Story("Login_01")
    @Test
    public void Login_01_Login_With_Empty_Data(){
        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getErrorEmailMsg(), "Please enter your email");
    }

    @Description("Login with invalid email then verify error message")
    @Story("Login_02")
    @Test
    public void Login_02_Login_With_Invalid_Email(){
        loginPage.enterToEmailTextbox(invalidEmail);

        loginPage.enterToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getErrorEmailMsg(), "Please enter a valid email address.");
    }

    @Description("Login with email not registered then verify error message")
    @Story("Login_03")
    @Test
    public void Login_03_Login_With_Email_Not_Registered(){
        loginPage.enterToEmailTextbox(emailNotRegiestered);

        loginPage.enterToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Description("Login with valid email and no password then verify error message")
    @Story("Login_04")
    @Test
    public void Login_04_Login_With_Valid_Email_No_Password(){
        loginPage.enterToEmailTextbox(email);

        loginPage.enterToPasswordTextbox("");

        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Description("Login with valid email and incorrect password then verify error message")
    @Story("Login_05")
    @Test
    public void Login_05_Login_With_Valid_Email_Incorrect_Password(){
        loginPage.enterToEmailTextbox(email);

        loginPage.enterToPasswordTextbox(incorrectPassword);

        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Description("Login with valid email and password")
    @Story("Login_06")
    @Test
    public void Login_06_Login_Valid_Email_Password(){
        loginPage.enterToEmailTextbox(email);

        loginPage.enterToPasswordTextbox(password);

        homePage = loginPage.clickToLoginButton();

        verifyEqual(homePage.getHomePageTitle(), "Your store. Home page title");
    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
