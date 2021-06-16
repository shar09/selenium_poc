package com.discover.selenium.pom.tests;

import com.discover.selenium.pom.pages.LoginPage;
import com.discover.selenium.pom.pages.WelcomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    public void loginPOM() {
        // Initialize Web Driver
        WebDriver driver = utilities.DriverFactory.init("chrome");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");

        // Enter Login Info
        LoginPage login = new LoginPage(driver);
        login.enterName("John Doe");
        login.enterPassword("12345");
        login.submit();

        // Confirm Login
        WelcomePage welcome = new WelcomePage(driver);
        String confirmLogin = welcome.confirmLogin();
        assertEquals("Hello John Doe, let's complete the test form:", confirmLogin);

        // Fill out form
        welcome.formFill();

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
