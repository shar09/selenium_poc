package com.discover.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LoginEnhanced {
    public static void main(String[] args) throws Exception {

        String name = "John Doe";
        String password = "12345";
        String country = "United States";
        String address = "North Street";
        String email = "testemail@example.com";
        String phone = "0123456789";
        String browserType = "chrome";

        WebDriver driver = null;

        // Initialize Web Driver
        driver = utilities.DriverFactory.init(browserType);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waits for page load

        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");

        // Login
        WebElement usernameField = driver.findElement(By.id("name"));
        usernameField.sendKeys(name);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        // Confirm Login
        String confirmLogin = driver.findElement(By.id("greetings")).getText();
        System.out.println(confirmLogin);
        boolean logoutDisplayed = driver.findElement(By.id("logout")).isDisplayed();
        if(!logoutDisplayed)
            throw new Exception("User not logged in!");

        // Fill out form
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByVisibleText(country);

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys(address);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys(phone);

        // Save Form
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();

        // Confirm Save
        WebElement savedMessage = driver.findElement(By.className("tp-saved"));
        boolean saved = savedMessage.isDisplayed();
        if(!saved)
            throw new Exception("Form not saved!");

        // Logout
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();

        // Close browser tabs and window
        driver.close();

        // driver.quit() causing 'execution failed for task' using firefox
        if(browserType.equals("chrome"))
            driver.quit();
    }
}
