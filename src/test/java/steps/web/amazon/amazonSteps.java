package steps.web.amazon;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.web.amazon.amazonPage;


public class amazonSteps {

    amazonPage amazon;

    String descripProduct;
    String urlProducto;


    @And("Se visualiza la pagina de amazon")
    public void Sevisualizalapaginadeamazon() {
        amazon = new amazonPage();
        amazon.accept_cookies();
        Selenium.utilsDriver.sleep(2);
    }

    @And("Buscar en amazon {string}")
    public void buscarEnAmazon(String palabra) {
        amazon.load_search_banner();
        Selenium.utilsDriver.scrollByElement(amazon.barrabusqueda);
        amazon.select.selectByIndex(0);
        amazon.barrabusqueda.click();
        amazon.barrabusqueda.sendKeys(palabra);
        amazon.barrabusqueda.submit();
    }

    @And("Seleccionar el producto de la posicion {string}")
    public void seleccionarElProductoDeLaPosicion(String arg0) {
        Selenium.utilsDriver.sleep(3);
        amazon.results_page();
        amazon.resultados.get(Integer.parseInt(arg0)).click();
    }

    @And("Se visualiza la pagina del producto")
    public void seVisualizaLaPaginaDelProducto() {
        Selenium.utilsDriver.sleep(1);
        amazon.product_page();
        urlProducto = Selenium.utilsDriver.getURLPage();
        descripProduct = amazon.titleProduct.getText();
    }

    @And("Se add a la cesta")
    public void seAddALaCesta() {
        amazon.addProdcuctCest.click();
        Selenium.utilsDriver.sleep(5);
    }

    @Then("El total de productos es {string}")
    public void elTotalDeProductosEs(String cantidad) {
        Selenium.utilsDriver.sleep(3);
        amazon.load_list();
        Assert.assertEquals(Integer.parseInt(cantidad),amazon.productList.size());
    }


}
