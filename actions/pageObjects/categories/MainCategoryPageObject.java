package pageObjects.categories;

import commons.BaseActions;
import commons.PageGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.categories.MainCategoryPageUI;

public class MainCategoryPageObject extends BaseActions {
    WebDriver driver;
    public MainCategoryPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Step("Open Sub Category is {0}")
    public SubCategoryPageObject openSubCategoryByTitle(String title) {
        waitForElementClickable(driver, MainCategoryPageUI.SUB_CATEGORY_BY_TITLE,title);
        clickToElement(driver, MainCategoryPageUI.SUB_CATEGORY_BY_TITLE,title);
        return PageGenerator.getSubCategoryPage(driver);
    }
}
