package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.categories.ProductPageObject;
import pageObjects.orderCheckout.CheckoutPageObject;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends  BaseActions{
    public Object getNumberProductsInShoppingCartLink;
    WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get Added product name to cart by Product title column index")
    public String getAddedProductNameToCart() {
        String productColumnTitle = "Product(s)";

        waitForListElementsVisible(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_INDEX_BY_COLUMN, productColumnTitle);

        int index = getListElementsSize(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_INDEX_BY_COLUMN, productColumnTitle) + 1;

        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAME_BY_INDEX, String.valueOf(index));

        return getWebElementText(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAME_BY_INDEX, String.valueOf(index));
    }

    public Object getAddedProductInformations() {
    }

    public Object getNumberProductsInCart() {
    }

    public Object getSubTotalPrice() {
    }

    public ProductPageObject clickToEditByProductName(String s) {
    }

    public void clickToRemoveButtonByProductName(String s) {
    }

    public Object getEmptyShoppingCartMsg() {
    }

    public boolean isAddedProductUnDisplayed() {
    }

    public Object getTotalPrice() {
    }

    public void selectGiftWrappingDropdown() {
    }

    public void clickToEstimateShipping() {
    }

    public void selectCountryInShipToDropdown(String s) {
    }

    public void selectStateInShipToDropdown(String s) {
    }

    public void enterZipPostalCodeInShiptoTextbox(String s) {
    }

    public void clickToShippingMethodRadioButton(String s) {
    }

    public void clickToApply() {
    }

    public void clickToAgreeCheckbox() {
    }

    public CheckoutPageObject clickToCheckoutButton() {
        return null;
    }
}
