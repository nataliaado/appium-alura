package com.alura.appium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private MobileElement botaoCadastro;
    private final By botaoCadastroId;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        botaoCadastroId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void buscarElementos() {
        botaoCadastro = (MobileElement) driver.findElement(botaoCadastroId);
    }

    public CadastroPage irParaTelaDeCadastro() {
        botaoCadastro.click();
        return new CadastroPage(this.driver);
    }
}
