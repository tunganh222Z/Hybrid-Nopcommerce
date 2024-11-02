package pageUIs;

public class SearchPageUI {
    public static final String SEARCH_TEXTBOX = "xpath=//div[@class='basic-search']//input[@class='search-text']";
    public static final String SEARCH_BUTTON = "xpath=//div[@class='search-input']//button";
    public static final String LIST_PRODUCTS_DISPLAY = "xpath=//div[@class='product-item']";
    public static final String SEARCH_ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class='no-result']";
    public static final String ADVANCED_CHECKBOX = "xpath=//div[@class='basic-search']//input[@type='checkbox']";
    public static final String CATEGORY_DROPDOWN = "xpath=//label[contains(text(),'Category')]/following-sibling::select";
    public static final String AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX =  "xpath=//div[@class='advanced-search']//label[contains(text(),'Automatically search sub categories')]/preceding-sibling::input";
    public static final String MANUFACTURER_DROPDOWN = "xpath=//label[contains(text(),'Manufacturer')]/following-sibling::select";
    public static final String LIST_PRODUCTS_NAME = "XPATH=//div[@class='product-item']//h2[@class='product-title']/a";
}
