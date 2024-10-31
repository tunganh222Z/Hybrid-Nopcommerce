package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;

public class Login extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

    }

    @Test
    public void Login_01_Login_With_Empty_Data(){
        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorEmailMsg(), "Please enter your email");
    }

    @Test
    public void Login_02_Login_With_Invalid_Email(){
        loginPage.enterToEmailTextbox("");

        loginPage.enterToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getErrorEmailMsg(), "Please enter a valid email address.");
    }

    @Test
    public void Login_03_Login_With_Email_Not_Registered(){
        loginPage.enterToEmailTextbox("");

        loginPage.enterToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMsg(), "Please enter a valid email address.\nNo customer account found");
    }

    @Test
    public void Login_04_Login_With_Valid_Email_No_Password(){
        loginPage.enterToEmailTextbox("");

        loginPage.enterToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Login_With_Valid_Email_Incorrect_Password(){
        loginPage.enterToEmailTextbox("");

        loginPage.enterToPasswordTextbox("");

        loginPage.clickToLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Login_Valid_Email_Password(){
        loginPage.enterToEmailTextbox("");

        loginPage.enterToPasswordTextbox("");

        homePage = loginPage.clickToLoginButton();

        Assert.assertEquals(homePage.getHomePageTitle(), "Your store. Home page title");

    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
