package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.categories.MainCategoryPageObject;
import pageObjects.categories.ProductPageObject;
import pageObjects.categories.SubCategoryPageObject;
import pageObjects.myAccount.AddressesPageObject;
import pageObjects.myAccount.ChangePasswordPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.myAccount.MyProductReviewsPageObject;

public class PageGenerator {
    WebDriver driver;
    public PageGenerator (WebDriver driver){
        this.driver = driver;
    }

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static LoginPageObjects getLoginPage (WebDriver driver){
        return new LoginPageObjects(driver);
    }

    public static CustomerInfoPageObject getMyAccountPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }

    public static AddressesPageObject getAddressesPage(WebDriver driver){
        return new AddressesPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver){
        return new ChangePasswordPageObject(driver);
    }

    public static MainCategoryPageObject getMainCategoryPage(WebDriver driver) {
        return new MainCategoryPageObject(driver);
    }

    public static SubCategoryPageObject getSubCategoryPage(WebDriver driver) {
        return new SubCategoryPageObject(driver);
    }

    public static ProductPageObject getProductPage(WebDriver driver) {
        return new ProductPageObject(driver);
    }

    public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
        return new MyProductReviewsPageObject(driver);
    }
}
