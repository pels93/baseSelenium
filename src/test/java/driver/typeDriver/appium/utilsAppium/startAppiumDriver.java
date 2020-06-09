package driver.typeDriver.appium.utilsAppium;

import driver.typeDriver.appium.Appium;
import driver.utilsSelectDriver.readProperties;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("rawtypes")
public class startAppiumDriver {

    private static URL urlServerAppium = null;
    private final String url = "http://127.0.0.1:4723/wd/hub";
    private static final String rutaApps = "/src/test/resources/apps_appium/";
    private static final String rutaCompleta = utilsSelectDriver.rutaProyecto() + rutaApps;

    public startAppiumDriver() {

        try {
            urlServerAppium = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public MobileDriver initTypePlatorm(readProperties fileProperties) {
        Platform tipo = Appium.plataforma;
        MobileDriver driver = null;
        switch (tipo) {
            case ANDROID: {
                String myApp = rutaCompleta + fileProperties.getAndroidApp();
                DesiredCapabilities caps = DesiredCapabilities.android();
                caps.setCapability(MobileCapabilityType.APP, myApp);
                caps.setCapability("platformName", "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, fileProperties.getAndroidNameMobile());
                caps.setCapability("VERSION", fileProperties.getAndroidVersionMobile());
                caps.setCapability("language", Appium.language);
                caps.setCapability("locale", fileProperties.getAndroidMobileLocate());
                driver = new AndroidDriver(urlServerAppium, caps);
                break;
            }

            case IOS: {
                String myApp = rutaCompleta + fileProperties.getIphoneApp();
                DesiredCapabilities caps = DesiredCapabilities.iphone();
                caps.setCapability(MobileCapabilityType.APP, myApp);
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, fileProperties.getIphoneName());
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, fileProperties.getIphoneVersion());
                caps.setCapability("language", Appium.language);
                caps.setCapability("locale", fileProperties.getIphoneMobileLanguageLocate());
                driver = new IOSDriver(urlServerAppium, caps);
                break;
            }
        }

        return driver;
    }


}
