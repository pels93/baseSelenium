package driver.typeDriver.appium;

import driver.typeDriver.appium.utilsAppium.startAppiumDriver;
import driver.typeDriver.appium.utilsAppium.utilsAppiumDriver;
import driver.typeDriver.appium.utilsAppium.utilsMobileElements;
import driver.utilsSelectDriver.readProperties;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Platform;


@SuppressWarnings("rawtypes")
public class Appium {

    public static Platform platform;
    public static MobileDriver driver;
    public static utilsAppiumDriver utilsDriver;
    public static utilsMobileElements utilsMobileElements;
    private static AndroidDriver driverAndroid;
    private static IOSDriver driverIos;

    public Appium(readProperties fileProperties) {
        platform = fileProperties.getMobilePlatform();
        selectPlatform(fileProperties);
        if (driver != null) {
            utilsDriver = new utilsAppiumDriver();
            utilsMobileElements = new utilsMobileElements(driverAndroid, driverIos);
            utilsDriver.waiter(5000);
        }
    }

    private void selectPlatform(readProperties fileProperties) {
        startAppiumDriver initAppium = new startAppiumDriver(fileProperties);
        switch (platform) {
            case ANDROID: {
                driverAndroid = initAppium.android(fileProperties);
                driver = driverAndroid;
                break;
            }
            case IOS: {
                driverIos = initAppium.ios(fileProperties);
                driver = driverIos;
                break;
            }
        }
    }
}



