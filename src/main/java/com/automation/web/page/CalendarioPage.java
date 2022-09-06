package com.automation.web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class CalendarioPage extends PageObject {

     @FindBy(id = "salida")
    private WebElementFacade btnFechaSalida;

     @FindBy(className = "ui-datepicker-title")
    private WebElementFacade mesAnio;

    @FindBy(linkText = "Next")
    private WebElementFacade btnNext;


     public void seleccionarSalida(String mesAnioSalida,String diaSalida){
         btnFechaSalida.click();
         while (!mesAnio.getText().equalsIgnoreCase(mesAnioSalida)){
                btnNext.click();}
        getDriver().findElement(By.xpath("//a[text()='"+diaSalida+"']")).click();
         Serenity.takeScreenshot();
     }

}
