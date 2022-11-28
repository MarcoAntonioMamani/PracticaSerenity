package com.automation.web.step;

import com.automation.web.page.CabinasPage;
import com.automation.web.page.CalendarioPage;
import com.automation.web.page.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;

public class CabinaSteps {

    HomePage homePage;
    CalendarioPage calendarioPage;
    CabinasPage cabinasPage;

    @Given("el usuario ingresa a la pagina de PeruRail")
    public void elUsuarioIngresaALaPaginaDePeruRail() {
      System.out.println("Variables Sistemaaaaaaaaaaaa");
    System.getProperty("ruta_bd");
       System.out.println("FINNNNNNNNNNNNNN  ------------------------------");
    homePage.open();
    }

    @SneakyThrows
    @And("selecciono el destino, ruta, tren, mes, anio y dia")
    public void seleccionoElDestinoRutaTrenMesAnioYDia() {
        homePage.seleccionarDestino("Cusco");
        homePage.seleccionarRuta("Puno > Cusco");
        homePage.seleccionarTren("Andean Explorer, A Belmond Train");
        calendarioPage.seleccionarSalida("September 2022","14");
        homePage.clickBuscar();

    }

    @And("selecciono {string} del tipo {string} con {int} pasajeros niños")
    public void seleccionoDelTipoConPasajerosNiños(String cant, String cabina, int cantNinios) {

        cabinasPage.seleccionarCabina(cabina,cant);
        cabinasPage.seleccionarCantidadNinios(""+cantNinios);
    }

    @When("doy clic en continuar en la pagina de cabinas")
    public void doyClicEnContinuarEnLaPaginaDeCabinas() {

        cabinasPage.clickContinuar();
    }

    @Then("se mostrara un popup con el mensaje {string}")
    public void seMostraraUnPopupConElMensaje(String mensaje) {

        Assert.assertEquals(mensaje,cabinasPage.obtenerTextoPopUp());
    }
}
