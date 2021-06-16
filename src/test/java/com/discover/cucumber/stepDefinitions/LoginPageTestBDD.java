package com.discover.cucumber.stepDefinitions;

import com.discover.selenium.pfactory.pages.LoginPageFactory;
import com.discover.selenium.pfactory.pages.WelcomePageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTestBDD {

    WebDriver driver;

    @Before
    public void setup() {
        // Initialize Web Driver
        driver = utilities.DriverFactory.init("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("user enters correct username and correct password")
    public void user_enters_correct_username_and_correct_password() {
        // Login
        LoginPageFactory login = new LoginPageFactory(driver);
        login.acc_login("John Doe", "12345");
    }

    @Then("user should be redirected to welcome page")
    public void user_should_be_redirected_to_welcome_page() {
        WelcomePageFactory welcome = new WelcomePageFactory(driver);
        String confirm = welcome.confirmLogin();
        assertEquals("Hello John Doe, let's complete the test form:", confirm);
    }

    @When("^user enters correct (.*) and wrong (.*)$")
    public void user_enters_correct_username_and_wrong_password(String username, String password) {
        // Login
        LoginPageFactory login = new LoginPageFactory(driver);
        login.acc_login(username, password);
    }

    @Then("user should receive password invalid error message")
    public void user_should_receive_password_invalid_error_message() {
        driver.findElement(By.className("invalid-feedback")).isDisplayed();
    }

    @After
    public void end() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
