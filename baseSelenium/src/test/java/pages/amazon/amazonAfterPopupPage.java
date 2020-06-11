package pages.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

public class amazonAfterPopupPage {
    public WebElement xClose = Selenium.utilsWebElements.findElementByCssSelector("a#close_sideSheet.a-link-normal.close-button");
    public WebElement btnCesta = Selenium.utilsWebElements.findElementByCssSelector("span#attach-sidesheet-view-cart-button.a-button a-button-base.attach-button-large");
}
