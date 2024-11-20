package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;
import pageObjects.admin.DashboardPageObject;
import pageObjects.myAccount.*;
import pageObjects.orderCheckout.CheckoutPageObject;
import pageObjects.categories.*;
import pageObjects.orderCheckout.OrderDetailPageObject;

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

    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }

    public static WishlistPageObject getWishlistPage(WebDriver driver){
        return new WishlistPageObject(driver);
    }

    public static CompareProductsListPageObject getCompareProductsList(WebDriver driver){
        return new CompareProductsListPageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new ShoppingCartPageObject(driver);
    }

    public static CheckoutPageObject getCheckoutPage(WebDriver driver){
        return new CheckoutPageObject(driver);
    }

    public static OrderDetailPageObject getOrderDetailPage(WebDriver driver) {
        return new OrderDetailPageObject(driver);
    }

    public static OrderPageObject getOrderPage(WebDriver driver) {
        return new OrderPageObject(driver);
    }

    //

    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }
}
