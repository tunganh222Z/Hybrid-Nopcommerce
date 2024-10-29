package commons;

import org.openqa.selenium.WebDriver;

public class BaseActions extends BasePage{
    WebDriver driver;
    public BaseActions (WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, BaseActionsPageUI.REGISTER_LINK);
        clickToElement(driver, BaseActionsPageUI.REGISTER_LINK);
    }
}
