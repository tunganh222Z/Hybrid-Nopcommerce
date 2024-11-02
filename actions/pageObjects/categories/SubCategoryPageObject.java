package pageObjects.categories;

import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.SubCategoryPageUI;

public class SubCategoryPageObject extends MainCategoryPageObject{
    WebDriver driver;
    public SubCategoryPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Open product name is {0}")
    public ProductPageObject openProductByName(String productName) {
        waitForElementClickable(driver, SubCategoryPageUI.DYNAMIC_PRODUCT_BY_NAME, productName);
        clickToElement(driver, SubCategoryPageUI.DYNAMIC_PRODUCT_BY_NAME,productName);
        return PageGenerator.getProductPage(driver);
    }
}
