package steps.web.amazon;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.web.amazon.*;


public class amazonSteps {

    amazonProductPage product;
    String descripProduct;
    String urlProducto;

    @And("Buscar en amazon {string}")
    public void buscarEnAmazon(String palabra) {
        amazonPage amazon = new amazonPage();
        Selenium.utilsDriver.sleep(2);
        amazon.select.selectByIndex(0);
        amazon.barrabusqueda.click();
        amazon.barrabusqueda.sendKeys(palabra);
        amazon.barrabusqueda.submit();
    }

    @And("Seleccionar el producto de la posicion {string}")
    public void seleccionarElProductoDeLaPosicion(String arg0) {
        Selenium.utilsDriver.sleep(1);
        amazonSearchResultPage result = new amazonSearchResultPage();
        result.resultados.get(Integer.parseInt(arg0)).click();
    }

    @And("Se visualiza la pagina del producto")
    public void seVisualizaLaPaginaDelProducto() {
        Selenium.utilsDriver.sleep(1);
        product = new amazonProductPage();
        urlProducto = Selenium.utilsDriver.getURLPage();
        descripProduct = product.titleProduct.getText();
    }


    @And("Se add a la cesta")
    public void seAddALaCesta() {
        product.addProdcuctCest.click();
    }

    @And("Si salta oferta se cierra")
    public void siSaltaOfertaSeCierra() {
        if (urlProducto.equals(Selenium.utilsDriver.getURLPage())) {
            amazonPopupPage popup = new amazonPopupPage();
            if (popup.add.size() > 0) {
                popup.firstPopup();
                popup.notAdd.get(0).click();
                amazonAfterPopupPage afterPopup = new amazonAfterPopupPage();
                afterPopup.btnCesta.click();
            }
            if (popup.addSecondType.size() > 0) {
                popup.secondPopup();
                popup.notSecondType.get(0).click();
            }
        }
    }

    @Then("El producto {string} esta en la cesta de {string}")
    public void elProductoProductosEstaEnLaCestaDe(String arg0, String arg1) {
        amazonProductCestPage cesta = new amazonProductCestPage();
        Selenium.utilsDriver.sleep(2);
        amazonPage amazon = new amazonPage();
        amazon.barrabusqueda.click();
        Selenium.utilsWebElements.clickLong(cesta.imgProduct);
        cesta.searchProductName();
        String auxNameProduct = cesta.nameProduct.get(0).getText();
        Selenium.utilsWebElements.assertContainText(descripProduct, auxNameProduct.substring(0, auxNameProduct.length() - 3), false);
    }

    @Then("El total de productos es {string}")
    public void elTotalDeProductosEs(String cantidad) {
        amazonProductCestPage cesta = new amazonProductCestPage();
        Selenium.utilsWebElements.assertEqualsText(cesta.totalProdcutos.getText(), cantidad, false);
    }


}
