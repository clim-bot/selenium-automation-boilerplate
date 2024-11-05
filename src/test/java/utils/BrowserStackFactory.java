package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackFactory {

    public static WebDriver getBrowserStackDriver(String browser) {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        if (username == null || accessKey == null) {
            throw new IllegalArgumentException("BrowserStack credentials are not set. " +
                    "Please set BROWSERSTACK_USERNAME and BROWSERSTACK_ACCESS_KEY environment variables.");
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", "latest");

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "10");
        bstackOptions.put("sessionName", "Selenium Test on " + browser);
        bstackOptions.put("seleniumVersion", "4.1.2");
        caps.setCapability("bstack:options", bstackOptions);

        try {
            return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
