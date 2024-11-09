package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import pageObjects.categories.CompareProductsListPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageUIs.BaseActionsPageUI;
import pageUIs.myAccount.CustomerInfoPageUI;

public class BaseActions extends BasePage{
    WebDriver driver;
    public BaseActions (WebDriver driver){
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, BaseActionsPageUI.REGISTER_LINK);
        clickToElement(driver, BaseActionsPageUI.REGISTER_LINK);
        return PageGenerator.getRegisterPage(driver);
    }

    @Step("Click Nopcommerce Logo to back Homepage")
    public HomePageObject clickNopcommerceLogo() {
        waitForElementClickable(driver, BaseActionsPageUI.NOPCOMMERCE_LOGO);
        clickToElement(driver, BaseActionsPageUI.NOPCOMMERCE_LOGO);
        return PageGenerator.getHomePage(driver);
    }

    @Step("Click Logout link to back Homepage")
    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, BaseActionsPageUI.LOGOUT_LINK);
        clickToElement(driver, BaseActionsPageUI.LOGOUT_LINK);
        return PageGenerator.getHomePage(driver);
    }

    @Step("Click Login link to open Login page")
    public LoginPageObjects clickToLoginLink() {
        waitForElementClickable(driver, BaseActionsPageUI.LOGIN_LINK);
        clickToElement(driver, BaseActionsPageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }

    @Step("Click My Account link to open My Account page")
    public CustomerInfoPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, BaseActionsPageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, BaseActionsPageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getMyAccountPage(driver);
    }

    @Step("Open Module in Header menu By name is {0}")
    public void openModuleInHeaderMenu(String module) {
        waitForElementClickable(driver, BaseActionsPageUI.DYNAMIC_MODULE_HEADER_MENU, module);
        clickToElement(driver, BaseActionsPageUI.DYNAMIC_MODULE_HEADER_MENU, module);
    }

    @Step("Click Close button to close Notify Bar and Wait Notify Bar invisible")
    public void clickToCloseNotifyBar() {
        waitForElementClickable(driver, BaseActionsPageUI.NOTIFY_BAR_CLOSE_BUTTON);
        clickToElement(driver, BaseActionsPageUI.NOTIFY_BAR_CLOSE_BUTTON);
        waitForElementInvisible(driver, BaseActionsPageUI.NOTIFY_BAR);
    }

    @Step("Verify Updated Successfully bar is displayed")
    public String getStatusNotifyBar() {
        waitForElementVisible(driver, CustomerInfoPageUI.STATUS_NOTIFY_BAR);
        return getWebElementText(driver, CustomerInfoPageUI.STATUS_NOTIFY_BAR);
    }

    @Step("Enter Search Keywords to Search textbox in Header, keyword is {0}")
    public void enterToSearchTextboxInHeader(String searchKeywords) {
        waitForElementVisible(driver, BaseActionsPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, BaseActionsPageUI.SEARCH_TEXTBOX, searchKeywords);
    }

    @Step("Click To Search Button in header")
    public SearchPageObject clickToSearchButtonInHeader() {
        waitForElementClickable(driver, BaseActionsPageUI.SEARCH_BUTTON);
        clickToElement(driver, BaseActionsPageUI.SEARCH_BUTTON);
        return PageGenerator.getSearchPage(driver);
    }

    @Step("Get text in Search alert")
    public String getTextInSearchAlert() {
        return getTextInAlert(driver);
    }

    @Step("Click to Accept in Search alert")
    public void clickAcceptInSearchAlert() {
        acceptToAlert(driver);
    }

    @Step("Wait Ajax loading invisible")
    public void waitAjaxLoadingInvisible() {
        waitForElementInvisible(driver, BaseActionsPageUI.AJAX_LOADING_ICON);
    }

    @Step("Click to Compare Products list link")
    public CompareProductsListPageObject clickToCompareProductsListLink() {
        waitForElementClickable(driver, BaseActionsPageUI.COMPARE_PRODUCTS_LIST_LINK);
        clickToElement(driver, BaseActionsPageUI.COMPARE_PRODUCTS_LIST_LINK);
        return PageGenerator.getCompareProductsList(driver);
    }

    @Step("Click to Wishlist Link")
    public WishlistPageObject clickToWishlistLink() {
        waitForElementClickable(driver, BaseActionsPageUI.WISHLIST_LINK);
        clickToElement(driver, BaseActionsPageUI.WISHLIST_LINK);
        return PageGenerator.getWishlistPage(driver);
    }

    @Step("Open shopping cart page")
    public ShoppingCartPageObject clickToShoppingCartLink() {
        waitForElementClickable(driver, BaseActionsPageUI.SHOPPING_CART_LINK);
        clickToElement(driver, BaseActionsPageUI.SHOPPING_CART_LINK);
        return PageGenerator.getShoppingCartPage(driver);
    }

    @Step("Hover mouse to shopping cart popover")
    public void hoverToShoppingCartIcon() {
        waitForElementVisible(driver, BaseActionsPageUI.SHOPPING_CART_LINK);
        scrollToElementOnTop(driver, BaseActionsPageUI.SHOPPING_CART_LINK);
        hoverToElement(driver, BaseActionsPageUI.SHOPPING_CART_LINK);
    }

    @Step("Get product name in Shopping Cart Popover")
    public String getProductNameInShoppingCartPopover() {
        waitForElementVisible(driver, BaseActionsPageUI.PRODUCT_NAME_CART_POPOVER);
        return getWebElementText(driver, BaseActionsPageUI.PRODUCT_NAME_CART_POPOVER);
    }

    @Step("Get product quantity in Shopping Cart Popover")
    public String getProductQuantityInShoppingCartPopover() {
        waitForElementVisible(driver, BaseActionsPageUI.PRODUCT_QUANTITY_CART_POPOVER);
        return getWebElementText(driver, BaseActionsPageUI.PRODUCT_QUANTITY_CART_POPOVER);
    }

    @Step("Get product information in Shopping Cart Popover")
    public String getProductInformationInShoppingCartPopover() {
        waitForElementVisible(driver, BaseActionsPageUI.PRODUCT_INFORMATION_CART);
        return getWebElementText(driver, BaseActionsPageUI.PRODUCT_INFORMATION_CART);
    }

    @Step("Get product price in Shopping Cart Popover")
    public String getProductPriceInShoppingCartPopover() {
        waitForElementVisible(driver, BaseActionsPageUI.PRODUCT_PRICE_CART_POPOVER);
        return getWebElementText(driver, BaseActionsPageUI.PRODUCT_PRICE_CART_POPOVER);
    }

    @Step("Get sub-total in Shopping Cart Popover")
    public String getSubTotalInShoppingCartPopover() {
        waitForElementVisible(driver, BaseActionsPageUI.PRODUCT_SUB_TOTAL_CART_POPOVER);
        return getWebElementText(driver, BaseActionsPageUI.PRODUCT_SUB_TOTAL_CART_POPOVER);
    }
}
