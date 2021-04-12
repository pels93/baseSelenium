package steps.web.google;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pages.web.google.googlePage;
import pages.web.google.googleResultPage;

import java.util.List;

public class googleSteps {

    private googlePage paginaGoogle;

    @When("Se visualiza la pagina de busqueda de google")
    public void seVisualizaLaPaginaDeBusquedaDeGoogle() {
        paginaGoogle = new googlePage();
        Selenium.utilsWebElements.isDisplayOrEnable(paginaGoogle.barra, true);
        Selenium.utilsDriver.sleep(5);
        paginaGoogle.accept_cookies();
    }

    @When("Buscar en google por {string}")
    public void buscar_por(String string) {
        paginaGoogle = new googlePage();
        paginaGoogle.barra.clear();
        paginaGoogle.barra.sendKeys(string);
        paginaGoogle.barra.submit();
    }


    @And("Seleccionar el primer resultado en google")
    public void seleccionarElPrimerResultadoEnGoogle() {
        Selenium.utilsDriver.sleep(2);
        googleResultPage googleResult = new googleResultPage();
        googleResult.resultFirst.click();
        Selenium.utilsDriver.sleep(3);
    }

}
