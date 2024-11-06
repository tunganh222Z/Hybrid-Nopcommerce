package pageUIs;

public class ShoppingCartPageUI {
    public static final String DYNAMIC_PRODUCT_INDEX_BY_COLUMN = "xpath=//table[@class='cart']//th[text()='%s']/preceding-sibling::th";
        public static final String DYNAMIC_PRODUCT_NAME_BY_INDEX = "xpath=//table[@class='cart']//td[%s]/a";
}
