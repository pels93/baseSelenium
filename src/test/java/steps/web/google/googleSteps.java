package steps.web.google;

import driver.typeDriver.appium.Appium;
import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.google.googlePage;
import pages.web.google.googleResultPage;

public class googleSteps {

    private googlePage paginaGoogle;

    @When("Se visualiza la pagina de busqueda de google")
    public void seVisualizaLaPaginaDeBusquedaDeGoogle() {
        paginaGoogle = new googlePage();
        Selenium.utilsWebElements.isDisplayOrEnable(paginaGoogle.barra,true);
    }

    @When("Buscar en google por {string}")
    public void buscar_por(String string) {
        paginaGoogle = new googlePage();
        paginaGoogle.barra.clear();
        paginaGoogle.barra.sendKeys(string);
        paginaGoogle.barra.submit();
    }

    @When("presiona en el boton iniciar sesion en google")
    public void presionaEnElBotonIniciarSesionEnGoogle() {
        paginaGoogle.btnStartSesion.click();
        Selenium.utilsDriver.sleep(10);
    }

    @And("Seleccionar el primer resultado en google")
    public void seleccionarElPrimerResultadoEnGoogle() {
        Selenium.utilsDriver.sleep(2);
        googleResultPage googleResult = new googleResultPage();
        googleResult.resultFirst.click();
        Selenium.utilsDriver.sleep(3);
    }

}
