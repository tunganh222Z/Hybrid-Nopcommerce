package user;

import commons.BaseTest;
import commons.PageGenerator;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import ultilities.FakerConfig;

public class Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String firstName, lastName, password, email, confirmPassword;
    private FakerConfig fakerConfig;

    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        firstName = fakerConfig.getFirstName();
        lastName = fakerConfig.getLastName();
        email = fakerConfig.getEmail();
        password = fakerConfig.getPassword();
        confirmPassword = fakerConfig.getPassword();

        driver = getBrowserDriver(browserName, url);

        homePage = PageGenerator.getHomePage(driver);
        homePage.clickToRegisterLink();
    }

    @Test
    public void Register_01_Register_With_Empty_Data(){
        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        registerPage.clickToRegisterButton();
    }

    @Test
    public void Register_02_Register_With_Invalid_Email(){
        registerPage.enterToFirstNameTextbox("");

        registerPage.enterToLastNameTextbox("");

        registerPage.enterToEmailTextbox("");
        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        registerPage.enterToPasswordTextbox("");

        registerPage.enterToConfirmPasswordTextbox("");

        registerPage.clickToRegisterButton();

    }

    @Test
    public void Register_03_Register_With_Valid_Data(){
        registerPage.enterToFirstNameTextbox("");

        registerPage.enterToLastNameTextbox("");

        registerPage.enterToEmailTextbox("");

        registerPage.enterToPasswordTextbox("");

        registerPage.enterToConfirmPasswordTextbox("");

        registerPage.clickToRegisterButton();
    }

    @Test
    public void Register_04_Register_With_Existing_Email(){
        registerPage.enterToFirstNameTextbox("");

        registerPage.enterToLastNameTextbox("");

        registerPage.enterToEmailTextbox("");
        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        registerPage.enterToPasswordTextbox("");

        registerPage.enterToConfirmPasswordTextbox("");

        registerPage.clickToRegisterButton();
    }

    @Test
    public void Register_05_Register_With_Password_Less_Than_6_Chars(){
        registerPage.enterToFirstNameTextbox("");

        registerPage.enterToLastNameTextbox("");

        registerPage.enterToEmailTextbox("");

        registerPage.enterToPasswordTextbox("");
        Assert.assertEquals(registerPage.getPasswordErrorMsg(), "");

        registerPage.enterToConfirmPasswordTextbox("");

        registerPage.clickToRegisterButton();
    }

    @Test
    public void Register_06_Register_With_Confirm_Password_Not_Match(){
        registerPage.enterToFirstNameTextbox("");

        registerPage.enterToLastNameTextbox("");

        registerPage.enterToEmailTextbox("");

        registerPage.enterToPasswordTextbox("");

        registerPage.enterToConfirmPasswordTextbox("");
        Assert.assertEquals(registerPage.getErrorMsgByTextboxLabel(""), "");

        registerPage.clickToRegisterButton();
    }


    @AfterClass
    public void afterClass(){
        closeBrowser();
    }
}
