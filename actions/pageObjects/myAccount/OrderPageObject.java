package pageObjects.myAccount;

import org.openqa.selenium.WebDriver;
import pageObjects.orderCheckout.OrderDetailPageObject;

public class OrderPageObject extends MyAccountSideBarPageObject{
    WebDriver driver;
    public OrderPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Object getOrderNumber() {
    }

    public Object getOrderStatus() {
    }

    public OrderDetailPageObject clickToDeatailsButton() {
        return null;
    }
}
