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
    private String productPrice, productSKU, orderStatus, shippingMethod, paymentMethod, subTotal, totalPrice, giftWrapping;

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

        shippingMethod = "Ground";

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

        shoppingCartPage.clickToShippingMethodRadioButton(shippingMethod);

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

        checkoutPage.clickToContinue();

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

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToGroundRadioButton();

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        checkoutPage.clickToCheckMoneyOrderRadioButton();

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getHeadingPaymentInformation(),"Mail Personal or Business Check, Cashier's Check or money order to:");

        verifyEqual(checkoutPage.getStoreAddressPaymentInformation(),
                "NOP SOLUTIONS\n" +
                "your address here,\n" +
                "New York, NY 10001\n" +
                "USA");

        verifyEqual(checkoutPage.getMessagePaymentInformation(),
                "Notice that if you pay by Personal or Business Check, " +
                "your order may be held for up to 10 days after we receive your check to allow enough time for the check to clear. " +
                "If you want us to ship faster upon receipt of your payment, " +
                "then we recommend your send a money order or Cashier's check.");

        checkoutPage.clickToContinue();

        checkoutPage.isLoadingNextStepInvisible();

        verifyEqual(checkoutPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getBillingAddressEmail(),email);

        verifyEqual(checkoutPage.getBillingAddressPhone(),phoneNumber);

        verifyEqual(checkoutPage.getBillingAddressCountry(),country);

        verifyEqual(checkoutPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getBillingAddressCity(),city);

        verifyEqual(checkoutPage.getBillingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(checkoutPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(checkoutPage.getShippingAddressEmail(),email);

        verifyEqual(checkoutPage.getShippingAddressPhone(),phoneNumber);

        verifyEqual(checkoutPage.getShippingAddressCountry(),country);

        verifyEqual(checkoutPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(checkoutPage.getShippingAddressCity(),city);

        verifyEqual(checkoutPage.getShippingAddressAddress1(),address1);

        verifyEqual(checkoutPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(checkoutPage.getShippingAddressMethod(), shippingMethod);

        productSKU = checkoutPage.getSKUProduct();

        verifyEqual(checkoutPage.getProductName(), productName.get(2));

        verifyEqual(checkoutPage.getProductPrice(), productPrice);

        verifyEqual(checkoutPage.getTotalProductPrice(), totalPrice);

        verifyEqual(checkoutPage.getSubTotalPrice(), subTotal);

        verifyEqual(checkoutPage.getTotalPrice(), totalPrice);

        checkoutPage.clickToContinueButton();

        verifyEqual(checkoutPage.getThankYouTitle(),"Thank you");

        verifyEqual(checkoutPage.getOrderSuccessfullyMessage(), "");

        checkoutPage.getOrderNumber();

        customerInfoPage = checkoutPage.clickToMyAccountLink();

        orderPage = customerInfoPage.openOrdersPage();

        orderNumber = orderPage.getOrderNumber();

        orderStatus = orderPage.getOrderStatus();

        orderDetailPage = orderPage.clickToDeatailsButton();

        verifyEqual(orderDetailPage.getOrderNumberInOrderOverview(),orderNumber);

        verifyEqual(orderDetailPage.getOrderPageStatusInOrderOverview(), orderStatus);

        verifyEqual(orderDetailPage.getOrderTotalInOrderOverview(), totalPrice);

        verifyEqual(orderDetailPage.getBillingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getBillingAddressEmail(),email);

        verifyEqual(orderDetailPage.getBillingAddressPhone(),phoneNumber);

        verifyEqual(orderDetailPage.getBillingAddressCountry(),country);

        verifyEqual(orderDetailPage.getBillingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getBillingAddressCity(),city);

        verifyEqual(orderDetailPage.getBillingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getBillingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getBillingAddressPaymentMethod(), paymentMethod);

        verifyEqual(orderDetailPage.getShippingAddressFirstNameLastName(),firstName+" "+lastName);

        verifyEqual(orderDetailPage.getShippingAddressEmail(),email);

        verifyEqual(orderDetailPage.getShippingAddressPhone(),phoneNumber);

        verifyEqual(orderDetailPage.getShippingAddressCountry(),country);

        verifyEqual(orderDetailPage.getShippingAddressProvinceState(),stateProvince);

        verifyEqual(orderDetailPage.getShippingAddressCity(),city);

        verifyEqual(orderDetailPage.getShippingAddressAddress1(),address1);

        verifyEqual(orderDetailPage.getShippingAddressZipCode(),zipPostalCode);

        verifyEqual(orderDetailPage.getShippingAddressMethod(), shippingMethod);

        verifyEqual(orderDetailPage.getSKUProduct(), productSKU);

        verifyEqual(orderDetailPage.getProductName(), productName.get(2));

        verifyEqual(orderDetailPage.getProductPrice(), productPrice);

        verifyEqual(orderDetailPage.getTotalProductPrice(), totalPrice);

        verifyEqual(orderDetailPage.getSubTotalPrice(), subTotal);

        verifyEqual(orderDetailPage.getTotalPrice(), totalPrice);
    }

    @Description("")
    @Story("")
    @Test
    public void Order_06_(){

    }

    @Description("")
    @Story("")
    @Test
    public void Order_07_(){

    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}