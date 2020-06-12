package steps.web.withOutParameters;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.amazon.amazonPage;
import pages.web.amazon.amazonProductCestPage;


public class withOut_amazonSteps {


    @When("Buscar por amazon patatas")
    public void buscarPorAmazonPatatas() {
        Selenium.utilsDriver.sleep(1);
        amazonPage amazon = new amazonPage();
        amazon.select.selectByIndex(0);
        amazon.barrabusqueda.sendKeys("patatas");
        amazon.barrabusqueda.submit();
    }


    @Then("El total de productos es uno")
    public void elTotalDeProductosEsUno() {
        amazonProductCestPage cesta = new amazonProductCestPage();
        Selenium.utilsWebElements.assertEqualsText(cesta.totalProdcutos.getText(), "1", true);

    }
}
