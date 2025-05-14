package com.selenium.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.id("error");
    private By successMessage = By.id("success");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
    
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }
    
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return success.getText();
    }
    
    public boolean isLoginSuccessful() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.urlContains("secure"));
        } catch (Exception e) {
            return false;
        }
    }
}
