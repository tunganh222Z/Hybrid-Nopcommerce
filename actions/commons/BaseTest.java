package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
     WebDriver driver;
    protected WebDriver getBrowserDriver(String browserName, String url){
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        if (browser == BrowserList.FIREFOX){
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME){
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /* setSize để test reponsive cũng được
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(720,720));
        */
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected void closeBrowser(){
        String cmd = null;
        try {
            String osName = GlobalConstant.OS_NAME.toLowerCase();

            String driverInstanceName = driver.toString().toLowerCase();

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }
            // close browser
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // quit driver
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected String getRandom(){
        Random rand = new Random();
        int x = rand.nextInt(1,999999);
        return Integer.toString(x);
    }

}
