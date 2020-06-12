package steps.web;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.Given;
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
}
