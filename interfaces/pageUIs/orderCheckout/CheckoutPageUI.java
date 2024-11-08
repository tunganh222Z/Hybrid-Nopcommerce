package pageUIs.orderCheckout;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class CheckoutPageUI extends BaseActions {
    WebDriver driver;

    public CheckoutPageUI(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
