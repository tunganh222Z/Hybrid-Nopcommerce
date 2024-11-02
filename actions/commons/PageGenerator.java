package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObjects;
import pageObjects.myAccount.AddressesPageObject;
import pageObjects.myAccount.CustomerInfoPageObject;
import pageObjects.RegisterPageObject;

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
}
