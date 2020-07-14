package driver.utilsSelectDriver;

import driver.interfacesTypeDriver.Locate;
import driver.interfacesTypeDriver.TypeDriver;
import driver.interfacesTypeDriver.languages;
import driver.typeDriver.appium.interfacesAppium.typeMobile;
import driver.typeDriver.selenium.interfacesSelenium.Browsers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class readProperties {
    private final String propFileName = "RunCucumber.properties";
    private final String rutacompleta = utilsSelectDriver.ProjectDirectory() + "/src/test/java/" + propFileName;
    private final File initialFile;
    private InputStream inputStream;
    private final HashMap<String, String> capabilitiesCucumber;

    public readProperties() {
        Properties prop = new Properties();
        capabilitiesCucumber = new HashMap<>();
        initialFile = new File(rutacompleta);

        try {
            inputStream = new FileInputStream(initialFile);
            prop.load(inputStream);
            for (final String name : prop.stringPropertyNames())
                capabilitiesCucumber.put(name, prop.getProperty(name).replaceAll("\\s+$", ""));

        } catch (Exception ignored) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    utilsSelectDriver.printError("ERROR -> can't close the file " + "\"" + propFileName + "\"\n" + initialFile.toString(), "");
                    e.printStackTrace();
                }
            } else {
                utilsSelectDriver.printError("ERROR -> Unable to locate the file " + "\"" + propFileName + "\"\n" + initialFile.toString(), "");
            }
        }
        copyProperties();
    }

    public int getTypeDriver() {
        int auxreturn;

        switch (capabilitiesCucumber.get("cucumber.typeDriver").toLowerCase()) {
            case "appium": {
                auxreturn = TypeDriver.appium;
                break;
            }
            case "selenium": {
                auxreturn = TypeDriver.selenium;
                break;
            }
            default: {
                auxreturn = TypeDriver.selenium;
            }
        }

        return auxreturn;
    }

    public int getBrowser() {
        int auxreturn;
        switch (capabilitiesCucumber.get("cucumber.typeBrowser").toLowerCase()) {
            case "firefox": {
                auxreturn = Browsers.firefox;
                break;
            }
            case "edge": {
                auxreturn = Browsers.edge;
                break;
            }
            case "opera": {
                auxreturn = Browsers.opera;
                break;
            }
            case "safari": {
                auxreturn = Browsers.safari;
                break;
            }
            case "explorer": {
                auxreturn = Browsers.explorer;
                break;
            }
            default: {
                auxreturn = Browsers.chrome;
            }
        }

        return auxreturn;
    }

    public Platform getMobilePlatform() {
        Platform auxreturn;
        switch (capabilitiesCucumber.get("cucumber.mobilePlatform").toLowerCase()) {
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
        String uax = capabilitiesCucumber.get("cucumber.mobileLanguage").substring(3);
        String auxreturn;
        switch (uax) {
            case languages.french: {
                auxreturn = languages.french;
                break;
            }
            case languages.english: {
                auxreturn = languages.english;
                break;
            }
            case languages.italian: {
                auxreturn = languages.italian;
                break;
            }
            case languages.chinese: {
                auxreturn = languages.chinese;
                break;
            }
            case languages.japan: {
                auxreturn = languages.japan;
                break;
            }
            case languages.portuguese: {
                auxreturn = languages.portuguese;
                break;
            }
            case languages.german: {
                auxreturn = languages.german;
                break;
            }
            default: {
                auxreturn = languages.spain;
            }
        }
        return auxreturn;
    }

    public String getAndroidMobileLocate() {
        String uax = capabilitiesCucumber.get("cucumber.mobileLanguage").substring(0, 2);
        String auxreturn;
        switch (uax) {
            case Locate.Frence: {
                auxreturn = Locate.Frence;
                break;
            }
            case Locate.England: {
                auxreturn = Locate.England;
                break;
            }
            case Locate.Italy: {
                auxreturn = Locate.Italy;
                break;
            }
            case Locate.HongKong: {
                auxreturn = Locate.HongKong;
                break;
            }
            case Locate.Portugal: {
                auxreturn = Locate.Portugal;
                break;
            }
            case Locate.Brazil: {
                auxreturn = Locate.Brazil;
                break;
            }
            case Locate.Belgica: {
                auxreturn = Locate.Belgica;
                break;
            }
            case Locate.Japan: {
                auxreturn = Locate.Japan;
                break;
            }
            default: {
                auxreturn = Locate.Spain;
            }
        }
        return auxreturn;
    }

    public String getIphoneMobileLanguageLocate() {
        return getAndroidMobileLanguage() + "_" + getAndroidMobileLocate();
    }

    public String getUrl() {
        String aux;

        try {
            aux = capabilitiesCucumber.get("urlServerAppium");
            if (aux.isEmpty()) {
                aux = "http://127.0.0.1:4723/wd/hub";
            }
        } catch (Exception ignored) {
            aux = "http://127.0.0.1:4723/wd/hub";
        }
        return aux;
    }

    public String getApp() {
        return capabilitiesCucumber.get("cucumber.app");
    }

    public String getVersionMobile() {
        return capabilitiesCucumber.get("cucumber.versionMobile");
    }

    public String getNameMobile() {
        return capabilitiesCucumber.get("cucumber.nameMobile");
    }

    public String getUdidMobile() {
        return capabilitiesCucumber.get("cucumber.adbName");
    }

    private String getDirectoryFileJSON() {
        String aux = capabilitiesCucumber.get("cumcumber.reportJSON");
        return aux.substring(0, aux.indexOf('$'));
    }

    public Boolean getEnableDeleteOldDrivers() {
        String aux = capabilitiesCucumber.get("cucumber.enableDeleteOldDrivers");
        boolean result = false;
        if (aux.toLowerCase().contains("t")) {
            result = true;
        }
        return result;
    }

    private void copyProperties() {
        String rutaDestino;
        if (getTypeDriver() == TypeDriver.selenium) {
            rutaDestino = utilsSelectDriver.ProjectDirectory() + "/" + getDirectoryFileJSON()
                    + capabilitiesCucumber.get("cucumber.typeDriver") + "_"
                    + capabilitiesCucumber.get("cucumber.typeBrowser") + "/"
                    + propFileName;
        } else {
            rutaDestino = utilsSelectDriver.ProjectDirectory() + "/" + getDirectoryFileJSON()
                    + capabilitiesCucumber.get("cucumber.typeDriver") + "_"
                    + capabilitiesCucumber.get("cucumber.app") + "_"
                    + capabilitiesCucumber.get("cucumber.nameMobile") + "/"
                    + propFileName;
        }

        File fileIni = new File(rutacompleta);
        File fileFinal = new File(rutaDestino);

        try {
            FileUtils.copyFile(fileIni, fileFinal);
        } catch (Exception ignored) {
        }
        if (fileFinal.exists()) {
            utilsSelectDriver.printMsg("Copy file from \n" + fileIni.toString() + "\n to \n" + fileFinal.toString());
        } else {
            utilsSelectDriver.printMsg("NOT copy file from \n" + fileIni.toString() + "\n to \n" + fileFinal.toString());
        }

    }

}

