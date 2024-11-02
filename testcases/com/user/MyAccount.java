package com.user;

import commons.BaseTest;
import commons.PageGenerator;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.ProductPageObject;
import pageObjects.categories.SubCategoryPageObject;
import pageObjects.myAccount.AddressesPageObject;
import pageObjects.myAccount.ChangePasswordPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.myAccount.MyProductReviewsPageObject;
import ultilities.FakerConfig;

@Feature("My account")
public class MyAccount extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(MyAccount.class);
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressesPageObject addressesPage;
    private ChangePasswordPageObject changePasswordPage;
    private MainCategoryPageObject mainCategoryPage;
    private SubCategoryPageObject subCategoryPage;
    private ProductPageObject productPage;
    private MyProductReviewsPageObject myProductReviewsPage;
    private String email, password, firstname, lastname, companyName, newEmail, dateReviewed;
    private String country, stateProvince, city, address1, address2, zipPostalCode, phoneNumber, faxNumber, newPassword;
    private String module, productName, reviewTitle, reviewTextContent, subCategoryTitle;
    private int numberRating;
    private FakerConfig fakerConfig;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();

        // data test
        email = Register.email; password = Register.password;
        firstname = "Automation"; lastname = "FC";
        newEmail = fakerConfig.getEmail(); companyName = fakerConfig.getCompanyName(); newPassword = fakerConfig.getPassword();
        country = "Vietnam"; stateProvince = "Bắc Kạn"; city = "Bắc Kạn city"; address1 = "8b Đức Xuân"; address2 = "Phường Đức Xuân";
        zipPostalCode = "970000"; phoneNumber = "03766366833333"; faxNumber = "0123455668";
        dateReviewed = ""; reviewTitle = "Automation Fc Review"; reviewTextContent = "This is review content";
        module = "Computers"; subCategoryTitle = "Desktops"; productName = "Build your own computer"; numberRating = 5;

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);

        customerInfoPage = homePage.clickToMyAccountLink();
    }

    @Description("Update customer info and verify info")
    @Story("My_Account_01_Customer_Info")
    @Test
    public void My_Account_01_Customer_Info(){
        customerInfoPage.clickToFemaleRadioButton();

        customerInfoPage.enterToFirstNameTextbox(firstname);

        customerInfoPage.enterToLastNameTextbox(lastname);

        customerInfoPage.enterToEmailTextbox(newEmail);

        customerInfoPage.enterToCompanyNameTextbox(companyName);

        customerInfoPage.clickToSaveButton();

        verifyEqual(customerInfoPage.getStatusNotifyBar(),"The customer info has been updated successfully.");

        Assert.assertTrue(customerInfoPage.isFemaleGenderSelected());

        verifyEqual(customerInfoPage.getFirstNameValueTextbox(), firstname);

        verifyEqual(customerInfoPage.getLastNameValueTextbox(), lastname);

        verifyEqual(customerInfoPage.getEmailValueTextbox(), newEmail);

        verifyEqual(customerInfoPage.getCompanyNameValueTextbox(), companyName);

        addressesPage = customerInfoPage.openAddressesPage();
    }

    @Description("Update Addresses info and verify addresses")
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

        changePasswordPage = addressesPage.openChangePasswordPage();
    }

    @Description("Change new password - Logout - verify with old and new password")
    @Story("My_Account_03_Change_Password and verify")
    @Test
    public void My_Account_03_Change_Password(){
        changePasswordPage.enterToOldPasswordTextbox(password);

        changePasswordPage.enterToNewPasswordTextbox(newPassword);

        changePasswordPage.enterToConfirmPasswordTextbox(newPassword);

        changePasswordPage.clickToChangePasswordButton();

        verifyEqual(changePasswordPage.getStatusNotifyBar(), "Password was changed");

        changePasswordPage.clickToCloseNotifyBar();

        changePasswordPage.waitNotifyBarInvisible();

        homePage = changePasswordPage.clickToLogoutLink();

        //login with old password
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(newEmail);

        loginPage.enterToPasswordTextbox(password);

        loginPage.clickToLoginButton();

        verifyEqual(loginPage.getLoginErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        //login with new password
        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(newEmail);

        loginPage.enterToPasswordTextbox(newPassword);

        homePage =  loginPage.clickToLoginButton();

        homePage.getHomePageTitle();
    }

    @Description("Add review to any product then verify in My product reviews page ")
    @Story("My_Account_04_My_Product_Reviews and verify")
    @Test
    public void My_Account_04_My_Product_Reviews(){
        homePage.openModuleInHeaderMenu(module);
        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle( subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName);

        productPage.enterToReviewTitleTextbox(reviewTitle);

        productPage.enterToReviewTextTextArea(reviewTextContent);

        productPage.selectRatingByNumberRate(numberRating);

        productPage.clickToSubmitReviewButton();

        verifyEqual(productPage.getStatusNotifyBar(), "Product review is successfully added.");

        dateReviewed = productPage.getDateReviewed();

        productPage.clickToCloseNotifyBar();
        productPage.waitNotifyBarInvisible();

        customerInfoPage =  productPage.clickToMyAccountLink();

        myProductReviewsPage = customerInfoPage.openMyProductReviews();

        verifyEqual(myProductReviewsPage.getReviewedTitle(), reviewTitle);

        verifyEqual(myProductReviewsPage.getReviewedText(), reviewTextContent);

        verifyEqual(myProductReviewsPage.getReviewedDate(), dateReviewed);

        verifyEqual(myProductReviewsPage.getReviewedProductName(), productName);
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
