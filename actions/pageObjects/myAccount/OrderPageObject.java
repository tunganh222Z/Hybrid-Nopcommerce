package pageObjects.myAccount;

import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.orderCheckout.OrderDetailPageObject;
import pageUIs.myAccount.OrderPageUI;

public class OrderPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    public OrderPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get order number in Order page")
    public String getOrderNumberByOrderTotal(String orderTotal) {
        waitForElementVisible(driver, OrderPageUI.ORDER_NUMBER,orderTotal);
        return getWebElementText(driver, OrderPageUI.ORDER_NUMBER,orderTotal);
    }

    @Step("Get order status in order page")
    public String getOrderStatusByOrderNumber(String orderNumber) {
        waitForElementVisible(driver, OrderPageUI.ORDER_STATUS,orderNumber);
        return getWebElementText(driver, OrderPageUI.ORDER_STATUS,orderNumber);
    }

    @Step("Click to order detail")
    public OrderDetailPageObject clickToDetailsButtonByOrderNumber(String orderNumber) {
        waitForElementClickable(driver, OrderPageUI.ORDER_DETAIL, orderNumber);
        clickToElement(driver, OrderPageUI.ORDER_DETAIL, orderNumber);
        return PageGenerator.getOrderDetailPage(driver);
    }
}
