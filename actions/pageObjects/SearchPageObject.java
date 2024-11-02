package pageObjects;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.SearchPageUI;

import java.util.List;

public class SearchPageObject extends BaseActions {
    WebDriver driver;
    public SearchPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Enter to Search textbox in Search page, search keywords is {0}")
    public void enterToSearchTextbox(String searchKeywords) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchKeywords);
    }

    @Step("Click to Search button in Search page")
    public void clickToSearchButton() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
    }

    @Step("Get the number of products are displaying")
    public String getNumberProductsDisplayed() {
        waitForListElementsVisible(driver, SearchPageUI.LIST_PRODUCTS_DISPLAY);
        return String.valueOf(getListElementsSize(driver, SearchPageUI.LIST_PRODUCTS_DISPLAY));
    }

    @Step("Get Search Message after search")
    public String getSearchMessage() {
        waitForElementVisible(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
        return getWebElementText(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
    }

    @Step("Click to Enable Advanced Search")
    public void clickToEnableAdvancedSearch() {
        waitForElementVisible(driver, SearchPageUI.ADVANCED_CHECKBOX);

        if (!isElementSelected(driver, SearchPageUI.ADVANCED_CHECKBOX)){
            clickToElement(driver, SearchPageUI.ADVANCED_CHECKBOX);
        }
    }

    @Step("Select Category dropdown, select {0}")
    public void selectCategoryDropdown(String categoryExpected) {
        waitForElementClickable(driver, SearchPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWN, categoryExpected);
    }

    @Step("Click to Disable Automatically Search Sub Categories")
    public void clickToDisableAutomaticallySearchSubCategories() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        if (isElementSelected(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX)){
            clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        }
    }

    @Step("Click to Enable Automatically Search Sub Categories")
    public void clickToEnableAutomaticallySearchSubCategories() {
        waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        if (!isElementSelected(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX)){
            clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
        }
    }

    @Step("Select Manufacturer dropdown, select {0}")
    public void selectManufacturerDropdown(String manufacturerExpected) {
        waitForElementClickable(driver, SearchPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWN, manufacturerExpected);
    }

    public String getProductsNameDisplayed() {
        String listProductNames="";

        List<WebElement> ProductNames = getListWebElements(driver, SearchPageUI.LIST_PRODUCTS_NAME);

        for (WebElement productName : ProductNames){
            listProductNames = listProductNames + productName.getText() +", ";
        }
        return listProductNames.substring(0, listProductNames.length()-2);
    }
}
