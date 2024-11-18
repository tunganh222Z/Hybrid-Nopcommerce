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
        String toTitleCase = toTitleCase(orderNumber);
        waitForElementVisible(driver, OrderPageUI.ORDER_STATUS,toTitleCase);
        return getWebElementText(driver, OrderPageUI.ORDER_STATUS,toTitleCase);
    }

    @Step("Click to order detail")
    public OrderDetailPageObject clickToDetailsButtonByOrderNumber(String orderNumber) {
        String titleCase = toTitleCase(orderNumber);
        waitForElementClickable(driver, OrderPageUI.ORDER_DETAIL, titleCase);
        clickToElement(driver, OrderPageUI.ORDER_DETAIL, titleCase);
        return PageGenerator.getOrderDetailPage(driver);
    }

    public String toTitleCase(String strings){
        String[] string = strings.split("\\s+");

        StringBuilder titleCase = new StringBuilder();

        for (String word : string){
            titleCase.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return titleCase.toString().trim();
    }
}
