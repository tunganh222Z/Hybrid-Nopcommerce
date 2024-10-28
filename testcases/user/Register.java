package user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Register extends BaseTest {
    private WebDriver driver;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName, url);

    }

    @Test
    public void Register_01_Register_With_Empty_Data(){

    }

    @Test
    public void Register_02_Register_With_Invalid_Email(){

    }

    @Test
    public void Register_03_Register_With_Valid_Data(){

    }

    @Test
    public void Register_04_Register_With_Existing_Email(){

    }

    @Test
    public void Register_05_Register_With_Password_Less_Than_6_Chars(){

    }

    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match(){

    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
