package com.alura.appium;

import com.alura.appium.pages.CadastroPage;
import com.alura.appium.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class FeatureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPage telaLogin = new LoginPage(driver);
        telaLogin.buscarElementos();
        CadastroPage telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("natalia", "123", "456");
        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemErro());
        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPage telaLogin = new LoginPage(driver);
        telaLogin.buscarElementos();
        CadastroPage telaCadastro = telaLogin.irParaTelaDeCadastro();
        telaCadastro.buscarElementos();
        telaLogin = telaCadastro.cadastrar("natalia", "123", "123");
        telaLogin.buscarElementos();

    }


}
