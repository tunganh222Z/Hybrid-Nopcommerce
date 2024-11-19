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
import pageObjects.orderCheckout.CheckoutPageObject;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.ProductPageObject;
import pageObjects.categories.SubCategoryPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.myAccount.OrderPageObject;
import pageObjects.orderCheckout.OrderDetailPageObject;
import ultilities.FakerConfig;
import userData.OrdersData;

import java.util.ArrayList;
import java.util.List;

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

    private FakerConfig fakerConfig;

    private String email, password;
    private String firstName, lastName, country, stateProvince,city, address1, zipPostalCode, phoneNumber;
    private String moduleTitle;
    private String processor, ram, hdd, os, orderNumber;
    private String productPrice, productSKU, orderStatus, paymentMethod, subTotal, totalPrice, giftWrapping;

    private List<String> shippingMethod;
    private List<String> softwareList;
    private List<OrdersData> ordersData;
    private List<String> subCategory;
    private List<String> productName;
    private List<String> quantity;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

        fakerConfig = FakerConfig.getFakerConfig();

        ordersData = new ArrayList<>();

        email = Register.email;
        password = Register.password;
        firstName = fakerConfig.getFirstName();
        lastName = fakerConfig.getLastName();
        city = fakerConfig.getCity();
        address1 = fakerConfig.getAddress1();
        zipPostalCode = fakerConfig.getZipCode();
        phoneNumber = fakerConfig.getPhoneNumber();
        country = "Vietnam";
        stateProvince = "Hà Nội";

        moduleTitle = "Computers";

        shippingMethod = new ArrayList<>(List.of(
                "Ground",
                "Ground ($0.00)",
                "Next Day Air ($0.00)",
                "Next Day Air"
        ));

        paymentMethod = "Check / Money Order";

        giftWrapping = "No";

        subCategory = new ArrayList<>(List.of(
                "Desktops",
                "Notebooks"
        ));



        productName = new ArrayList<>(List.of(
           "Build your own computer",
           "Lenovo IdeaCentre 600 All-in-One PC",
                "Apple MacBook Pro 13-inch"
        ));

        quantity = new ArrayList<>(List.of(
                "2",
                "4"
        ));

        orderNumber = "";

        orderStatus = "";

        productSKU = "";

        productPrice = "";

        totalPrice = "";

        //ordersData1
        processor ="2.5 GHz Intel Pentium Dual-Core E2200";
        ram = "8 GB";
        hdd = "400 GB [+$100.00]";
        os = "Vista premiun [+$60.00]";
        softwareList = new ArrayList<>(List.of(
                "Microsoft Office [+$50.00]",
                "Acrobat Reader [+$10.00]",
                "Total Commander [+$5.00]"
        ));
        ordersData.add(new OrdersData( processor, ram, hdd, os, softwareList));

        //orderData2
        processor ="2.2 GHz Intel Pentium Dual-Core E2200";
        ram = "4 GB";
        hdd = "400 GB [+$100.00]";
        os = "Vista Home [+50%]";
        softwareList = new ArrayList<>(List.of(
                "Microsoft Office [+$50.00]"
        ));
        ordersData.add(new OrdersData(processor, ram, hdd, os, softwareList));

        //login

        homePage = PageGenerator.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        homePage = loginPage.loginForm(driver, email, password);
    }

    @Description("Add to product to Cart then verify product info")
    @Story("Add_Product_To_Cart")
    @Test
    public void Order_01_Add_Product_To_Cart(){
        OrdersData ordersData1 = ordersData.get(0);

        homePage.openModuleInHeaderMenu(moduleTitle);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategory.get(0));

        productPage = subCategoryPage.openProductByName(productName.get(0));

        productPage.selectProcessorDropdown(ordersData1.getProcessor());

        productPage.selectRAMDropdown(ordersData1.getRam());

        productPage.selectHDDRadiobutton(ordersData1.getHdd());

        productPage.selectOSRadiobutton(ordersData1.getOs());

        productPage.selectSoftwareCheckbox(ordersData1.getSoftwareList());

        productPrice = productPage.getProductPrice();

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        productPage.hoverToShoppingCartIcon();

        verifyEqual(productPage.getProductNameInShoppingCartPopover(), productName.get(0));

        verifyEqual(productPage.getProductQuantityInShoppingCartPopover(),"There are 1 item(s) in your cart.");

        verifyEqual(productPage.getProductInformationInShoppingCartPopover(), ordersData1.getExpectedResult());

        verifyEqual(productPage.getProductPriceInShoppingCartPopover(), productPrice);

        subTotal = productPage.getSubTotalInShoppingCartPopover();

        shoppingCartPage = productPage.clickToShoppingCartLink();
    }

    @Description("")
    @Story("")
    @Test
    public void Order_02_(){
        OrdersData ordersData2 = ordersData.get(0);

        productPage = shoppingCartPage.clickToEditByProductName(productName.get(0));

        productPage.selectProcessorDropdown(ordersData2.getProcessor());

        productPage.selectRAMDropdown(ordersData2.getRam());

        productPage.selectHDDRadiobutton(ordersData2.getHdd());

        productPage.selectOSRadiobutton(ordersData2.getOs());

        productPage.selectSoftwareCheckbox(ordersData2.getSoftwareList());

        productPrice = productPage.getProductPrice();

        productPage.enterToQuantityTextbox(quantity.get(0));

        productPage.clickToUpdateButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        productPage.hoverToShoppingCartIcon();

        verifyEqual(productPage.getProductNameInShoppingCartPopover(), productName.get(0));

        verifyEqual(productPage.getProductQuantityInShoppingCartPopover(),"There are 2 item(s) in your cart.");

        verifyEqual(productPage.getProductInformationInShoppingCartPopover(), ordersData2.getExpectedResult());

        verifyEqual(productPage.getProductPriceInShoppingCartPopover(), productPrice);

        subTotal = productPage.getSubTotalInShoppingCartPopover();

        shoppingCartPage = productPage.clickToShoppingCartLink();
    }

    @Description("")
    @Story("")
    @Test
    public void Order_03_(){
        shoppingCartPage.clickToRemoveButtonByProductName(productName.get(0));

        verifyEqual(shoppingCartPage.getEmptyShoppingCartMsg(), "Your Shopping Cart is empty!");

        verifyTrue(shoppingCartPage.isAddedProductUnDisplayedByProductName(productName.get(0)));
    }

    @Description("")
    @Story("")
    @Test
    public void Order_04_(){
        shoppingCartPage.openModuleInHeaderMenu(moduleTitle);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategory.get(0));

        productPage = subCategoryPage.openProductByName(productName.get(1));

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        productPrice = productPage.getProductPrice();

        productPage.enterToQuantityTextbox(quantity.get(1));

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        productPage.hoverToShoppingCartIcon();

        verifyEqual(productPage.getProductNameInShoppingCartPopover(), productName.get(1));

        verifyEqual(productPage.getProductQuantityInShoppingCartPopover(),"There are 5 item(s) in your cart.");

        verifyEqual(productPage.getProductPriceInShoppingCartPopover(), productPrice);

        subTotal = productPage.getSubTotalInShoppingCartPopover();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        shoppingCartPage.clickToRemoveButtonByProductName(productName.get(1));

        verifyEqual(shoppingCartPage.getEmptyShoppingCartMsg(), "Your Shopping Cart is empty!");

        verifyTrue(shoppingCartPage.isAddedProductUnDisplayedByProductName(productName.get(1)));
    }

    @Description("")
    @Story("")
    @Test
    public void Order_05_(){

        shoppingCartPage.openModuleInHeaderMenu(moduleTitle);

        mainCategoryPage = PageGenerator.getMainCategoryPage(driver);

        subCategoryPage = mainCategoryPage.openSubCategoryByTitle(subCategory.get(1));

        productPage = subCategoryPage.openProductByName(productName.get(2));

        productPrice = productPage.getProductPrice();

        productPage.clickToAddToCartButton();

        productPage.waitAjaxLoadingInvisible();

        verifyEqual(productPage.getStatusNotifyBar(), "The product has been added to your shopping cart");

        productPage.clickToCloseNotifyBar();

        productPage.hoverToShoppingCartIcon();

        verifyEqual(productPage.getProductNameInShoppingCartPopover(), productName.get(2));

        verifyEqual(productPage.getProductQuantityInShoppingCartPopover(),"There are 2 item(s) in your cart.");;

        verifyEqual(productPage.getProductPriceInShoppingCartPopover(), productPrice);

        subTotal = productPage.getSubTotalInShoppingCartPopover();

        shoppingCartPage = productPage.clickToShoppingCartLink();

        shoppingCartPage.selectGiftWrappingDropdown(giftWrapping);

        shoppingCartPage.clickToEstimateShipping();

        shoppingCartPage.selectCountryInShipToDropdown(country);

        shoppingCartPage.selectStateInShipToDropdown(stateProvince);

        shoppingCartPage.enterZipPostalCodeInShipToTextbox(zipPostalCode);

        shoppingCartPage.clickToShippingMethodRadioButton(shippingMethod.get(0));

        totalPrice = shoppingCartPage.getTotalPriceInTotalInfo();

        shoppingCartPage.clickToApply();

        shoppingCartPage.waitShippingPopupInvisible();

        shoppingCartPage.clickToAgreeCheckbox();

        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        checkoutPage.clickToUncheckShipToSameAddressCheckbox();

        checkoutPage.enterToBillingFirstnameTextbox(firstName);

        checkoutPage.enterToBillingLastnameTextbox(lastName);

        checkoutPage.enterToBillingEmailTextbox(email);

        checkoutPage.selectBillingCountryDropdown(country);

        checkoutPage.selectBillingStateProvinceDropdown(stateProvince);

        checkoutPage.enterToBillingCityTextbox(city);

        checkoutPage.enterToBillingAddress1Textbox(address1);

        checkoutPage.enterToBillingZipPostalCodeTextbox(zipPostalCode);

        checkoutPage.enterToBillingPhoneNumberTextbox(phoneNumber);

        checkoutPage.clickToContinueBillingAddressButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.selectAddressDropdown("New Address");

        checkoutPage.enterToShippingFirstNameTextbox(firstName);

        checkoutPage.enterToShippingLastNameTextbox(lastName);

        checkoutPage.enterToShippingEmailTextbox(email);

        checkoutPage.selectShippingCountryDropdown(country);

        checkoutPage.selectShippingStateProvinceDropdown(stateProvince);

        checkoutPage.enterToShippingCityTextbox(city);

        checkoutPage.enterToShippingAddress1Textbox(address1);

        checkoutPage.enterToShippingZipPostalCodeTextbox(zipPostalCode);

        checkoutPage.enterToShippingPhoneNumberTextbox(phoneNumber);

        checkoutPage.clickToContinueShippingAddressButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToRadioButtonByShippingMethod(shippingMethod.get(1));

        checkoutPage.clickToContinueShippingMethodButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToPaymentMethodRadioButton(paymentMethod);

        checkoutPage.clickToContinuePaymentMethodButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToContinuePaymentInformationButton();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getBillingAddressEmail(),"Email: " + email);

        verifyEqual(checkoutPage.getBillingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(checkoutPage.getBillingAddressCountry(),country);

        verifyEqual(checkoutPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getBillingAddressCity(),city);

        verifyEqual(checkoutPage.getBillingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(checkoutPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getShippingAddressEmail(),"Email: " + email);

        verifyEqual(checkoutPage.getShippingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(checkoutPage.getShippingAddressCountry(),country);

        verifyEqual(checkoutPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getShippingAddressCity(),city);

        verifyEqual(checkoutPage.getShippingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getShippingAddressMethod(), shippingMethod.get(0));

        productSKU = checkoutPage.getSKUProductByProductName(productName.get(2));

        verifyEqual(checkoutPage.getProductName(), productName.get(2));

        verifyEqual(checkoutPage.getProductPriceByProductName(productName.get(2)), productPrice);

        verifyEqual(checkoutPage.getTotalProductPriceByProductName(productName.get(2)), totalPrice);

        verifyEqual(checkoutPage.getSubTotalPrice(), subTotal);

        verifyEqual(checkoutPage.getTotalPrice(), totalPrice);

        checkoutPage.clickToConfirmButton();

        verifyEqual(checkoutPage.getThankYouTitle(),"Thank you");

        verifyEqual(checkoutPage.getOrderSuccessfullyMessage(), "Your order has been successfully processed!");

        orderNumber = checkoutPage.getOrderNumber();

        customerInfoPage = checkoutPage.clickToMyAccountLink();

        orderPage = customerInfoPage.openOrdersPage();

        orderStatus = orderPage.getOrderStatusByOrderNumber(orderNumber);

        orderDetailPage = orderPage.clickToDetailsButtonByOrderNumber(orderNumber);

        verifyEqual(orderDetailPage.getOrderTotalInOrderOverview(), totalPrice);

        verifyEqual(orderDetailPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getBillingAddressEmail(),"Email: " + email);

        verifyEqual(orderDetailPage.getBillingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(orderDetailPage.getBillingAddressCountry(),country);

        verifyEqual(orderDetailPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getBillingAddressCity(),city);

        verifyEqual(orderDetailPage.getBillingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(orderDetailPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getShippingAddressEmail(),"Email: " + email);

        verifyEqual(orderDetailPage.getShippingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(orderDetailPage.getShippingAddressCountry(),country);

        verifyEqual(orderDetailPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getShippingAddressCity(),city);

        verifyEqual(orderDetailPage.getShippingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getShippingAddressMethod(), shippingMethod.get(0));

        verifyEqual(orderDetailPage.getSKUProductByProductName(productName.get(2)), productSKU);

        verifyEqual(orderDetailPage.getProductName(), productName.get(2));

        verifyEqual(orderDetailPage.getProductPriceByProductName(productName.get(2)), productPrice);

        verifyEqual(orderDetailPage.getTotalProductPriceByProductName(productName.get(2)), totalPrice);

        verifyEqual(orderDetailPage.getSubTotalPrice(), subTotal);

        verifyEqual(orderDetailPage.getTotalPrice(), totalPrice);

        customerInfoPage = orderDetailPage.clickToMyAccountLink();

        orderPage = customerInfoPage.openOrdersPage();
    }


    @Description("")
    @Story("")
    @Test
    public void Order_07_Reorder(){
        orderDetailPage = orderPage.clickToDetailsButtonByOrderNumber(orderNumber);

        shoppingCartPage = orderDetailPage.clickToReOrder();

        shoppingCartPage.enterToQuantityTextbox("");

        totalPrice = shoppingCartPage.getTotalPriceInTotalInfo();

        shoppingCartPage.clickToAgreeCheckbox();

        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        checkoutPage.clickToUncheckShipToSameAddressCheckbox();

        checkoutPage.selectBillingAddressInDropdown("New Address");

        checkoutPage.enterToBillingFirstnameTextbox(firstName);

        checkoutPage.enterToBillingLastnameTextbox(lastName);

        checkoutPage.enterToBillingEmailTextbox(email);

        checkoutPage.selectBillingCountryDropdown(country);

        checkoutPage.selectBillingStateProvinceDropdown(stateProvince);

        checkoutPage.enterToBillingCityTextbox(city);

        checkoutPage.enterToBillingAddress1Textbox(address1);

        checkoutPage.enterToBillingZipPostalCodeTextbox(zipPostalCode);

        checkoutPage.enterToBillingPhoneNumberTextbox(phoneNumber);

        checkoutPage.clickToContinueBillingAddressButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.selectAddressDropdown("New Address");

        checkoutPage.enterToShippingFirstNameTextbox(firstName);

        checkoutPage.enterToShippingLastNameTextbox(lastName);

        checkoutPage.enterToShippingEmailTextbox(email);

        checkoutPage.selectShippingCountryDropdown(country);

        checkoutPage.selectShippingStateProvinceDropdown(stateProvince);

        checkoutPage.enterToShippingCityTextbox(city);

        checkoutPage.enterToShippingAddress1Textbox(address1);

        checkoutPage.enterToShippingZipPostalCodeTextbox(zipPostalCode);

        checkoutPage.enterToShippingPhoneNumberTextbox(phoneNumber);

        checkoutPage.clickToContinueShippingAddressButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToRadioButtonByShippingMethod(shippingMethod.get(2));

        checkoutPage.clickToContinueShippingMethodButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToPaymentMethodRadioButton(paymentMethod);

        checkoutPage.clickToContinuePaymentMethodButton();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToContinuePaymentInformationButton();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getBillingAddressEmail(),"Email: " + email);

        verifyEqual(checkoutPage.getBillingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(checkoutPage.getBillingAddressCountry(),country);

        verifyEqual(checkoutPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getBillingAddressCity(),city);

        verifyEqual(checkoutPage.getBillingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(checkoutPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getShippingAddressEmail(),"Email: " + email);

        verifyEqual(checkoutPage.getShippingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(checkoutPage.getShippingAddressCountry(),country);

        verifyEqual(checkoutPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getShippingAddressCity(),city);

        verifyEqual(checkoutPage.getShippingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getShippingAddressMethod(), shippingMethod.get(3));

        productSKU = checkoutPage.getSKUProductByProductName(productName.get(2));

        verifyEqual(checkoutPage.getProductName(), productName.get(2));

        verifyEqual(checkoutPage.getProductPriceByProductName(productName.get(2)), productPrice);

        verifyEqual(checkoutPage.getTotalProductPriceByProductName(productName.get(2)), totalPrice);

        verifyEqual(checkoutPage.getSubTotalPrice(), subTotal);

        verifyEqual(checkoutPage.getTotalPrice(), totalPrice);

        checkoutPage.clickToConfirmButton();

        verifyEqual(checkoutPage.getThankYouTitle(),"Thank you");

        verifyEqual(checkoutPage.getOrderSuccessfullyMessage(), "Your order has been successfully processed!");

        orderNumber = checkoutPage.getOrderNumber();

        customerInfoPage = checkoutPage.clickToMyAccountLink();

        orderPage = customerInfoPage.openOrdersPage();

        orderStatus = orderPage.getOrderStatusByOrderNumber(orderNumber);

        orderDetailPage = orderPage.clickToDetailsButtonByOrderNumber(orderNumber);

        verifyEqual(orderDetailPage.getOrderTotalInOrderOverview(), totalPrice);

        verifyEqual(orderDetailPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getBillingAddressEmail(),"Email: " + email);

        verifyEqual(orderDetailPage.getBillingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(orderDetailPage.getBillingAddressCountry(),country);

        verifyEqual(orderDetailPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getBillingAddressCity(),city);

        verifyEqual(orderDetailPage.getBillingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(orderDetailPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getShippingAddressEmail(),"Email: " + email);

        verifyEqual(orderDetailPage.getShippingAddressPhone(),"Phone: " + phoneNumber);

        verifyEqual(orderDetailPage.getShippingAddressCountry(),country);

        verifyEqual(orderDetailPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getShippingAddressCity(),city);

        verifyEqual(orderDetailPage.getShippingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getShippingAddressMethod(), shippingMethod.get(3));

        verifyEqual(orderDetailPage.getSKUProductByProductName(productName.get(2)), productSKU);

        verifyEqual(orderDetailPage.getProductName(), productName.get(2));

        verifyEqual(orderDetailPage.getProductPriceByProductName(productName.get(2)), productPrice);

        verifyEqual(orderDetailPage.getTotalProductPriceByProductName(productName.get(2)), totalPrice);

        verifyEqual(orderDetailPage.getSubTotalPrice(), subTotal);

        verifyEqual(orderDetailPage.getTotalPrice(), totalPrice);

    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}