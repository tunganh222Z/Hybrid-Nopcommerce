package pageUIs;

public class BaseActionsPageUI {
    public static final String REGISTER_LINK = "xpath=//div[@class='header-links']//a[text()='Register']";
    public static final String NOPCOMMERCE_LOGO = "xpath=//div[@class='header-logo']/a";
    public static final String LOGOUT_LINK = "xpath=//div[@class='header-links']//a[text()='Log out']";
    public static final String LOGIN_LINK = "css=a.ico-login";
    public static final String MY_ACCOUNT_LINK = "css=a.ico-account";
    public static final String NOTIFY_BAR = "css=div#bar-notification>div>p";
    public static final String NOTIFY_BAR_CLOSE_BUTTON = "css=div#bar-notification>div>span";
    public static final String DYNAMIC_MODULE_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']/li/a[contains(text(),'%s')]";
    public static final String SEARCH_TEXTBOX = "css=div.search-box>form>input";
    public static final String SEARCH_BUTTON = "css=div.search-box>form>button";
    public static final String AJAX_LOADING_ICON = "xpath=//div[@class='ajax-loading-block-window']";
    public static final String COMPARE_PRODUCTS_LIST_LINK = "xpath=//div[@class='footer-block customer-service']//li/a[text()='Compare products list']";
    public static final String WISHLIST_LINK = "xpath=//div[@class='header-links']//li/a/span[text()='Wishlist']";
    public static final String SHOPPING_CART_LINK = "css=a.ico-cart";
    public static final String PRODUCT_INFORMATION_CART = "xpath=//div[@class='mini-shopping-cart']//div[@class='attributes']";
    public static final String PRODUCT_NAME_CART_POPOVER = "xpath=//div[@class='mini-shopping-cart']//div[@class='name']/a";
    public static final String PRODUCT_QUANTITY_CART_POPOVER = "xpath=//div[@class='mini-shopping-cart']//div[@class='count']";
    public static final String PRODUCT_PRICE_CART_POPOVER = "xpath=//div[@class='mini-shopping-cart']//div[@class='price']/span";
    public static final String PRODUCT_SUB_TOTAL_CART_POPOVER = "xpath=//div[@class='mini-shopping-cart']//div[@class='totals']/strong";
}
