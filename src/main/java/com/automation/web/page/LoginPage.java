package com.automation.web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade txtUserName;
    @FindBy(id = "password")
    private WebElementFacade txtPassword;
    @FindBy(id = "login-button")
    private WebElementFacade btnIngresar;

    public void ingresarCredenciales(String user,String password){
        txtUserName.type(user);
        txtPassword.type(password);
        Serenity.takeScreenshot();
    }
    public void clickLogin(){
        btnIngresar.click();
    }




}
