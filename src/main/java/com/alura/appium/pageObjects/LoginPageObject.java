package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.internal.FindsById;

public class LoginPageObject {


    private MobileElement botaoCadastro;
    private AppiumDriver driver;

    public LoginPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");

    }

    public CadastroPageObject irParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPageObject(this.driver);
    }
}
