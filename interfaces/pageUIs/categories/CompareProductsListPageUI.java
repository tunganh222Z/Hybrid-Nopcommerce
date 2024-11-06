package pageUIs.categories;

public class CompareProductsListPageUI {
    public static final String EMPTY_COMPARE_PRODUCTS_MESSAGE = "xpath=//div[@class='page compare-products-page']/div[@class='page-body']/div";
    public static final String CLEAR_LIST_BUTTON = "xpath=//div[@class='page compare-products-page']/div[@class='page-body']/a";
    public static final String DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME = "xpath=//tr[@class='product-name']//td/a[text()='%s']/parent::td/preceding-sibling::td";
    public static final String PRODUCT_PRICE_BY_INDEX = "xpath=//tr[@class='product-price']/td[%s]";
    public static final String DYNAMIC_PRODUCT_NAME = "XPATH=//tr[@class='product-name']//td/a[text()='%s']";
}
