package tests;

import utils.WebDriverFactory;
import utils.BrowserStackFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser", "runOnBrowserStack"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, @Optional("false") String runOnBrowserStack) throws Exception {
        boolean useBrowserStack = Boolean.parseBoolean(runOnBrowserStack);

        if (useBrowserStack) {
            driver = BrowserStackFactory.getBrowserStackDriver(browser);
        } else {
            driver = WebDriverFactory.getDriver(browser);
        }

        // Navigate to the login page of the application
        driver.get("http://localhost:3000/login"); // Update this URL as per your app
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
