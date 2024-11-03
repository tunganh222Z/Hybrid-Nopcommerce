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
import org.testng.asserts.SoftAssert;
import pageObjects.HomePageObject;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.SubCategoryPageObject;

@Feature("Sort / Displaying / Paging")
public class SortDisplayPaging extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private MainCategoryPageObject mainCategoryPage;
    private SubCategoryPageObject subCategoryPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        homePage.openModuleInHeaderMenu("Computers");

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle("Notebooks");
    }

    @Description("Sort Product Name From A to Z, then verify sort method")
    @Story("Sort_With_Product_Name_From_AZ")
    @Test
    public void Sort_01_Sort_With_Product_Name_From_AZ(){
        subCategoryPage.selectItemInSortByDropdown("Name: A to Z");

        verifyTrue(subCategoryPage.isProductsNameSortByAscending());
    }

    @Description("Sort Product Name From Z to A, then verify sort method")
    @Story("Sort_With_Product_Name_From_ZA")
    @Test
    public void Sort_02_Sort_With_Product_Name_From_ZA(){
        subCategoryPage.selectItemInSortByDropdown("Name: Z to A");

        verifyTrue(subCategoryPage.isProductsNameSortByDescending());
    }

    @Description("Sort Product Price From Low to High, then verify sort method")
    @Story("Sort_With_Price_From_Low_To_High")
    @Test
    public void Sort_03_Sort_With_Price_From_Low_To_High(){
        subCategoryPage.selectItemInSortByDropdown("Price: Low to High");

        verifyTrue(subCategoryPage.isProductsPriceSortByLowToHigh());
    }

    @Description("Sort Product Price From High to Low, then verify sort method")
    @Story("Sort_With_Price_From_High_To_Low")
    @Test
    public void Sort_04_Sort_With_Price_From_High_To_Low(){
        subCategoryPage.selectItemInSortByDropdown("Price: High to Low");

        verifyTrue(subCategoryPage.isProductsNameSortByHighToLow());
    }

    @Description("Display maximum 3 products then verify Previous and Next icon display")
    @Story("Display_Maximum_3_Products")
    @Test
    public void Display_01_Display_Maximum_3_Products(){
        subCategoryPage.selectNumberProductDisplayDropdown(3);

        subCategoryPage.isProductsDisplayMaximumOrLess(3);

        subCategoryPage.openLastPage();

        subCategoryPage.isPreviousIconDisplay();

        subCategoryPage.openFirstPage();

        subCategoryPage.isNextIconDisplay();
    }

    @Description("Display maximum 6 products then verify products display maximum or less than 6, and Pagination control un-display")
    @Story("Display_Maximum_6_Products")
    @Test
    public void Display_02_Display_Maximum_6_Products(){
        subCategoryPage.selectNumberProductDisplayDropdown(6);

        subCategoryPage.isProductsDisplayMaximumOrLess(6);

        verifyTrue(subCategoryPage.isPagingUnDisplay());
    }

    @Description("Display maximum 9 products then verify products display maximum or less than 9, and Pagination control un-display")
    @Story("Display_Maximum_9_Products")
    @Test
    public void Display_03_Display_Maximum_9_Products(){
        subCategoryPage.selectNumberProductDisplayDropdown(9);

        subCategoryPage.isProductsDisplayMaximumOrLess(9);

        verifyTrue(subCategoryPage.isPagingUnDisplay());
    }

    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
