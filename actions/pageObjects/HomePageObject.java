package pageObjects;

import commons.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BaseActions {
    WebDriver driver;
    public HomePageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Get Home Page title")
    public String getHomePageTitle() {
        sleepInSecond(2);
        return getPageTitle(driver);
    }
}
