package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

import java.util.List;


public class amazonProductCestPage {
    public WebElement totalProdcutos = Selenium.utilsWebElements.findElementByCssSelector("span#nav-cart-count.nav-cart-count.nav-cart-1");
    public WebElement imgProduct = Selenium.utilsWebElements.findElementByCssSelector("div.huc-v2-table-col");
    public List<WebElement> nameProduct;

    public void searchProductName() {
        nameProduct = Selenium.utilsWebElements.findElementsByCssSelector("span.a-size-medium.sc-product-title", 5000);
    }
}