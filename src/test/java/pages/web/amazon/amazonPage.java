package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class amazonPage {

    public Select select;
    public WebElement barrabusqueda;

    public List<WebElement> resultados;

    //Product page
    public WebElement titleProduct;
    public WebElement addProdcuctCest;
    //Product list
    public WebElement productList;

    // init
    public amazonPage() {

    }

    // accept cookies
    public void accept_cookies() {
        List<WebElement> accept_cookies = Selenium.utilsWebElements.findElementsByCssSelector("form#sp-cc", 2);
        if (accept_cookies.size() > 0) {
            WebElement btn_accept = Selenium.utilsWebElements.findElementByCssSelector("input#sp-cc-accept");
            btn_accept.click();
        }
    }


    public void load_search_banner() {
        select = Selenium.utilsWebElements.findSelectorCssSelector("select#searchDropdownBox.nav-search-dropdown.searchSelect");
        barrabusqueda = Selenium.utilsWebElements.findElementById("twotabsearchtextbox");
    }


    // result find product
    public void results_page() {
        resultados = Selenium.utilsWebElements.findElementsByCssSelector("img.s-image", 5000);
    }

    // Page product
    public void product_page() {
        titleProduct = Selenium.utilsWebElements.findElementByCssSelector("span#productTitle.a-size-large");
        addProdcuctCest = Selenium.utilsWebElements.findElementByCssSelector("input#add-to-cart-button.a-button-input");
    }

    //Product list
    public void load_count_products() {
        productList = Selenium.utilsWebElements.findElementByXpath("//header//div[@class=\"nav-right\"]//span[@id=\"nav-cart-count\"]");
    }

}
