package com.selenium.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormPage {
    
    private WebDriver driver;
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By genderDropdown = By.id("gender");
    private By ageField = By.id("age");
    private By submitButton = By.id("submit");
    private By confirmationMessage = By.id("confirmation");
    
    public FormPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    
    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    
    public void selectGender(String gender) {
        Select dropdown = new Select(driver.findElement(genderDropdown));
        dropdown.selectByVisibleText(gender);
    }
    
    public void setAge(String age) {
        driver.findElement(ageField).sendKeys(age);
    }
    
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    
    public void fillForm(String firstName, String lastName, String email, String gender, String age) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        selectGender(gender);
        setAge(age);
        clickSubmitButton();
    }
    
    public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return message.getText();
    }
    
    public boolean isFormSubmitted() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.urlContains("confirmation"));
        } catch (Exception e) {
            return false;
        }
    }
}
