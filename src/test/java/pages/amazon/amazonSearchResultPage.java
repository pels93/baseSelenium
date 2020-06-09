package pages.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

import java.util.List;


public class amazonSearchResultPage {
    public List<WebElement> resultados = Selenium.utilsWebElements.findElementsByCssSelector("img.s-image", 5000);
    //public List<WebElement> resultados=Selenium.utilsWebElements.findElementsByCssSelector("div.rush-component.s-expand-height");
}
