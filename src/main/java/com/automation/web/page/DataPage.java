package com.automation.web.page;

import com.automation.utils.Util;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.Map;

public class DataPage extends PageObject {

    @FindBy(id = "btnContinuarPas")
    private WebElementFacade btnContinuarPasajeros;
    Util util;

    public void listaFormulario(DataTable dataTable){
    List<Map<String,String>> lista=dataTable.asMaps(String.class,String.class);
    for (int i=0;i<lista.size();i++){
        $("//input[@placeholder='First name']").type(lista.get(i).get("nombre"));
        $("//input[@placeholder='Last name']").type(lista.get(i).get("apellido"));

        util.getReadOnly($("//input[@placeholder='Date of birth']"));
        $("//input[@placeholder='Date of birth']").type(lista.get(i).get("fecha_cumpleanio"));
        util.clickOutside();
        find("//select[contains(@name,'sel_nac')]").selectByVisibleText(lista.get(i).get("nacionalidad"));
        find("//select[contains(@name,'sel_tpdoc')]").selectByVisibleText(lista.get(i).get("tipo_documento"));
        $("//input[@placeholder='Document number']").type(lista.get(i).get("nro_documento"));
        selectFromDropdown($("//select[contains(@name,'sel_sex')]"),lista.get(i).get("sexo"));
        $("//input[@placeholder='Telephone']").type(lista.get(i).get("telefono"));
        $("//input[@placeholder='E-mail']").type(lista.get(i).get("email"));
        $("//input[@placeholder='Confirm your email']").type(lista.get(i).get("email"));
        Serenity.takeScreenshot();
    }

    }

    public void ClickContinuar(){
        withAction().moveToElement(btnContinuarPasajeros).perform();
        btnContinuarPasajeros.click();

    }
}
