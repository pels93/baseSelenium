package steps.amazon;

import driver.typeDriver.selenium.Selenium;
import driver.typeDriver.selenium.interfacesSelenium.Browsers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.amazon.*;

import java.util.List;


public class amazonSteps {

    amazonProductPage product;
    String descripProduct;
    amazonProductCestPage cesta;

    @Then("Lleva a la pagina de amazon")
    public void llevaALaPaginaDeAmazon() {
        System.out.println("pepe");
    }


    @And("Buscar en amazon {string}")
    public void buscarEnAmazon(String palabra) {
        Selenium.utilsDriver.sleep(1);
        amazonPage amazon = new amazonPage();
        amazon.select.selectByIndex(0);
        amazon.barrabusqueda.sendKeys(palabra);
        amazon.barrabusqueda.submit();
    }

    @And("Seleccionar el primer resultado")
    public void seleccionarElPrimerResultado() {
        Selenium.utilsDriver.sleep(1);
        List<WebElement> resultados;
        if (Selenium.browser != Browsers.firefox) {
            amazonSearchResultPage result = new amazonSearchResultPage();
            resultados = result.resultados;
        } else {
            resultados = Selenium.utilsWebElements.findElementsByCssSelector("div.rush-component.s-expand-height", 5000);
        }
        resultados.get(0).click();
    }

    @And("Se visualiza la pagina del producto")
    public void seVisualizaLaPaginaDelProducto() {
        Selenium.utilsDriver.sleep(1);
        product = new amazonProductPage();
        descripProduct = product.titleProduct.getText();
    }


    @And("Se add a la cesta")
    public void seAddALaCesta() {
        product.addProdcuctCest.click();
    }

    @And("Si salta oferta se cierra")
    public void siSaltaOfertaSeCierra() {
        amazonPopupPage popup = new amazonPopupPage();
        if (popup.add.size() > 0) {
            popup.notAdd.get(0).click();
            amazonAfterPopupPage afterPopup = new amazonAfterPopupPage();
            afterPopup.btnCesta.click();
        }
        if (popup.addSecondType.size() > 0) {
            popup.notSecondType.get(0).click();
        }
    }

    @Then("El producto {string} esta en la cesta de {string}")
    public void elProductoProductosEstaEnLaCestaDe(String arg0, String arg1) {
        Selenium.utilsDriver.sleep(2);
        cesta = new amazonProductCestPage();
        cesta.imgProduct.click();
        Selenium.utilsDriver.sleep(2);
        cesta.searchProductName();
        String auxNameProduct = cesta.nameProduct.get(0).getText();
        if (!cesta.nameProduct.isEmpty()) {
            Selenium.utilsWebElements.assertContainText(descripProduct, auxNameProduct.substring(0, auxNameProduct.length() - 3), false);
        }
    }

    @Then("El total de productos es {string}")
    public void elTotalDeProductosEs(String cantidad) {
        Selenium.utilsWebElements.assertEqualsText(cesta.totalProdcutos.getText(), cantidad, false);
    }


}
