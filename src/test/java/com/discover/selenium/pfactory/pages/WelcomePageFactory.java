package com.discover.selenium.pfactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePageFactory {
    WebDriver driver;

    @FindBy(id = "greetings")
    WebElement greetingText;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "phone")
    WebElement phoneField;

    @FindBy(id = "save")
    WebElement saveButton;

    @FindBy(className = "tp-saved")
    WebElement savedMessage;

    @FindBy(id = "logout")
    WebElement logoutButton;

    public WelcomePageFactory(WebDriver driver) {
        this.driver = driver;

        // Initialize web elements
        PageFactory.initElements(driver, this);
    }

    public String confirmLogin() {
        return greetingText.getText();
    }

    public void formFill(String country, String address, String email, String phone) {
        Select countryDropdown = new Select(driver.findElement(By.id("country")));
        countryDropdown.selectByVisibleText(country);
        addressField.sendKeys(address);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
    }

    public void save() {
        saveButton.click();
    }

    public boolean confirmSave() {
        return savedMessage.isDisplayed();
    }

    public void logout() {
        logoutButton.click();
    }
}
