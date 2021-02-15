package pages.web.google;

import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;

import java.util.List;

public class googlePage {

    public WebElement barra = Selenium.utilsWebElements.findElementByName("q");

}
