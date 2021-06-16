package com.discover.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String confirmLogin() {
        return driver.findElement(By.id("greetings")).getText();
    }

    public void formFill() {
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByVisibleText("United States");

        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("North Street");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("testemail@example.com");

        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys("0123456789");
    }

    public void save() {
        WebElement saveButton = driver.findElement(By.id("save"));
        saveButton.click();
    }

    public boolean confirmSave() {
        WebElement savedMessage = driver.findElement(By.className("tp-saved"));
        return savedMessage.isDisplayed();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
    }
}
