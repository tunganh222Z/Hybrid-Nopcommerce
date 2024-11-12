package pageUIs.myAccount;

public class OrderPageUI {
    public static final String ORDER_NUMBER = "xpath=//span[@class='order-total' and text()='%s']/parent::li/parent::ul/preceding-sibling::div[@class='title']/strong";
    public static final String ORDER_STATUS = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul[@class='info']//span[@class='order-status pending']";
    public static final String ORDER_DETAIL = "xpath=//strong[text()='%s']/parent::div/following-sibling::div/button";
}
