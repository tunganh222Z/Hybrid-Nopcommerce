package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class WishlistPageObject extends BaseActions {
    WebDriver driver;

    public WishlistPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
