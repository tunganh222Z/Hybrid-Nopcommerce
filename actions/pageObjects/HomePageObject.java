package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BaseActions {
    WebDriver driver;
    public HomePageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
