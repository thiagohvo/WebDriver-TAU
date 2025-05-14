package com.selenium.demo;

import com.selenium.demo.pages.LoginPage;
import com.selenium.demo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    
    private WebDriver driver;
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        loginPage = new LoginPage(driver);
        loginPage.navigateTo("https://the-internet.herokuapp.com/login");
    }
    
    @Test
    public void testSuccessfulLogin() {
        // Credenciais corretas
        loginPage.login("tomsmith", "SuperSecretPassword!");
        
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login não foi realizado com sucesso");
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area"), 
                          "Mensagem de sucesso não foi exibida corretamente");
    }
    
    @Test
    public void testFailedLoginWithInvalidUsername() {
        // Username inválido
        loginPage.login("incorrectUser", "SuperSecretPassword!");
        
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login foi realizado com username inválido");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid"), 
                          "Mensagem de erro para username inválido não foi exibida");
    }
    
    @Test
    public void testFailedLoginWithInvalidPassword() {
        // Senha inválida
        loginPage.login("tomsmith", "incorrectPassword");
        
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login foi realizado com senha inválida");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your password is invalid"), 
                          "Mensagem de erro para senha inválida não foi exibida");
    }
    
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
