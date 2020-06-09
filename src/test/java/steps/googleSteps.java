package steps;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.google.googlePage;
import pages.google.googleResultPage;

public class googleSteps {

    private googlePage paginaGoogle;

    @When("Buscar por {string}")
    public void buscar_por(String string) {
        paginaGoogle = new googlePage();
        paginaGoogle.barra.clear();
        paginaGoogle.barra.sendKeys(string);
        paginaGoogle.barra.submit();
    }

    @Then("Comprobar que lleva a {string}")
    public void comprobar_que_lleva_a_(String url) {
        googleResultPage googleResult = new googleResultPage();
        googleResult.resultFirst.click();
        Selenium.utilsDriver.sleep(3);
        String urlActual = Selenium.driver.getCurrentUrl();
        Selenium.utilsWebElements.assertEqualsText(urlActual, url, false);
    }

}
