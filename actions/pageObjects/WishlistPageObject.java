package pageObjects;

import commons.BaseActions;
import commons.PageGenerator;
import commons.ShoppingCartPageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.WishlistPageUI;

public class WishlistPageObject extends BaseActions {
    WebDriver driver;

    public WishlistPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Click to URL sharing")
    public void clickToWishlistURLForSharingLink() {
        waitForElementClickable(driver, WishlistPageUI.URL_SHARING_LINK);
        clickToElement(driver, WishlistPageUI.URL_SHARING_LINK);
    }

    @Step("Get title of Wishlist sharing")
    public String getWishlistTitleFromURLSharing() {
        waitForElementVisible(driver, WishlistPageUI.WISHLIST_PAGE_TITLE);
        return getWebElementText(driver, WishlistPageUI.WISHLIST_PAGE_TITLE);
    }

    @Step("Click to add to cart checkbox by product name is {0}")
    public void clickToAddToCartCheckboxByProductName(String productName) {
        waitForElementClickable(driver, WishlistPageUI.DYNAMIC_CHECKBOX_BY_PRODUCT_NAME, productName);
        clickToElement(driver, WishlistPageUI.DYNAMIC_CHECKBOX_BY_PRODUCT_NAME, productName);
    }

    @Step("Click to Add to cart button")
    public ShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
        return PageGenerator.getShoppingCartPage(driver);
    }

    @Step("Verify product un displayed by product name {0}")
    public boolean isProductUnDisplayedInWishlistByName(String productName) {
        return isELementUndisplayed(driver, WishlistPageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
    }

    @Step("Remove product from wishlist page by product name {0}")
    public void clickToRemoveByProductName(String productName) {
        waitForElementClickable(driver, WishlistPageUI.DYNAMIC_REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(driver, WishlistPageUI.DYNAMIC_REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
    }

    @Step("Get empty message from Wishlist page")
    public String getEmptyWishlistPageMessage() {
        waitForElementVisible(driver, WishlistPageUI.EMPTY_WISHLIST_MESSAGE);
        return getWebElementText(driver, WishlistPageUI.EMPTY_WISHLIST_MESSAGE);
    }

    @Step("Get added product name to wishlist page")
    public String getProductNameAddedToWishlistPage() {
        return getWebElementText(driver, WishlistPageUI.PRODUCT_NAME);
    }

    @Step("Verify product displayed by product name {0} ")
    public boolean isProductDisplayedInWishlistByName(String productName) {
        if (isELementUndisplayed(driver, WishlistPageUI.DYNAMIC_PRODUCT_BY_NAME, productName) == false){
            return true;
        } else {
            return false;
        }
    }
}
