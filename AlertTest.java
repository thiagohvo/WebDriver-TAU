package com.selenium.demo;

import com.selenium.demo.utils.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    
    @Test
    public void testSimpleAlert() {
        // Clica no botão que gera um alerta simples
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        
        // Espera o alerta aparecer e o aceita
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        
        // Verifica se a mensagem de resultado está correta
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert", "A mensagem de resultado não é a esperada");
    }
    
    @Test
    public void testConfirmAlert() {
        // Clica no botão que gera um alerta de confirmação
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        
        // Espera o alerta aparecer e o cancela
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        
        // Verifica se a mensagem de resultado está correta
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel", "A mensagem de resultado não é a esperada");
    }
    
    @Test
    public void testPromptAlert() {
        // Clica no botão que gera um alerta de prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        
        // Espera o alerta aparecer, insere um texto e o aceita
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = "Teste de automação com Selenium";
        alert.sendKeys(text);
        alert.accept();
        
        // Verifica se a mensagem de resultado está correta
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: " + text, "A mensagem de resultado não é a esperada");
    }
    
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
