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
            Selenium.utilsWebElements.findElementByXpath("(//*/div/button)[4]").click();
            Selenium.driver.switchTo().defaultContent();
        }
        List<WebElement> aux_click_text = Selenium.utilsWebElements.findElementsByText("Acepto", 5);
        if (aux_click_text.size() > 0) {
            aux_click_text.get(0).click();
        } else {
            List<WebElement> aux_click_css = Selenium.utilsWebElements.findElementsByCssSelector("button#zV9nZe", 5);
            if (aux_click_css.size() > 0) {
                aux_click_css.get(0).click();
            }
        }
    }

}
