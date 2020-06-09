package driver.typeDriver.appium.utilsAppium;

import driver.utilsSelectDriver.readProperties;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("rawtypes")
public class startAppiumDriver {

    private static URL urlServerAppium = null;
    private static final String rutaApps = "/src/test/resources/apps_appium/";
    private static final String fullDirectory = utilsSelectDriver.ProjectDirectory() + rutaApps;

    public startAppiumDriver(readProperties fileProperties) {
        utilsSelectDriver.manageDirectory(fullDirectory, 0);
        setURL(fileProperties);
    }

    public AndroidDriver android(readProperties fileProperties) {
        String myApp = fullDirectory + fileProperties.getApp();
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.APP, myApp);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, fileProperties.getNameMobile());
        caps.setCapability(MobileCapabilityType.UDID, fileProperties.getUdidMobile());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, fileProperties.getVersionMobile());
        caps.setCapability(MobileCapabilityType.LANGUAGE, fileProperties.getAndroidMobileLanguage());
        caps.setCapability(MobileCapabilityType.LOCALE, fileProperties.getAndroidMobileLocate());
        caps.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 60);
        caps.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 90000);
        return new AndroidDriver(urlServerAppium, caps);
    }

    public IOSDriver ios(readProperties fileProperties) {
        String myApp = fullDirectory + fileProperties.getApp();
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability(MobileCapabilityType.APP, myApp);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, fileProperties.getNameMobile());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, fileProperties.getVersionMobile());
        caps.setCapability(MobileCapabilityType.LANGUAGE, fileProperties.getAndroidMobileLanguage());
        caps.setCapability(MobileCapabilityType.LOCALE, fileProperties.getIphoneMobileLanguageLocate());
        return new IOSDriver(urlServerAppium, caps);
    }

    private void setURL(readProperties fileProperties) {
        try {
            urlServerAppium = new URL(fileProperties.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
