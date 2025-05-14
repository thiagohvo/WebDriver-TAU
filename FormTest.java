package com.selenium.demo;

import com.selenium.demo.pages.FormPage;
import com.selenium.demo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest {
    
    private WebDriver driver;
    private FormPage formPage;
    
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        formPage = new FormPage(driver);
        // Aqui vamos supor que estamos usando o site de demonstração heroku
        formPage.navigateTo("https://formy-project.herokuapp.com/form");
    }
    
    @Test
    public void testFormSubmission() {
        formPage.fillForm("João", "Silva", "joao.silva@email.com", "Male", "30");
        
        Assert.assertTrue(formPage.isFormSubmitted(), "Formulário não foi enviado com sucesso");
        Assert.assertTrue(formPage.getConfirmationMessage().contains("The form was successfully submitted!"), 
                          "Mensagem de confirmação não foi exibida corretamente");
    }
    
    @Test
    public void testFormWithEmptyFields() {
        // Não preenchemos nenhum campo e clicamos em enviar
        formPage.clickSubmitButton();
        
        Assert.assertFalse(formPage.isFormSubmitted(), "Formulário foi enviado com campos vazios");
    }
    
    @Test
    public void testFormWithInvalidEmail() {
        formPage.fillForm("Maria", "Santos", "email-invalido", "Female", "25");
        
        Assert.assertFalse(formPage.isFormSubmitted(), "Formulário foi enviado com email inválido");
    }
    
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
