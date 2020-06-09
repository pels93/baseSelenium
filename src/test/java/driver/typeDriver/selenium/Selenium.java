package driver.typeDriver.selenium;

import driver.typeDriver.selenium.utilsSelenium.interfacesSelenium.tamanoVentana;
import driver.typeDriver.selenium.utilsSelenium.startSeleniumDriverBrowser;
import driver.typeDriver.selenium.utilsSelenium.utilsSeleiumDriver;
import driver.typeDriver.selenium.utilsSelenium.utilsWebElements;
import driver.utilsSelectDriver.readProperties;
import org.openqa.selenium.WebDriver;

public class Selenium {

    public static WebDriver driver;
    public static utilsSeleiumDriver utilsDriver;
    public static utilsWebElements utilsWebElements;
    public static int navegador;

    public Selenium(readProperties fileProperties) {
        navegador = fileProperties.getBrower();
        startSeleniumDriverBrowser startBrowser = new startSeleniumDriverBrowser();
        driver = startBrowser.selectBrowser();
        if (driver != null) {
            utilsDriver = new utilsSeleiumDriver();
            utilsWebElements = new utilsWebElements();
            utilsDriver.deleteCookies();
            utilsDriver.setWindowsSize(tamanoVentana.maximizado, 0, 0);
            utilsDriver.waiter(30000);
        }
    }

}



