package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.admin.catalog.ProductsPageObject;
import pageUIs.admin.BaseActionsAdminUI;

public class BaseActionsAdmin extends BasePage{
    WebDriver driver;
    
    public BaseActionsAdmin (WebDriver driver){
        this.driver = driver;
    }

    @Step("Open sub modules in catalog module")
    public ProductsPageObject openModuleInCatalog(String subModules) {
        waitForElementClickable(driver, BaseActionsAdminUI.CATALOG_MODULE);

        clickToElement(driver, BaseActionsAdminUI.CATALOG_MODULE);

        clickToElement(driver, BaseActionsAdminUI.CATLOG_SUB_MODULES, subModules);

        return PageGenerator.getProductAdminPage(driver);
    }
}
