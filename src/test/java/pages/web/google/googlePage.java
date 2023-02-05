package pages.web.google;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;

import java.util.List;

public class googlePage {

    public WebElement barra = Selenium.utilsWebElements.findElementByName("q");


    public void accept_cookies() {
        List<WebElement> enable_iframe = Selenium.utilsWebElements.findElementsByCssSelector("iframe", 5);
        if (enable_iframe.size() > 0) {
            Selenium.driver.switchTo().frame(enable_iframe.get(0));
            findButtonAccept();
            Selenium.driver.switchTo().defaultContent();
        } else {
            findButtonAccept();
        }
    }

    public void findButtonAccept() {
        WebElement aceptar = Selenium.utilsWebElements.findElementByXpath("(//*/div/button)[4]/div");
        Selenium.utilsDriver.scrollByElement(aceptar);
        aceptar.click();
    }
}
