package pageObjects.admin;

import commons.BaseActionsAdmin;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BaseActionsAdmin {
    WebDriver driver;

    public DashboardPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
