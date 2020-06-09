package steps;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class startNavegadorSteps {

    @Given("Encender el navegador")
    public void encender_el_navegador() {
    System.out.println("iniciando navegador");
    }

    @When("Ir a {string}")
    public void irA(String url) {
        Selenium.driver.get(url);
        Selenium.utilsDriver.sendKeys(Keys.ALT);
    }
}
