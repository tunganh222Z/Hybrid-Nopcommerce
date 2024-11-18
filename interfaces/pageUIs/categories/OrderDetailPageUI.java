package pageUIs.categories;

public class OrderDetailPageUI {

    public static final String CONFIRM_BILLING_FIRSTNAME_LASTNAME = "xpath=//div[@class='billing-info']//li[@class='name']";
    public static final String CONFIRM_BILLING_EMAIL = "xpath=//div[@class='billing-info']//li[@class='email']";
    public static final String CONFIRM_BILLING_PHONE_NUMBER = "xpath=//div[@class='billing-info']//li[@class='phone']";
    public static final String CONFIRM_BILLING_COUNTRY = "xpath=//div[@class='billing-info']//li[@class='country']";
    public static final String CONFIRM_BILLING_PROVINCE_STATE = "xpath=//div[@class='billing-info']//li[@class='stateprovince']";
    public static final String CONFIRM_BILLING_CITY = "xpath=//div[@class='billing-info']//li[@class='city']";
    public static final String CONFIRM_BILLING_ADDRESS1 = "xpath=//div[@class='billing-info']//li[@class='address1']";
    public static final String CONFIRM_BILLING_ZIP_POSTAL_CODE = "xpath=//div[@class='billing-info']//li[@class='zippostalcode']";
    public static final String CONFIRM_BILLING_PAYMENT_METHOD = "xpath=//div[@class='billing-info-wrap']//div[@class='payment-method-info']//li[@class='payment-method']/span[@class='value']";
    public static final String CONFIRM_SHIPPING_FIRSTNAME_LASTNAME = "xpath=//div[@class='shipping-info-wrap']//li[@class='name']";
    public static final String CONFIRM_SHIPPING_EMAIL = "xpath=//div[@class='shipping-info-wrap']//li[@class='email']";
    public static final String CONFIRM_SHIPPING_PHONE = "xpath=//div[@class='shipping-info-wrap']//li[@class='phone']";
    public static final String CONFIRM_SHIPPING_COUNTRY = "xpath=//div[@class='shipping-info-wrap']//li[@class='country']";
    public static final String CONFIRM_SHIPPING_PROVINCE_STATE = "xpath=//div[@class='shipping-info-wrap']//li[@class='stateprovince']";
    public static final String CONFIRM_SHIPPING_CITY = "xpath=//div[@class='shipping-info-wrap']//li[@class='city']";
    public static final String CONFIRM_SHIPPING_ADDRESS1 = "xpath=//div[@class='shipping-info-wrap']//li[@class='address1']";
    public static final String CONFIRM_SHIPPING_ZIP_POSTAL_CODE = "xpath=//div[@class='shipping-info-wrap']//li[@class='zippostalcode']";
    public static final String CONFIRM_SHIPPING_METHOD = "xpath=//div[@class='shipping-info-wrap']//li[@class='shipping-method']/span[@class='value']";
    public static final String PRODUCT_SKU_BY_PRODUCT_NAME = "xpath=//a[text()='%s']//ancestor::td[@class='product']//preceding-sibling::td[@class='sku']/span[@class='sku-number']";
    public static final String PRODUCT_NAME_IN_CART_TABLE = "xpath=//td[@class='product']//a";
    public static final String PRODUCT_PRICE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']//ancestor::td[@class='product']//following-sibling::td[@class='unit-price']/span[@class='product-unit-price']";
    public static final String PRODUCT_TOTAL_PRICE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']//ancestor::td[@class='product']//following-sibling::td[@class='total']/span[@class='product-subtotal']";
    public static final String SUB_TOTAL_PRICE_IN_TOTAL_INFO = "xpath=//div[@class='total-info']//td/label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
    public static final String TOTAL_PRICE_IN_TOTAL_INFO = "xpath=//div[@class='total-info']//td/label[text()='Order Total:']/parent::td/following-sibling::td/span";
    public static final String ORDER_TOTAL_OVERVIEW = "xpath=//ul[@class='order-overview-content']//li[@class='order-total']/strong";
}
