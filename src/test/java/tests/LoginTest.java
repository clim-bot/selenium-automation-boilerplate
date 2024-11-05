package tests;

import chris.lim.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("testpassword");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:3000/dashboard"); // Update with your dashboard URL
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invaliduser");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid username or password"));
    }
}
