package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void testDashboardAccess() {
        // Ensure dashboard is accessible
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dashboard"), "Dashboard access failed!");
    }
}
