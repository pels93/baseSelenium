package driver.typeDriver.selenium.utilsSelenium;

import driver.typeDriver.selenium.Selenium;
import driver.typeDriver.selenium.utilsSelenium.interfacesSelenium.Navegadores;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class startSeleniumDriverBrowser {

    public WebDriver driver;

    public WebDriver selectBrowser() {
        String rutaDrivers = "/src/test/resources/drivers_selenium/";
        String rutaCompleta = utilsSelectDriver.rutaProyecto() + rutaDrivers;
        utilsSelectDriver.createDirectory(rutaCompleta);

        switch (Selenium.navegador) {
            case Navegadores.firefox: {
                WebDriverManager.firefoxdriver().cachePath(rutaCompleta);
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", WebDriverManager.firefoxdriver().getBinaryPath());
                try {
                    driver = new FirefoxDriver();
                } catch (Exception e) {
                    WebDriverManager.firefoxdriver().forceDownload();
                    utilsSelectDriver.printError("ERROR ->Driver not initialized", e.toString());
                }
                break;
            }
            case Navegadores.chrome: {
                WebDriverManager.chromedriver().cachePath(rutaCompleta);
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", WebDriverManager.chromedriver().getBinaryPath());
                try {
                    driver = new ChromeDriver();
                } catch (Exception e) {
                    WebDriverManager.chromedriver().forceDownload();
                    utilsSelectDriver.printError("ERROR ->Driver not initialized", e.toString());
                }
                break;
            }
            case Navegadores.edge: { //usar la ultima version del navegador edge
                WebDriverManager.edgedriver().cachePath(rutaCompleta);
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", WebDriverManager.edgedriver().getBinaryPath());
                try {
                    driver = new EdgeDriver();
                } catch (Exception e) {
                    WebDriverManager.edgedriver().forceDownload();
                    utilsSelectDriver.printError("ERROR ->Driver not initialized", e.toString());
                }
                break;
            }
        }
        return driver;
    }


}
