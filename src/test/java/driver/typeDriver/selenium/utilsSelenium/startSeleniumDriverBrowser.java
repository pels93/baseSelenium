package driver.typeDriver.selenium.utilsSelenium;

import driver.typeDriver.selenium.Selenium;
import driver.typeDriver.selenium.interfacesSelenium.Browsers;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class startSeleniumDriverBrowser {

    private WebDriver driver;
    private final String MsgError = "ERROR ->Driver not initialized";

    public WebDriver selectBrowser(boolean enableDeleteOldDrivers) {
        String rutaDrivers = "/src/test/resources/drivers_selenium/";
        String rutaCompleta = utilsSelectDriver.ProjectDirectory() + rutaDrivers;
        if (enableDeleteOldDrivers) {
            utilsSelectDriver.manageDirectory(rutaCompleta, 1);
        }
        utilsSelectDriver.manageDirectory(rutaCompleta, 0);

        switch (Selenium.browser) {

            case Browsers.firefox: {
                WebDriverManager.firefoxdriver().cachePath(rutaCompleta);
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", WebDriverManager.firefoxdriver().getBinaryPath());
                try {
                    driver = new FirefoxDriver();
                } catch (Exception e) {
                    WebDriverManager.firefoxdriver().forceDownload();
                    utilsSelectDriver.printError(MsgError, e.toString());
                }
                break;
            }

            case Browsers.chrome: {
                WebDriverManager.chromedriver().cachePath(rutaCompleta);
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", WebDriverManager.chromedriver().getBinaryPath());
                try {
                    driver = new ChromeDriver();
                } catch (Exception e) {
                    WebDriverManager.chromedriver().forceDownload();
                    utilsSelectDriver.printError(MsgError, e.toString());
                }
                break;
            }

            case Browsers.opera: {
                WebDriverManager.operadriver().cachePath(rutaCompleta);
                WebDriverManager.operadriver().setup();
                System.setProperty("webdriver.chrome.driver", WebDriverManager.operadriver().getBinaryPath());
                try {
                    driver = new OperaDriver();
                } catch (Exception e) {
                    WebDriverManager.operadriver().forceDownload();
                    utilsSelectDriver.printError(MsgError, e.toString());
                }
                break;
            }
            case Browsers.edge: {
                // https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
                WebDriverManager.edgedriver().cachePath(rutaCompleta);
                WebDriverManager.edgedriver().setup();
                System.setProperty("webdriver.edge.driver", WebDriverManager.edgedriver().getBinaryPath());
                try {
                    driver = new EdgeDriver();
                } catch (Exception e) {
                    WebDriverManager.edgedriver().forceDownload();
                    utilsSelectDriver.printError(MsgError, e.toString());
                }
                break;
            }
            case Browsers.explorer: {
                //https://stackoverflow.com/questions/14952348/not-able-to-launch-ie-browser-using-selenium2-webdriver-with-java
                //https://stackoverflow.com/questions/59759426/selenium-performance-with-internetexplorerdriver-and-ie11
                //https://www.selenium.dev/downloads/
                WebDriverManager.iedriver().cachePath(rutaCompleta);
                WebDriverManager.iedriver().setup();
                System.setProperty("webdriver.ie.driver", WebDriverManager.iedriver().getBinaryPath());
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
               /* ieCapabilities.setCapability("nativeEvents", true);
                ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                ieCapabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings", true);
                ieCapabilities.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
                ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                ieCapabilities.setCapability("disable-popup-blocking", true);
                ieCapabilities.setCapability("enablePersistentHover", true);
                ieCapabilities.setCapability("EnsureCleanSession", true);
                ieCapabilities.setCapability("RequireWindowFocus", true);
                */
                ieCapabilities.setCapability("ignoreZoomSetting", true);
                ieCapabilities.setCapability("AcceptInsecureCertificates", true);
                try {
                    driver = new InternetExplorerDriver(ieCapabilities);
                } catch (Exception e) {
                    WebDriverManager.iedriver().forceDownload();
                    utilsSelectDriver.printError(MsgError, e.toString());
                }
                break;
            }
            case Browsers.safari: {
                System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
                try {
                    driver = new SafariDriver();
                } catch (Exception e) {
                    utilsSelectDriver.printError("ERROR ->Driver not initialized", e.toString());
                }
                break;
            }
        }
        return driver;
    }


}
