package commons;

import org.openqa.selenium.WebDriver;

public class ShoppingCartPageObject extends  BaseActions{
    WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
