package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import commons.ShoppingCartPageObject;
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
import pageObjects.WishlistPageObject;
import pageObjects.categories.CompareProductsListPageObject;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.ProductPageObject;
import pageObjects.categories.SubCategoryPageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Feature("Wishlist Compare Recent view")
public class WishlistCompareRecentView extends BaseTest {
    WebDriver driver;

    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private MainCategoryPageObject mainCategoryPage;
    private SubCategoryPageObject subCategoryPage;
    private ProductPageObject productPage;
    private WishlistPageObject wishlistPage;
    private ShoppingCartPageObject shoppingCartPage;
    private CompareProductsListPageObject compareProductsListPage;

    private String module, subCategoryTitle, productName, productName2, productPrice, productPrice2;
    private String productName3, productName4, productName5;
    private String email, password, firstname, lastname;

    private List<String> productList;
    private List<String> expectedRecentlyViewed;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        email = MyAccount.newEmail;

        password = MyAccount.newPassword;

        firstname = MyAccount.firstname; lastname = MyAccount.lastname;

        module = "Computers"; subCategoryTitle = "Notebooks";

        productName ="Apple MacBook Pro 13-inch";
        productName2 = "Asus N551JK-XO076H Laptop";
        productName3 = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
        productName4 = "HP Spectre XT Pro UltraBook";
        productName5="Lenovo Thinkpad X1 Carbon Laptop";

        productPrice = "$1,800.00"; productPrice2 = "$1,500.00";

        productList = new ArrayList<>(List.of(productName,productName2,productName3,productName4,productName5
        ));

        expectedRecentlyViewed = new ArrayList<>(productList.subList(productList.size()-3, productList.size()));

        Collections.reverse(expectedRecentlyViewed);

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);

        homePage.openModuleInHeaderMenu(module);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle( subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName);
    }

    @Description("")
    @Story("")
    @Test
    public void TC_01_Wishlist_01_Add_Product_To_Wishlist(){
        productPage.clickToAddToWishlistButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(),"The product has been added to your wishlist");

        productPage.clickToCloseNotifyBar();

        wishlistPage = productPage.clickToWishlistLink();

        verifyEqual(wishlistPage.getProductNameAddedToWishlistPage(),productName);

        wishlistPage.clickToWishlistURLForSharingLink();

        verifyEqual(wishlistPage.getWishlistTitleFromURLSharing(), "Wishlist of " + firstname +" "+ lastname);
    }

    @Description("")
    @Story("")
    @Test
    public void TC_02_Wishlist_02_Add_Product_To_Cart_From_Wishlist_Page(){
        wishlistPage.clickToAddToCartCheckboxByProductName(productName);

        shoppingCartPage = wishlistPage.clickToAddToCartButton();

        verifyEqual(shoppingCartPage.getAddedProductNameToCart(), productName);

        wishlistPage = shoppingCartPage.clickToWishlistLink();

        verifyTrue(wishlistPage.isProductDisplayedInWishlistByName(productName));
    }

    @Description("")
    @Story("")
    @Test
    public void TC_03_Wishlist_03_Remove_Product_From_Wishlist_Page(){
        wishlistPage.openModuleInHeaderMenu(module);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName2);

        productPage.clickToAddToWishlistButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(),"The product has been added to your wishlist");

        productPage.clickToCloseNotifyBar();

        wishlistPage = productPage.clickToWishlistLink();

        wishlistPage.clickToRemoveByProductName(productName2);

        wishlistPage.clickToRemoveByProductName(productName);

        verifyEqual(wishlistPage.getEmptyWishlistPageMessage(), "The wishlist is empty!");

        verifyTrue(wishlistPage.isProductUnDisplayedInWishlistByName(productName2));
    }

    @Description("")
    @Story("")
    @Test
    public void TC_04_Compare_01_Add_Product_To_Compare(){
        wishlistPage.openModuleInHeaderMenu(module);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        subCategoryPage.clickAddToCompareListByProductName(productName);

        subCategoryPage.waitAjaxLoadingInvisible();

        verifyEqual(subCategoryPage.getStatusNotifyBar(), "The product has been added to your product comparison");

        subCategoryPage.clickToCloseNotifyBar();

        subCategoryPage.clickAddToCompareListByProductName(productName2);

        subCategoryPage.waitAjaxLoadingInvisible();

        verifyEqual(subCategoryPage.getStatusNotifyBar(), "The product has been added to your product comparison");

        subCategoryPage.clickToCloseNotifyBar();

        compareProductsListPage = subCategoryPage.clickToCompareProductsListLink();

        verifyTrue(compareProductsListPage.isAddedProductToCompareDisplayed(productName) && compareProductsListPage.isAddedProductToCompareDisplayed(productName2));

        verifyEqual(compareProductsListPage.getProductPriceByProductName(productName), productPrice);

        verifyEqual(compareProductsListPage.getProductPriceByProductName(productName2), productPrice2);

        compareProductsListPage.clickToClearListButton();

        verifyEqual(compareProductsListPage.getEmptyCompareProductsMessage(), "You have no items to compare.");

        verifyTrue(compareProductsListPage.isAddedProductToCompareUnDisplayed(productName) && compareProductsListPage.isAddedProductToCompareUnDisplayed(productName2));
    }

    @Description("")
    @Story("")
    @Test
    public void TC_05_Recently_View_Products_01_Recently_Viewed_Products(){
        compareProductsListPage.openModuleInHeaderMenu(module);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        subCategoryPage.openProductByProductList(productList);

        verifyEqual(subCategoryPage.getRecentlyViewedProducts(), expectedRecentlyViewed);
    }



    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
