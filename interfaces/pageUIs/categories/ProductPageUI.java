package pageUIs.categories;

public class ProductPageUI  {
    public static final String REVIEW_TITLE_TEXTBOX = "css=input#AddProductReview_Title";
    public static final String REVIEW_TEXT_TEXTAREA = "css=textarea#AddProductReview_ReviewText";
    public static final String PRODUCT_RATING_BY_NUMBER_RATING = "xpath=//div[@class='rating-options']/input[@value='%s']";
    public static final String SUBMIT_REVIEW_BUTTON = "css=button#add-review";
    public static final String ADD_TO_WISHLIST_BUTTON = "xpath=//div[@class='add-to-wishlist']/button";
    public static final String PROCESSOR_DROPDOWN = "xpath=//select[@id='product_attribute_5']";
    public static final String RAM_DROPDOWN = "xpath=//select[@id='product_attribute_6']";
    public static final String HDD_RADIO_BUTTON_BY_LABEL = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String OS_RADIO_BUTTON_BY_LABEL = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String DYNAMIC_SOFTWARE_CHECKBOX = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
    public static final String QUANTITY_TEXTBOX = "xpath=//input[@class='qty-input']";
    public static final String UPDATE_BUTTON = "xpath=//button[text()='Update']";
    public static final String SOFTWARE_CHECKBOX = "xpath=//label[contains(text(),'Software')]/parent::dt/following-sibling::dd[1]//input";
    public static final String PRODUCT_PRICE = "xpath=//div[@class='overview']//div[@class='product-price']/span";
}
