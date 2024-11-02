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
import pageObjects.myAccount.CustomerInfoPageObject;
import ultilities.FakerConfig;

@Feature("My account")
public class MyAccount extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private String email, password, firstname, lastname, companyName, newEmail;
    private FakerConfig fakerConfig;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();
        email = Register.email; password = Register.password;
        firstname = "Automation"; lastname = "FC";
        newEmail = fakerConfig.getEmail(); companyName = fakerConfig.getCompanyName();

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);

        customerInfoPage = homePage.clickToMyAccountLink();
    }

    @Description("Update customer info")
    @Story("My_Account_01_Customer_Info")
    @Test
    public void My_Account_01_Customer_Info(){
        customerInfoPage.clickToFemaleRadioButton();

        customerInfoPage.enterToFirstNameTextbox(firstname);

        customerInfoPage.enterToLastNameTextbox(lastname);

        customerInfoPage.enterToEmailTextbox(newEmail);

        customerInfoPage.enterToCompanyNameTextbox(companyName);

        customerInfoPage.clickToSaveButton();

        Assert.assertEquals(customerInfoPage.isUpdatedSuccessfullyDisplayed(),"The customer info has been updated successfully.");

        Assert.assertTrue(customerInfoPage.isFemaleGenderSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameValueTextbox(), firstname);

        Assert.assertEquals(customerInfoPage.getLastNameValueTextbox(), lastname);

        Assert.assertEquals(customerInfoPage.getEmailValueTextbox(), newEmail);

        Assert.assertEquals(customerInfoPage.getCompanyNameValueTextbox(), companyName);
    }

    @Description("Update Addresses info")
    @Story("My_Account_02_Addresses")
    @Test
    public void My_Account_02_Addresses(){

    }

    @Test
    public void My_Account_03_Change_Password(){

    }

    @Test
    public void My_Account_04_My_Product_Reviews(){

    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
