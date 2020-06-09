package driver.utilsSelectDriver;

import driver.interfacesTypeDriver.TipoDriver;
import driver.typeDriver.appium.interfacesAppium.mobileIdioma;
import driver.typeDriver.appium.interfacesAppium.typeMobile;
import driver.typeDriver.selenium.utilsSelenium.interfacesSelenium.Navegadores;
import org.openqa.selenium.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readProperties {
    String propFileName = "RunCucumber.properties";
    String rutacompleta = utilsSelectDriver.rutaProyecto() + "/src/test/java/" + propFileName;
    File initialFile;
    InputStream inputStream;


    // variables file
    String tipoDriver;
    String navegador;
    String mobilePlatform;
    String mobileLanguage;
    //android
    String AndroidNameMobile;
    String androidVersionMobile;
    String appAndroid;
    //ios
    String iphoneName;
    String iphoneVersion;
    String iphoneApp;


    public readProperties() {
        try {
            Properties prop = new Properties();
            initialFile = new File(rutacompleta);
            inputStream = new FileInputStream(initialFile);
            prop.load(inputStream);
            tipoDriver = prop.getProperty("typeDriver").replace(" ", "");
            navegador = prop.getProperty("browser").replace(" ", "");
            mobilePlatform = prop.getProperty("mobilePlatform").replace(" ", "");
            mobileLanguage = prop.getProperty("mobileLanguage").replace(" ", "");
            //android
            AndroidNameMobile = prop.getProperty("android_mobile").replace(" ", "");
            androidVersionMobile = prop.getProperty("android_v_mobile").replace(" ", "");
            appAndroid = prop.getProperty("android_app").replace(" ", "");
            //ios
            iphoneName = prop.getProperty("iphone_name").replace(" ", "");
            iphoneVersion = prop.getProperty("iphone_v").replace(" ", "");
            iphoneApp = prop.getProperty("iphone_app").replace(" ", "");

        } catch (Exception ignored) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                utilsSelectDriver.printError("ERROR -> Unable to locate element \"" + propFileName + "\"\n" + initialFile.toString(), "");
            }
        }
    }

    public int getTipoDriver() {
        int auxreturn;
        switch (tipoDriver.toLowerCase()) {
            case "appium": {
                auxreturn = TipoDriver.appium;
                break;
            }
            case "selenium": {
                auxreturn = TipoDriver.selenium;
                break;
            }
            default: {
                auxreturn = TipoDriver.selenium;
            }
        }

        return auxreturn;
    }

    public int getBrower() {
        int auxreturn;
        switch (navegador.toLowerCase()) {
            case "firefox": {
                auxreturn = Navegadores.firefox;
                break;
            }
            case "edge": {
                auxreturn = Navegadores.edge;
                break;
            }
            default: {
                auxreturn = Navegadores.chrome;
            }
        }

        return auxreturn;
    }

    public Platform getMobilePlatform() {
        Platform auxreturn;
        switch (mobilePlatform.toLowerCase()) {
            case "ios": {
                auxreturn = typeMobile.ios;
                break;
            }
            case "android": {
                auxreturn = typeMobile.android;
                break;
            }
            default: {
                auxreturn = typeMobile.android;
            }
        }
        return auxreturn;
    }

    public String getAndroidMobileLanguage() {
        String uax = mobileLanguage.substring(3);
        String auxreturn;
        switch (uax) {
            case mobileIdioma.fr: {
                auxreturn = mobileIdioma.fr;
                break;
            }
            case mobileIdioma.en: {
                auxreturn = mobileIdioma.en;
                break;
            }
            default: {
                auxreturn = mobileIdioma.es;
            }
        }
        return auxreturn;
    }

    public String getIphoneMobileLanguageLocate() {
        return mobileLanguage;
    }

    public String getAndroidMobileLocate() {
        String uax = mobileLanguage.substring(0, 2);
        String auxreturn;
        switch (uax) {
            case "FR": {
                auxreturn = mobileIdioma.fr.toUpperCase();
                break;
            }
            case "EN": {
                auxreturn = mobileIdioma.en.toUpperCase();
                break;
            }
            default: {
                auxreturn = mobileIdioma.es.toUpperCase();
            }
        }
        return auxreturn;
    }

    public String getAndroidApp() {
        return appAndroid;
    }

    public String getAndroidVersionMobile() {
        return androidVersionMobile;
    }

    public String getAndroidNameMobile() {
        return AndroidNameMobile;
    }

    public String getIphoneApp() {
        return iphoneApp;
    }

    public String getIphoneName() {
        return iphoneName;
    }

    public String getIphoneVersion() {
        return iphoneVersion;
    }

}

