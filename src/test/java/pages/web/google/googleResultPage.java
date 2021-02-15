package pages.web.google;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

public class googleResultPage {

    public WebElement resultFirst = Selenium.utilsWebElements.findElementByCssSelector(".g a");
}