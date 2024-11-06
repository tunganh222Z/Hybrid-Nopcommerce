package pageUIs;

public class WishlistPageUI {

    public static final String WISHLIST_PAGE_TITLE = "xpath=//div[@class='page wishlist-page']//h1";
    public static final String URL_SHARING_LINK = "xpath=//div[@class='share-info']/a";
    public static final String DYNAMIC_CHECKBOX_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']/parent::td/preceding-sibling::td[@class='add-to-cart']/input";
    public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='buttons']/button[@name='addtocartbutton']";
    public static final String DYNAMIC_PRODUCT_BY_NAME = "XPATH=//table[@class='cart']//a[@class='product-name' and text()='%s']";
    public static final String DYNAMIC_REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
    public static final String PRODUCT_NAME = "XPATH=//table[@class='cart']//a[@class='product-name']";
    public static final String EMPTY_WISHLIST_MESSAGE = "xpath=//div[@class='page wishlist-page']//div[@class='no-data']";
}
