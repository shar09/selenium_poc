package com.discover.selenium.pfactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver driver;

    @FindBy(id = "name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;

        // Initialize web elements
        PageFactory.initElements(driver, this);
    }

    // Steps
    public void enterName(String name) {
        usernameField.sendKeys(name);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submit() {
        loginButton.click();
    }

    // Action
    public void acc_login(String name, String password) {
        enterName(name);
        enterPassword(password);
        submit();
    }
}
