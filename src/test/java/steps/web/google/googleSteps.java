package steps.web.google;

import driver.typeDriver.appium.Appium;
import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        List<WebElement> enable_iframe = Selenium.utilsWebElements.findElementsByCssSelector("iframe", 5);
            if (enable_iframe.size()>0)
            {
                Selenium.driver.switchTo().frame(enable_iframe.get(0));
                Selenium.utilsWebElements.findElementByText("Acepto").click();
            }
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
        Selenium.driver.switchTo().defaultContent();
        Selenium.utilsDriver.sleep(3);
    }

}
