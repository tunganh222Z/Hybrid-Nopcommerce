package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.SearchPageObject;
import ultilities.FakerConfig;

@Feature("Search / advanced search")
public class Search extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private SearchPageObject searchPage;

    private FakerConfig fakerConfig;

    private String email, password;
    private String productNameNotExist, relativeProductName, absoluteProductName, searchKeywords;
    private String incorrectManufacturer;
    private String categoryExpected, manufacturerExpected;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();
        //data test
        productNameNotExist = "Macbook Pro 2050"; relativeProductName = "Lenovo"; absoluteProductName = "ThinkPad X1 Carbon";
        searchKeywords = "Apple MacBook Pro"; categoryExpected = "Computers"; manufacturerExpected = "Apple"; incorrectManufacturer = "HP";
        //

        email = Register.email; password = Register.password;

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);
    }

    @Description("Search with empty data then verify error message")
    @Story("Search_With_Empty_Data")
    @Test
    public void Search_01_Search_With_Empty_Data(){
        homePage.enterToSearchTextboxInHeader("");

        homePage.clickToSearchButtonInHeader();

        verifyEqual(homePage.getTextInSearchAlert(),"Please enter some search keyword");

        homePage.clickAcceptInSearchAlert();
    }

    @Description("Search with data not exist then verify message")
    @Story("Search_With_Data_Not_Exist")
    @Test
    public void Search_02_Search_With_Data_Not_Exist(){
        homePage.enterToSearchTextboxInHeader(productNameNotExist);

        searchPage = homePage.clickToSearchButtonInHeader();

        verifyEqual(searchPage.getSearchMessage(), "No products were found that matched your criteria.");
    }

    @Description("Search with relative product name then verify products name with relative name")
    @Story("Search_With_Relative_Product_Name")
    @Test
    public void Search_03_Search_With_Relative_Product_Name(){
        searchPage.enterToSearchTextbox(relativeProductName);

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getNumberProductsDisplayed(), "2");

        verifyEqual(searchPage.getProductsNameDisplayed(),"Lenovo IdeaCentre 600 All-in-One PC, Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Description("Search with absolute product name then verify only one product name display")
    @Story("Search_With_Absolute_Product_Name")
    @Test
    public void Search_04_Search_With_Absolute_Product_Name(){
        searchPage.enterToSearchTextbox(absoluteProductName);

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getNumberProductsDisplayed(), "1");

        verifyEqual(searchPage.getProductsNameDisplayed(),"Lenovo Thinkpad X1 Carbon Laptop");
    }

    @Description("Advanced Search with Parent Categories then verify Error Search Message")
    @Story("Advanced_Search_With_Parent_Categories")
    @Test
    public void Search_05_Advanced_Search_With_Parent_Categories(){
        searchPage.enterToSearchTextbox(searchKeywords);

        searchPage.clickToEnableAdvancedSearch();

        searchPage.selectCategoryDropdown(categoryExpected);

        searchPage.clickToDisableAutomaticallySearchSubCategories();

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getSearchMessage(), "No products were found that matched your criteria.");

    }

    @Description("Search with Sub Categories then verify Number Products and Products Name are displaying")
    @Story("Advanced_Search_With_Sub_Categories")
    @Test
    public void Search_06_Advanced_Search_With_Sub_Categories(){
        searchPage.enterToSearchTextbox(searchKeywords);

        searchPage.clickToEnableAdvancedSearch();

        searchPage.selectCategoryDropdown(categoryExpected);

        searchPage.clickToEnableAutomaticallySearchSubCategories();

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getNumberProductsDisplayed(), "1");

        verifyEqual(searchPage.getProductsNameDisplayed(),"Apple MacBook Pro 13-inch");
    }

    @Description("Advanced search with Incorrect Manufacturer then verify Error Search Message ")
    @Story("Advanced_Search_With_Incorrect_Manufacturer")
    @Test
    public void Search_07_Advanced_Search_With_Incorrect_Manufacturer(){
        searchPage.enterToSearchTextbox(searchKeywords);

        searchPage.clickToEnableAdvancedSearch();

        searchPage.clickToEnableAutomaticallySearchSubCategories();

        searchPage.selectManufacturerDropdown(incorrectManufacturer);

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getSearchMessage(), "No products were found that matched your criteria.");
    }

    @Description("Advanced search with Correct Manufacturer then verify Number Products and Products Name are displaying")
    @Story("Advanced_Search_With_Correct_Manufacturer")
    @Test
    public void Search_08_Advanced_Search_With_Correct_Manufacturer(){
        searchPage.enterToSearchTextbox(searchKeywords);

        searchPage.clickToEnableAdvancedSearch();

        searchPage.clickToEnableAutomaticallySearchSubCategories();

        searchPage.selectManufacturerDropdown(manufacturerExpected);

        searchPage.clickToSearchButton();

        verifyEqual(searchPage.getNumberProductsDisplayed(), "1");

        verifyEqual(searchPage.getProductsNameDisplayed(),"Apple MacBook Pro 13-inch");
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
