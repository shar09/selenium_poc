package com.discover.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) throws Exception{

        // Driver Path
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        // Initialize Web Driver
        System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waits for page load

        // Open Webpage
        driver.navigate().to("https://example.testproject.io/web/");

        // Login
        WebElement usernameField = driver.findElement(By.id("name"));
        usernameField.sendKeys("John Doe");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");

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
        countryDropdown.selectByVisibleText("United States");

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("North Street");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("testemail@example.com");

        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys("0123456789");

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
        driver.quit();
    }
}
