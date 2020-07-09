package steps.web;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class startNavegadorSteps {

    @Given("Encender el navegador")
    public void encender_el_navegador() {
    System.out.println("iniciando navegador");
    }

    @When("El navegador introduce la URL {string}")
    public void irA(String url) {
        Selenium.driver.get(url);
    }

    @Then("Comprobar que lleva a {string}")
    public void comprobar_que_lleva_a_(String url) {
        Selenium.utilsDriver.sleep(1);
        String urlActual = Selenium.utilsDriver.getURLPage();
        Selenium.utilsWebElements.assertEqualsText(urlActual, url, false);
        Selenium.utilsDriver.sleep(1);
        Selenium.utilsDriver.Scroll(400);
        Selenium.utilsDriver.sleep(2);
    }
}
