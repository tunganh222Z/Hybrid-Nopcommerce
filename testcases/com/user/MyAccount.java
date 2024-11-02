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
import pageObjects.myAccount.AddressesPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import ultilities.FakerConfig;

@Feature("My account")
public class MyAccount extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressesPageObject addressesPage;
    private String email, password, firstname, lastname, companyName, newEmail;
    private String country, stateProvince, city, address1, address2, zipPostalCode, phoneNumber, faxNumber;
    private FakerConfig fakerConfig;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();
        email = Register.email; password = Register.password;
        firstname = "Automation"; lastname = "FC";
        newEmail = fakerConfig.getEmail(); companyName = fakerConfig.getCompanyName();
        country = "Vietnam"; stateProvince = "Bắc Kạn"; city = "Bắc Kạn city"; address1 = "8b Đức Xuân"; address2 = "Phường Đức Xuân";
        zipPostalCode = "970000"; phoneNumber = "03766366833333"; faxNumber = "0123455668";

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

        verifyEqual(customerInfoPage.isUpdatedSuccessfullyDisplayed(),"The customer info has been updated successfully.");

        Assert.assertTrue(customerInfoPage.isFemaleGenderSelected());

        verifyEqual(customerInfoPage.getFirstNameValueTextbox(), firstname);

        verifyEqual(customerInfoPage.getLastNameValueTextbox(), lastname);

        verifyEqual(customerInfoPage.getEmailValueTextbox(), newEmail);

        verifyEqual(customerInfoPage.getCompanyNameValueTextbox(), companyName);

        addressesPage = customerInfoPage.openAddressesPage();
    }

    @Description("Update Addresses info")
    @Story("My_Account_02_Addresses")
    @Test
    public void My_Account_02_Addresses(){
        addressesPage.clickToAddNewButton();

        addressesPage.enterToFirstNameTextbox(firstname);

        addressesPage.enterToLastNameTextbox(lastname);

        addressesPage.enterToEmailTextbox(newEmail);

        addressesPage.enterToCompanyTextbox(companyName);

        addressesPage.selectCountryDropdown(country);

        addressesPage.selectStateProvinceDropdown(stateProvince);

        addressesPage.enterToCityTextbox(city);

        addressesPage.enterToAddress1Textbox(address1);

        addressesPage.enterToAddress2Textbox(address2);

        addressesPage.enterToZipPostalCodeTextbox(zipPostalCode);

        addressesPage.enterToPhoneNumberTextbox(phoneNumber);

        addressesPage.enterToFaxNumberTextbox(faxNumber);

        addressesPage.clickToSaveButton();

        verifyEqual(addressesPage.getFirstNameValueTextbox(), firstname+" "+lastname);

        verifyEqual(addressesPage.getEmailValueTextbox(), "Email: "+newEmail);

        verifyEqual(addressesPage.getCompanyValueTextbox(), companyName);

        verifyEqual(addressesPage.getCountryValueDropdown(), country);

        verifyEqual(addressesPage.getStateProvinceValueDropdown(), stateProvince);

        verifyEqual(addressesPage.getCityValueTextbox(), city);

        verifyEqual(addressesPage.getAddress1ValueTextbox(), address1);

        verifyEqual(addressesPage.getAddress2ValueTextbox(), address2);

        verifyEqual(addressesPage.getZipPostalCodeValueTextbox(), zipPostalCode);

        verifyEqual(addressesPage.getPhoneNumberValueTextbox(), "Phone number: " + phoneNumber);

        verifyEqual(addressesPage.getFaxNumberValueTextbox(), "Fax number: " + faxNumber);
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
