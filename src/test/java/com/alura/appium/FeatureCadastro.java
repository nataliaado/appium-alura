package com.alura.appium;

import com.alura.appium.pageObjects.CadastroPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class FeatureCadastro {

    @Test
    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);

        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("natalia", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.mensagemErro());

        driver.navigate().back();
    }

    @Test
    public void posso_cadastrar_usuarios_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.buscarElementos();
        telaCadastro.cadastrar("natalia", "123", "123");

        MobileElement botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

    }


}
