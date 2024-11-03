package pageUIs.categories;

import commons.BaseActions;
import pageObjects.categories.MainCategoryPageObject;

public class SubCategoryPageUI  {
    public static final String DYNAMIC_PRODUCT_BY_NAME = "xpath=//h2[@class='product-title']/a[contains(text(),'%s')]";
    public static final String SORT_BY_DROPDOWN = "xpath=//div[@class='product-sorting']/select[@id='products-orderby']";
    public static final String PRODUCTS_NAME = "xpath=//div[@class='product-item']//h2[@class='product-title']/a";
    public static final String PRODUCTS_PRICE = "xpath=//div[@class='product-item']//div[@class='prices']/span";
    public static final String DISPLAY_PER_PAGE_DROPDOWN = "xpath=//div[@class='product-page-size']/select[@id='products-pagesize']";
    public static final String NEXT_PAGE_ICON = "XPATH=//div[@class='pager']//li[@class='next-page']/a";
    public static final String PREVIOUS_PAGE_ICON = "XPATH=//div[@class='pager']//li[@class='previous-page']/a";
    public static final String UNSELECTED_PAGES = "xpath=//div[@class='pager']//li[@class='individual-page']/a";
    public static final String SELECTED_PAGE = "xpath=//div[@class='pager']//li[@class='current-page']/span";
    public static final String PAGINATION_CONTROL = "css=div.pager";
}
