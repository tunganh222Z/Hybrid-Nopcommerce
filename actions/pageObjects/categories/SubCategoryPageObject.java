package pageObjects.categories;

import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.SearchPageUI;
import pageUIs.categories.SubCategoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Step("Select item in sort by dropdown is {0}")
    public void selectItemInSortByDropdown(String itemSortBy) {
        selectItemInDefaultDropdown(driver, SubCategoryPageUI.SORT_BY_DROPDOWN, itemSortBy);
    }

    @Step("Verify product name sort by Descending")
    public boolean isProductsNameSortByDescending() {
        waitForListElementsVisible(driver, SubCategoryPageUI.PRODUCTS_NAME);

        List<WebElement> listProductsName = getListWebElements(driver, SubCategoryPageUI.PRODUCTS_NAME);

        List<String> actualProductsNameDisplay = new ArrayList<String>();
        List<String> expectedProductNameDisplay = new ArrayList<String>();

        for (WebElement productName : listProductsName){
            actualProductsNameDisplay.add(productName.getText());

            expectedProductNameDisplay.add(productName.getText());
        }
        Collections.sort(expectedProductNameDisplay);

        Collections.reverse(expectedProductNameDisplay);

        return actualProductsNameDisplay.equals(expectedProductNameDisplay);
    }

    @Step("Verify product name sort by Ascending")
    public boolean isProductsNameSortByAscending() {
        waitForListElementsVisible(driver, SubCategoryPageUI.PRODUCTS_NAME);

        List<WebElement> listProductsName = getListWebElements(driver, SubCategoryPageUI.PRODUCTS_NAME);
        
        List<String> actualProductsNameDisplay = new ArrayList<String>();
        List<String> expectedProductNameDisplay = new ArrayList<String>();

        for (WebElement productName : listProductsName){
            actualProductsNameDisplay.add(productName.getText());

            expectedProductNameDisplay.add(productName.getText());
        }

        Collections.sort(expectedProductNameDisplay);

        return actualProductsNameDisplay.equals(expectedProductNameDisplay);
    }

    @Step("Verify product price sort by Low to High")
    public boolean isProductsPriceSortByLowToHigh() {
        waitForListElementsVisible(driver, SubCategoryPageUI.PRODUCTS_PRICE);

        List<WebElement> listProductsPrice = getListWebElements(driver, SubCategoryPageUI.PRODUCTS_PRICE);

        List<Double> actualProductsPriceDisplay = new ArrayList<Double>();
        List<Double> expectedProductsPriceDisplay = new ArrayList<Double>();

        for (WebElement productPrice : listProductsPrice){
            actualProductsPriceDisplay.add(Double.valueOf(productPrice.getText().replace("$", "").replace(",", "")));
            expectedProductsPriceDisplay.add(Double.valueOf(productPrice.getText().replace("$", "").replace(",", "")));
        }

        Collections.sort(expectedProductsPriceDisplay);

        return actualProductsPriceDisplay.equals(expectedProductsPriceDisplay);
    }

    @Step("Verify product price sort by High to Low")
    public boolean isProductsNameSortByHighToLow() {
        waitForListElementsVisible(driver, SubCategoryPageUI.PRODUCTS_PRICE);

        List<WebElement> listProductsPrice = getListWebElements(driver, SubCategoryPageUI.PRODUCTS_PRICE);

        List<Double> actualProductsPriceDisplay = new ArrayList<Double>();
        List<Double> expectedProductsPriceDisplay = new ArrayList<Double>();

        for (WebElement productPrice : listProductsPrice){
            actualProductsPriceDisplay.add(Double.valueOf(productPrice.getText().replace("$", "").replace(",", "")));
            expectedProductsPriceDisplay.add(Double.valueOf(productPrice.getText().replace("$", "").replace(",", "")));
        }

        Collections.sort(expectedProductsPriceDisplay);

        Collections.reverse(expectedProductsPriceDisplay);

        return actualProductsPriceDisplay.equals(expectedProductsPriceDisplay);
    }

    @Step("Select number product display in dropdown, the number products display is {0}")
    public void selectNumberProductDisplayDropdown(int numberProductsDisplay) {
        selectItemInDefaultDropdown(driver, SubCategoryPageUI.DISPLAY_PER_PAGE_DROPDOWN, String.valueOf(numberProductsDisplay));
    }

    @Step("Verify number products display maximum or less than {0}")
    public boolean isProductsDisplayMaximumOrLess(int maximumOrLess) {
        waitForListElementsVisible(driver, SubCategoryPageUI.PRODUCTS_NAME);

        if (getListWebElements(driver, SubCategoryPageUI.PRODUCTS_NAME).size() <= maximumOrLess){
            return true;
        } else {
            return false;
        }
    }

    @Step("Verify Next icon display")
    public boolean isNextIconDisplay() {
        return getWebElement(driver, SubCategoryPageUI.NEXT_PAGE_ICON).isDisplayed();
    }

    @Step("Verify Previous icon display")
    public boolean isPreviousIconDisplay() {
        return getWebElement(driver, SubCategoryPageUI.PREVIOUS_PAGE_ICON).isDisplayed();
    }

    @Step("Open first page")
    public void openFirstPage(){
        waitForListElementsVisible(driver, SubCategoryPageUI.UNSELECTED_PAGES);

        List<WebElement>listUnselectedPages = getListWebElements(driver, SubCategoryPageUI.UNSELECTED_PAGES);

        int currentSelectedPage = Integer.valueOf(getWebElement(driver, SubCategoryPageUI.SELECTED_PAGE).getText());

        for (int i = listUnselectedPages.size() -1 ; i >= 0; i--){
            listUnselectedPages = getListWebElements(driver, SubCategoryPageUI.UNSELECTED_PAGES);

            int unselectedPage = Integer.valueOf(listUnselectedPages.get(i).getText());

            if (currentSelectedPage > unselectedPage){

                listUnselectedPages.get(i).click();

                currentSelectedPage = unselectedPage;

                i = listUnselectedPages.size();
            }
        }
    }

    @Step("Open last page")
    public void openLastPage(){
        waitForListElementsVisible(driver, SubCategoryPageUI.UNSELECTED_PAGES);

        List<WebElement>listUnselectedPages = getListWebElements(driver, SubCategoryPageUI.UNSELECTED_PAGES);

        int currentSelectedPage = Integer.valueOf(getWebElement(driver, SubCategoryPageUI.SELECTED_PAGE).getText());

        for (int i = 0; i < listUnselectedPages.size(); i++){
            listUnselectedPages = getListWebElements(driver, SubCategoryPageUI.UNSELECTED_PAGES);

            int unselectedPage = Integer.valueOf(listUnselectedPages.get(i).getText());

            if (currentSelectedPage < unselectedPage){

                currentSelectedPage = unselectedPage;

                listUnselectedPages.get(i).click();

                i = 0;
            }
        }
    }

    @Step("Verify Paging control UnDisplay")
    public boolean isPagingUnDisplay() {
        return isELementUndisplayed(driver, SubCategoryPageUI.PAGINATION_CONTROL);
    }

    @Step("Click to add to compare button by Product name")
    public void clickAddToCompareListByProductName(String productName) {
        waitForElementClickable(driver, SubCategoryPageUI.ADD_TO_COMPARE_BUTTON,productName);
        clickToElement(driver, SubCategoryPageUI.ADD_TO_COMPARE_BUTTON,productName);
    }

    public void openProductByProductList(List<String> productList) {
        for (String product : productList){
            openProductByName(product);
            driver.navigate().back();
        }
    }

    public List<String> getRecentlyViewedProducts() {
        List<WebElement> listProductsName = getListWebElements(driver, SubCategoryPageUI.RECENTLY_VIEWED_PRODUCTS_NAME);
        List<String> recentlyViewedProductList = new ArrayList<String>();

        for (WebElement productName : listProductsName){
            recentlyViewedProductList.add(productName.getText());
        }
        return recentlyViewedProductList;
    }
}
