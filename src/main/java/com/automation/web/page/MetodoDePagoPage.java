package com.automation.web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.support.FindBy;

import java.time.temporal.ChronoUnit;

public class MetodoDePagoPage extends PageObject {

    @FindBy(xpath = "//div[@class='title-pasajero']")
    private WebElementFacade tituloPago;

    @FindBy(id = "chk_tercon")
    private WebElementFacade rbTerminos;

    @FindBy(id = "ingresar_tarjeta")
    private WebElementFacade btnIngresarTarjeta;

    @FindBy(name = "CREDITCARDNUMBER")
    private WebElementFacade txtNroTarjeta;

    @FindBy(name = "EXPIRYDATE_MM")
    private WebElementFacade cbMesExp;
    @FindBy(name = "EXPIRYDATE_YY")
    private WebElementFacade cbAnioExp;

    @FindBy(name = "CVV")
    private WebElementFacade txtCvv;
    @FindBy(name = "NAME")
    private WebElementFacade txtNombre;

    public String obtenerTitulo(){
      //  withTimeoutOf(7,ChronoUnit.SECONDS)//para espegrar renderizado de la pagina
       waitForTextToAppear(tituloPago.getText());  //Esperar hasta que aparesca el texto del componente
       return tituloPago.getText();
    }
    public void clickMetodoPago(String metodo_pago){
        element("//input[@id='"+metodo_pago+"']").waitUntilClickable().click();
    }
    public void aceptarTerminosCondiciones(){
        rbTerminos.click();
        Serenity.takeScreenshot();
    }

    public void clickIngresarTarjeta(String nroTarjeta, String mesExpiracion
            , String AnioExpiracion, String codigoSeguridad, String nombre){
        btnIngresarTarjeta.waitUntilClickable().click();
        waitForRenderedElementsToBePresent(By.xpath("//div[@class='datos-tarjeta']"));  //evento para esperar que termine el refresh de una pagina
        getDriver().switchTo().frame("global");  // el switch se utiliza para ingresarme en el sub formulario y poder ingresar datos de tarjeta
        txtNroTarjeta.type(nroTarjeta);
        cbMesExp.selectByVisibleText(mesExpiracion);
        cbAnioExp.selectByVisibleText(AnioExpiracion);
        txtCvv.type(codigoSeguridad);
        txtNombre.type(nombre);
        Serenity.takeScreenshot();
    }






}
