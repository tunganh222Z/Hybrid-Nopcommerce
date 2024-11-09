package pageUIs;

public class ShoppingCartPageUI {
    public static final String DYNAMIC_PRODUCT_INDEX_BY_COLUMN = "xpath=//table[@class='cart']//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_PRODUCT_NAME_BY_INDEX = "xpath=//table[@class='cart']//td[%s]/a";
    public static final String EDIT_BUTTON = "xpath=//table[@class='cart']//a[@class='product-name' and text()='%s']/parent::td//div[@class='edit-item']/a";
    public static final String REMOVE_BUTTON = "xpath=//table[@class='cart']//a[@class='product-name' and text()='%s']/parent::td/following-sibling::td//button[@class='remove-btn']";
    public static final String EMPTY_SHOPPING_CART_MSG = "xpath=//div[@class='no-data']";
    public static final String PRODUCT_NAME = "xpath=//table[@class='cart']//a[@class='product-name' and text()='%s']";
    public static final String TOTAL_PRICE_IN_TOTAL_INFO = "xpath=//table[@class='cart-total']//span[@class='value-summary']/strong";
    public static final String GIFT_WRAPPING_DROPDOWN = "xpath=//select[@id='checkout_attribute_1']";
    public static final String ESTIMATE_SHIPPING_BUTTON = "xpath=//div[@class='common-buttons']/a";
    public static final String COUNTRY_DROPDOWN = "xpath=//select[@id='CountryId']";
    public static final String STATE_DROPDOWN = "xpath=//select[@id='StateProvinceId']";
    public static final String ZIP_POSTAL_CODE_TEXTBOX = "xpath=//input[@id='ZipPostalCode']";
    public static final String DYNAMIC_SHIPPING_METHOD_RADIO_BUTTON = "xpath=//div[@class='shipping-options-body']/div/div[%s][text()='%s']";
    public static final String DYNAMIC_SHIPPINGMETHOD_COLUMN_BY_LABEL = "xpath=//div[@class='estimate-shipping-row']/div[text()='%s']/preceding-sibling::div";
    public static final String APPLY_BUTTON = "xpath=//div[@class='apply-shipping-button-container']";
    public static final String SHIPPING_POPUP = "xpath=//div[@id='estimate-shipping-popup']";
    public static final String AGREE_CHECKBOX = "//div[@class='terms-of-service']/input";
    public static final String CHECKOUT_BUTTON = "xpath=//div[@class='checkout-buttons']/button";
}
