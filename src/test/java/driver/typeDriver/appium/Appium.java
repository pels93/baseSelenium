package driver.typeDriver.appium;

import driver.typeDriver.appium.utilsAppium.startAppiumDriver;
import driver.typeDriver.appium.utilsAppium.utilsAppiumDriver;
import driver.typeDriver.appium.utilsAppium.utilsMobileElements;
import driver.utilsSelectDriver.readProperties;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.Platform;


@SuppressWarnings("rawtypes")
public class Appium {

    public static Platform plataforma;
    public static String language;
    public static MobileDriver driver;
    public static utilsAppiumDriver utilsDriver;
    public static utilsMobileElements utilsMobileElements;

    public Appium(readProperties fileProperties) {
        plataforma = fileProperties.getMobilePlatform();
        language = fileProperties.getAndroidMobileLanguage();
        startAppiumDriver initAppium = new startAppiumDriver();
        driver = initAppium.initTypePlatorm(fileProperties);

        if (driver != null) {
            utilsMobileElements = new utilsMobileElements();
            utilsDriver = new utilsAppiumDriver();
            utilsDriver.waiter(5000);
        }


    }

}



