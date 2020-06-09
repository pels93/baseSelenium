package pages.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

public class amazonProductPage {
    public WebElement titleProduct = Selenium.utilsWebElements.findElementByCssSelector("span#productTitle.a-size-large");
    public WebElement addProdcuctCest = Selenium.utilsWebElements.findElementByCssSelector("input#add-to-cart-button.a-button-input");

}

