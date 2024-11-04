package pageObjects.categories;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;

public class CompareProductsListPageObject extends BaseActions {
    WebDriver driver;
    public CompareProductsListPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
