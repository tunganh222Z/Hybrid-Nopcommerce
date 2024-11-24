package com.admin;

import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.admin.DashboardPageObject;
import pageObjects.admin.catalog.ProductsPageObject;

public class Admin extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private DashboardPageObject dashboardPage;
    private ProductsPageObject productsPage;

    private String productName;

    @Parameters({"browser", "urlAdmin"})
    @BeforeTest
    public void beforeClass(String browser, String urlAdmin){
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        driver = getBrowserDriver(browser, urlAdmin);

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.loginForm(driver, GlobalConstant.ADMIN_ID, GlobalConstant.ADMIN_PASSWORD);

        dashboardPage = PageGenerator.getDashboardPage(driver);
    }



    @Description("")
    @Story("")
    @Test
    public void ADMIN_01_(){
        productsPage = dashboardPage.openModuleInCatalog("");

        productsPage.enterToProductNameTextbox(productName);

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isOnlyProductDisplayedInProductTable());

        verifyEqual(productsPage.getProductNameInProductTable(), productName);

        verifyEqual(productsPage.getProductSKUInProductTable(), "");

        verifyEqual(productsPage.getProductPriceInProductTable(), "");

        verifyEqual(productsPage.getProductStockInProductTable(), "");

        verifyEqual(productsPage.getProductPublishedStatusInProductTable(), "");
    }

    @Description("")
    @Story("")
    @Test
    public void ADMIN_02_(){
        productsPage = dashboardPage.openModuleInCatalog("");

        productsPage.enterToProductNameTextbox(productName);

        productsPage.selectItemInCategoryDropdown("");

        productsPage.clickToUncheckSubCategoriesCheckbox();

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isProductTableEmpty());

        verifyEqual(productsPage.getNoDataMessage(), "No data available in table");
    }

    @Description("")
    @Story("")
    @Test
    public void ADMIN_03_(){
        productsPage = dashboardPage.openModuleInCatalog("");

        productsPage.enterToProductNameTextbox(productName);

        productsPage.selectItemInCategoryDropdown("");

        productsPage.clickToCheckSubCategoriesCheckbox();

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isOnlyProductDisplayedInProductTable());

        verifyEqual(productsPage.getProductNameInProductTable(), productName);
    }

    @Description("")
    @Story("")
    @Test
    public void ADMIN_04_(){
        productsPage = dashboardPage.openModuleInCatalog("");

        productsPage.enterToProductNameTextbox(productName);

        productsPage.selectItemInCategoryDropdown("");

        productsPage.clickToUncheckSubCategoriesCheckbox();

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isOnlyProductDisplayedInProductTable());

        verifyEqual(productsPage.getProductNameInProductTable(), productName);
    }

    @Description("")
    @Story("")
    @Test
    public void ADMIN_05_(){
        productsPage = dashboardPage.openModuleInCatalog("");

        productsPage.enterToProductNameTextbox(productName);

        productsPage.selectItemInCategoryDropdown("");

        productsPage.clickToUncheckSubCategoriesCheckbox();

        productsPage.selectItemInManufacturerDropdown("");

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isProductTableEmpty());

        verifyEqual(productsPage.getNoDataMessage(), "No data available in table");
    }
}
