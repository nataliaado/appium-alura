package com.alura.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage extends BasePage {

    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;
    private final By erroId;
    private final By campoNomeId;
    private final By campoSenhaId;
    private final By botaoCadastrarId;
    private final By campoConfirmarSenhaId;

    protected CadastroPage(AppiumDriver driver) {
        super(driver);
        erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        campoNomeId = By.id("br.com.alura.aluraesporte:id/input_nome");
        campoSenhaId = By.id("br.com.alura.aluraesporte:id/input_senha");
        botaoCadastrarId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
        campoConfirmarSenhaId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
    }

    @Override
    public void buscarElementos() {
        campoNome = (MobileElement) driver.findElement(campoNomeId);
        campoSenha = (MobileElement) driver.findElement(campoSenhaId);
        campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaId);
        botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarId);
    }

    private void preencherFormulario(String usuario, String senha, String confirmacao) {
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public LoginPage cadastrar(String usuario, String senha, String confirmacao) {
        preencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPage(driver);
    }

    public String mensagemErro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroId));

        mensagemErro = (MobileElement) driver.findElement(erroId);
        return mensagemErro.getText();
    }
}
