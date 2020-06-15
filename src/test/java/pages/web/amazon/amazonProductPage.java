package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

import java.util.List;

public class amazonProductPage {
    public WebElement titleProduct = Selenium.utilsWebElements.findElementByCssSelector("span#productTitle.a-size-large");
    public WebElement addProdcuctCest = addProductCest();

    private WebElement addProductCest() {
        {
            WebElement result;
            List<WebElement> addProdcuctCesta = Selenium.utilsWebElements.findElementsByCssSelector("input#add-to-cart-button.a-button-input", 1000);
            if (addProdcuctCesta.isEmpty()) {
                result = Selenium.utilsWebElements.findElementByCssSelector("span.a-button-inner");
            } else {
                result = addProdcuctCesta.get(0);
            }

            return result;
        }
    }

}

