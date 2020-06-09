package driver.typeDriver.selenium;

import driver.typeDriver.selenium.interfacesSelenium.WindowsSize;
import driver.typeDriver.selenium.utilsSelenium.startSeleniumDriverBrowser;
import driver.typeDriver.selenium.utilsSelenium.utilsSeleiumDriver;
import driver.typeDriver.selenium.utilsSelenium.utilsWebElements;
import driver.utilsSelectDriver.readProperties;
import org.openqa.selenium.WebDriver;

public class Selenium {

    public static WebDriver driver;
    public static utilsSeleiumDriver utilsDriver;
    public static utilsWebElements utilsWebElements;
    public static int browser;

    public Selenium(readProperties fileProperties) {
        browser = fileProperties.getBrowser();
        startBrowser(fileProperties);
        if (driver != null) {
            utilsDriver = new utilsSeleiumDriver();
            utilsWebElements = new utilsWebElements();
            utilsDriver.deleteCookies();
            utilsDriver.setWindowsSize(WindowsSize.maximizado, 0, 0);
            utilsDriver.waiter(30000);
        }
    }

    private void startBrowser(readProperties fileProperties) {
        startSeleniumDriverBrowser startBrowser = new startSeleniumDriverBrowser();
        driver = startBrowser.selectBrowser(fileProperties.getEnableDeleteOldDrivers());
    }
}



