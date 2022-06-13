package steps.web.withOutParameters;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.web.amazon.amazonPage;


public class withOut_amazonSteps {

    amazonPage amazon;

    @When("Buscar por amazon tornillos")
    public void buscarPorAmazonTornillos() {
        amazon = new amazonPage();
        amazon.load_search_banner();
        Selenium.utilsDriver.scrollByElement(amazon.barrabusqueda);
        amazon.select.selectByIndex(0);
        amazon.barrabusqueda.click();
        amazon.barrabusqueda.sendKeys("tornillos");
        amazon.barrabusqueda.submit();
    }

    @And("Seleccionar el primer resultado")
    public void seleccionarElProductoDeLaPosicion() {
        Selenium.utilsDriver.sleep(3);
        amazon.results_page();
        amazon.resultados.get(0).click();
    }


    @Then("El total de productos es uno")
    public void elTotalDeProductosEsUno() {
        Selenium.utilsDriver.sleep(3);
        amazon.load_count_products();
        Assert.assertEquals(amazon.productList.getText(), 1);
    }
}
