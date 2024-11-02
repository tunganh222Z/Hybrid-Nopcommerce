package pageObjects.myAccount;

import commons.BaseActions;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseActions {
    WebDriver driver;
    public MyAccountSideBarPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public AddressesPageObject openAddressesPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
        return PageGenerator.getAddressesPage(driver);
    }
}
