package pageObjects.myAccount;

import commons.BaseActions;
import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.myAccount.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BaseActions {
    WebDriver driver;
    public MyAccountSideBarPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Open Addresses Page in My Account sidebar")
    public AddressesPageObject openAddressesPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESSES_LINK);
        return PageGenerator.getAddressesPage(driver);
    }

    @Step("Open Change Password Page in My Account sidebar")
    public ChangePasswordPageObject openChangePasswordPage() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, MyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    @Step("Open My Product Reviews Page in My Account sidebar")
    public MyProductReviewsPageObject openMyProductReviews() {
        waitForElementClickable(driver, MyAccountSideBarPageUI.MY_PRODUCT_REVIEWS_LINK);
        clickToElement(driver, MyAccountSideBarPageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGenerator.getMyProductReviewsPage(driver);
    }

    public OrderPageObject openOrdersPage() {
        return null;
    }
}
