package com.user;

import commons.BaseTest;
import commons.PageGenerator;
import commons.ShoppingCartPageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.orderCheckout.CheckoutPageObject;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.ProductPageObject;
import pageObjects.categories.SubCategoryPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.myAccount.OrderPageObject;
import pageObjects.orderCheckout.OrderDetailPageObject;
import userDataTest.UserData;

@Feature("Order feature")
public class Orders extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObjects loginPage;
    private MainCategoryPageObject mainCategoryPage;
    private SubCategoryPageObject subCategoryPage;
    private ProductPageObject productPage;
    private ShoppingCartPageObject shoppingCartPage;
    private CheckoutPageObject checkoutPage;
    private CustomerInfoPageObject customerInfoPage;
    private OrderPageObject orderPage;
    private OrderDetailPageObject orderDetailPage;

    private UserData userData;


    private String email, password;
    private String firstName, lastName, country, stateProvince,city, address1, zipPostalCode, phoneNumber;
    private String moduleTitle, subCategoryTitle, productName;

    @Parameters("browser, url")
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        userData = UserData.getUserData();

        email = MyAccount.newEmail; password = MyAccount.newPassword;

        firstName =


        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);
    }

    @Description("")
    @Story("")
    public void Order_01_Add_Product_To_Cart(){
        homePage.openModuleInHeaderMenu(moduleTitle);
        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName);

        productPage.selectProcessorDropdown("");

        productPage.selectRAMDropdown("");

        productPage.selectHDDRadiobutton("");

        productPage.selectOSRadiobutton("");

        productPage.selectSoftwaresCheckbox("");

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        verifyEqual(shoppingCartPage.getAddedProductInformations(), "");

        verifyEqual(shoppingCartPage.getNumberProductsInCart(), shoppingCartPage.getNumberProductsInShoppingCartLink);

        verifyEqual(shoppingCartPage.getSubTotalPrice(),"");
    }

    @Description("")
    @Story("")
    public void Order_02_(){
        productPage = shoppingCartPage.clickToEditByProductName("");

        productPage.selectProcessorDropdown("");

        productPage.selectRAMDropdown("");

        productPage.selectHDDRadiobutton("");

        productPage.selectOSRadiobutton("");

        productPage.selectSoftwaresCheckbox("");

        productPage.clickToUpdateButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        verifyEqual(shoppingCartPage.getAddedProductInformations(), "");

        verifyEqual(shoppingCartPage.getNumberProductsInCart(), shoppingCartPage.getNumberProductsInShoppingCartLink);

        verifyEqual(shoppingCartPage.getSubTotalPrice(),"");
    }

    @Description("")
    @Story("")
    public void Order_03_(){
        shoppingCartPage.clickToRemoveButtonByProductName("");

        verifyEqual(shoppingCartPage.getEmptyShoppingCartMsg(), "");

        verifyTrue(shoppingCartPage.isAddedProductUnDisplayed());
    }

    @Description("")
    @Story("")
    public void Order_04_(){
        shoppingCartPage.openModuleInHeaderMenu(moduleTitle);
        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName2);

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        productPage = shoppingCartPage.clickToEditByProductName("");

        productPage.enterToQuantityTextbox("");

        productPage.clickToUpdateButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        verifyEqual(shoppingCartPage.getTotalPrice(), "");

        shoppingCartPage.clickToRemoveButtonByProductName("");
    }

    @Description("")
    @Story("")
    public void Order_05_(){
        shoppingCartPage.openModuleInHeaderMenu(moduleTitle);
        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategoryTitle);

        productPage = subCategoryPage.openProductByName(productName3);

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        shoppingCartPage.selectGiftWrappingDropdown();

        shoppingCartPage.clickToEstimateShipping();

        shoppingCartPage.selectCountryInShipToDropdown("");

        shoppingCartPage.selectStateInShipToDropdown("");

        shoppingCartPage.enterZipPostalCodeInShiptoTextbox("");

        shoppingCartPage.clickToShippingMethodRadioButton("");

        shoppingCartPage.clickToApply();

        shoppingCartPage.clickToAgreeCheckbox();

        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        checkoutPage.clickToUncheckShipToSameAddressCheckbox();

        checkoutPage.enterToBillingFirstnameTextbox("");

        checkoutPage.enterToBillingLastnameTextbox("");

        checkoutPage.enterToBillingEmailTextbox("");

        checkoutPage.selectBillingCountryDropdown("");

        checkoutPage.selectBillingStateProvinceDropdown("");

        checkoutPage.enterToBillingCityTextbox("");

        checkoutPage.enterToBillingAddress1Textbox("");

        checkoutPage.enterToBillingZipPostalCodeTextbox("");

        checkoutPage.enterToBillingPhoneNumberTextbox("");

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.selectAddressDropdown("New Address");

        checkoutPage.enterToShippingFirstNameTextbox("");

        checkoutPage.enterToShippingLastNameTextbox("");

        checkoutPage.enterToShippingEmailTextbox("");

        checkoutPage.selectShippingCountryDropdown("");

        checkoutPage.selectShippingStateProvinceDropdown("");

        checkoutPage.enterToShippingCityTextbox("");

        checkoutPage.enterToShippingAddress1Textbox("");

        checkoutPage.enterToShippingZipPostalCodeTextbox("");

        checkoutPage.enterToShippingPhoneNumberTextbox("");

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToGroundRadioButton();

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToCheckMoneyOrderRadioButton();

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getHeadingPaymentInformation(),"");

        verifyEqual(checkoutPage.getStoreAddressPaymentInformation(),"");

        verifyEqual(checkoutPage.getMessagePaymentInformation(),"");

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getBillingAddressFirstNameLastName(),"");

        verifyEqual(checkoutPage.getBillingAddressEmail(),"");

        verifyEqual(checkoutPage.getBillingAddressPhone(),"");

        verifyEqual(checkoutPage.getBillingAddressCountry(),"");

        verifyEqual(checkoutPage.getBillingAddressProvinceState(),"");

        verifyEqual(checkoutPage.getBillingAddressCity(),"");

        verifyEqual(checkoutPage.getBillingAddressAddress1(),"");

        verifyEqual(checkoutPage.getBillingAddressZipCode(),"");

        verifyEqual(checkoutPage.getBillingAddressPaymentMethod(), "");

        verifyEqual(checkoutPage.getShippingAddressFirstNameLastName(),"");

        verifyEqual(checkoutPage.getShippingAddressEmail(),"");

        verifyEqual(checkoutPage.getShippingAddressPhone(),"");

        verifyEqual(checkoutPage.getShippingAddressCountry(),"");

        verifyEqual(checkoutPage.getShippingAddressProvinceState(),"");

        verifyEqual(checkoutPage.getShippingAddressCity(),"");

        verifyEqual(checkoutPage.getShippingAddressAddress1(),"");

        verifyEqual(checkoutPage.getShippingAddressZipCode(),"");

        verifyEqual(checkoutPage.getShippingAddress(), "");

        verifyEqual(checkoutPage.getSKUProduct(), "");

        verifyEqual(checkoutPage.getProductName(), "");

        verifyEqual(checkoutPage.getProductPrice(), "");

        verifyEqual(checkoutPage.getTotalProductPrice(), "");

        verifyEqual(checkoutPage.getSubTotalPrice(), "");

        verifyEqual(checkoutPage.getShippingGroundFee(), "");

        verifyEqual(checkoutPage.getTaxFee(),"");

        verifyEqual(checkoutPage.getTotalPrice(), "");

        checkoutPage.clickToContinueButton();

        verifyEqual(checkoutPage.getThankYouTitle(),"Thank you");

        verifyEqual(checkoutPage.getOrderSuccessfullyMessage(), "");

        checkoutPage.getOrderNumber();

        customerInfoPage = checkoutPage.clickToMyAccountLink();

        orderPage = customerInfoPage.openOrdersPage();

        verifyEqual(orderPage.getOrderNumber(), "");

        verifyEqual(orderPage.getOrderStatus(),"");

        orderDetailPage = orderPage.clickToDeatailsButton();

        verifyEqual(orderDetailPage.getOrderNumberInOrderOverview(),"");

        verifyEqual(orderDetailPage.getOrderPageStatusInOrderOverview(), "");

        verifyEqual(orderDetailPage.getOrderTotalInOrderOverview(), "");

        verifyEqual(orderDetailPage.getBillingAddressFirstNameLastName(),"");

        verifyEqual(orderDetailPage.getBillingAddressEmail(),"");

        verifyEqual(orderDetailPage.getBillingAddressPhone(),"");

        verifyEqual(orderDetailPage.getBillingAddressCountry(),"");

        verifyEqual(orderDetailPage.getBillingAddressProvinceState(),"");

        verifyEqual(orderDetailPage.getBillingAddressCity(),"");

        verifyEqual(orderDetailPage.getBillingAddressAddress1(),"");

        verifyEqual(orderDetailPage.getBillingAddressZipCode(),"");

        verifyEqual(orderDetailPage.getBillingAddressPaymentMethod(), "");

        verifyEqual(orderDetailPage.getShippingAddressFirstNameLastName(),"");

        verifyEqual(orderDetailPage.getShippingAddressEmail(),"");

        verifyEqual(orderDetailPage.getShippingAddressPhone(),"");

        verifyEqual(orderDetailPage.getShippingAddressCountry(),"");

        verifyEqual(orderDetailPage.getShippingAddressProvinceState(),"");

        verifyEqual(orderDetailPage.getShippingAddressCity(),"");

        verifyEqual(orderDetailPage.getShippingAddressAddress1(),"");

        verifyEqual(orderDetailPage.getShippingAddressZipCode(),"");

        verifyEqual(orderDetailPage.getShippingAddress(), "");

        verifyEqual(orderDetailPage.getSKUProduct(), "");

        verifyEqual(orderDetailPage.getProductName(), "");

        verifyEqual(orderDetailPage.getProductPrice(), "");

        verifyEqual(orderDetailPage.getTotalProductPrice(), "");

        verifyEqual(orderDetailPage.getSubTotalPrice(), "");

        verifyEqual(orderDetailPage.getShippingGroundFee(), "");

        verifyEqual(orderDetailPage.getTaxFee(),"");

        verifyEqual(orderDetailPage.getTotalPrice(), "");
    }

    @Description("")
    @Story("")
    public void Order_06_(){

    }

    @Description("")
    @Story("")
    public void Order_07_(){

    }
}