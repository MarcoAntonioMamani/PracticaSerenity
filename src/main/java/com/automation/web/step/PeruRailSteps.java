package com.automation.web.step;

import com.automation.web.page.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PeruRailSteps {

    HomePage homePage;
    CalendarioPage calendarioPage;
    CabinasPage cabinasPage;
    DataPage dataPage;
    MetodoDePagoPage metodoDePagoPage;
    @When("selecciono el destino {string}, la ruta {string} y seleccionamos el tren {string}")
    public void seleccionoElDestinoLaRutaYSeleccionamosElTren(String destino, String ruta, String tren) {

        homePage.seleccionarDestino(destino);
        homePage.seleccionarRuta(ruta);
        homePage.seleccionarTren(tren);

    }

    @And("seleccionamos la fecha de salida {string} y {string}")
    public void seleccionamosLaFechaDeSalidaY(String mesAnio, String dia) {
        calendarioPage.seleccionarSalida(mesAnio,dia);
        homePage.clickBuscar();
    }

    @And("selecciono el tipo de cabina {string} y la cantidad de cabinas {string}")
    public void seleccionoElTipoDeCabinaYLaCantidadDeCabinas(String tipoCabina, String cantCabinas) {
    cabinasPage.seleccionarCabina(tipoCabina,cantCabinas);
    cabinasPage.clickContinuar();
    }

    @And("ingresamos la informacion de los pasajero")
    public void ingresamosLaInformacionDeLosPasajero(DataTable dataTable) {

    dataPage.listaFormulario(dataTable);

    }

    @When("doy click en continuar en la pagina de pasajeros")
    public void doyClickEnContinuarEnLaPaginaDePasajeros() {
        dataPage.ClickContinuar();
    }

    @Then("se mostrara la pantalla de pago {string}")
    public void seMostraraLaPantallaDePago(String titulo) {
        Assert.assertEquals(titulo,metodoDePagoPage.obtenerTitulo());
    }

    @And("elegiremos como {string} metodo de pago e ingresaremos el {string},{string},{string}, {string},{string}")
    public void elegiremosComoMetodoDePagoEIngresaremosEl(String metodoPago, String nroTarjeta, String mesExpiracion
            , String AnioExpiracion, String codigoSeguridad, String nombre) {
    metodoDePagoPage.clickMetodoPago(metodoPago);
    metodoDePagoPage.aceptarTerminosCondiciones();
    metodoDePagoPage.clickIngresarTarjeta(nroTarjeta,mesExpiracion,AnioExpiracion,codigoSeguridad,nombre);
    }
}
