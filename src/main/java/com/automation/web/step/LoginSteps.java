package com.automation.web.step;

import com.automation.utils.Util;
import com.automation.web.page.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {

    LoginPage loginPage;
    Util util;

    @Given("acceder a la {string} de SwagLabs con usuarioy password")
    public void accederALaDeSwagLabsConUsuarioyPassword(String url) {
        loginPage.openUrl(url);
        loginPage.ingresarCredenciales(util.obtenerVariableSerenity("user"), util.obtenerVariableSerenity("password"));

        loginPage.clickLogin();
    }
}
