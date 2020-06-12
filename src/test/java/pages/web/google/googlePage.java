package pages.web.google;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

public class googlePage {

    public WebElement barra = Selenium.utilsWebElements.findElementByName("q");
    public WebElement btnStartSesion = Selenium.utilsWebElements.findElementByCssSelector("a#gb_70.gb_pe.gb_4.gb_5c");

}
