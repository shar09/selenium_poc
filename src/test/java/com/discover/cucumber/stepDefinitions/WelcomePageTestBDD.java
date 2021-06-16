package com.discover.cucumber.stepDefinitions;

import com.discover.selenium.pfactory.pages.LoginPageFactory;
import com.discover.selenium.pfactory.pages.WelcomePageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WelcomePageTestBDD {
    WebDriver driver;
    WelcomePageFactory welcome;

    @Before
    public void setup() {
        // Initialize Web Driver
        driver = utilities.DriverFactory.init("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("user is on the welcome page")
    public void user_is_on_the_welcome_page() {
        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");

        // Login
        LoginPageFactory login = new LoginPageFactory(driver);
        login.acc_login("John Doe", "12345");
    }

    @When("^user fills out form with correct data (.*), (.*), (.*), (.*)$")
    public void user_fills_out_form_with_correct_data(String country, String address, String email, String phone) {
        welcome = new WelcomePageFactory(driver);
        welcome.formFill(country, address, email, phone);
    }

    @And("user clicks on save")
    public void user_clicks_on_save() {
        welcome.save();
    }

    @Then("form is saved")
    public void form_is_saved() {
        boolean confirmSave = welcome.confirmSave();
        assertTrue(confirmSave);
    }

    @When("^user fills out form with incorrect data (.*), (.*), (.*), (.*)$")
    public void user_fills_out_form_with_incorrect_data(String country, String address, String email, String phone) {
        welcome = new WelcomePageFactory(driver);
        welcome.formFill(country, address, email, phone);
    }

    @Then("form is not saved")
    public void form_is_not_saved() {
        boolean confirmSave = welcome.confirmSave();
        assertFalse(confirmSave);
    }

    @After
    public void end() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
