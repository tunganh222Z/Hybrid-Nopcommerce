package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends  BaseActions{
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
}
