package com.discover.selenium.pfactory.tests;

import com.discover.selenium.pfactory.pages.LoginPageFactory;
import com.discover.selenium.pfactory.pages.WelcomePageFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestFactory {

    @Test
    public void loginPageFactory() {
        // Initialize Web Driver
        WebDriver driver = utilities.DriverFactory.init("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");

        // Login
        LoginPageFactory login = new LoginPageFactory(driver);
        login.acc_login("John Doe", "12345");

        // Confirm Login
        WelcomePageFactory welcome = new WelcomePageFactory(driver);
        String confirmLogin = welcome.confirmLogin();
        assertEquals("Hello John Doe, let's complete the test form:", confirmLogin);

        // Fill out form
        welcome.formFill("United States", "North Street", "testemail@example.com", "0123456789");

        // Save
        welcome.save();

        // Confirm Save
        boolean confirmSave = welcome.confirmSave();
        assertTrue(confirmSave);

        // Logout
        welcome.logout();

        // Close Driver
        driver.close();
        driver.quit();
    }
}
