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
import pageObjects.admin.ProductsPageObject;

public class Admin extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private DashboardPageObject dashboardPage;
    private ProductsPageObject productsPage;


    @Parameters({"browser", "urlAdmin"})
    @BeforeTest
    public void beforeClass(String browser, String urlAdmin){
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

        productsPage.enterToProductNameTextbox("");

        productsPage.clickToSearchButton();

        verifyTrue(productsPage.isOnlyProductDisplayedInProductTable());

        verifyEqual(productsPage.getProductNameInProductTable, "");

        verifyEqual(productsPage.getProductSKUInProductTable, "");

        verifyEqual(productsPage.getProductPriceInProductTable, "");

        verifyEqual(productsPage.getProductStockInProductTable, "");

        verifyEqual(productsPage.getProductPublishedStatusInProductTable, "");
    }
}
