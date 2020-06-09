package driver.utilsSelectDriver;


import driver.interfacesTypeDriver.TipoDriver;
import driver.typeDriver.appium.Appium;
import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;


public class utilsSelectDriver {

    protected final int tipoDriver;

    public utilsSelectDriver() {
        readProperties fileProperties = new readProperties();
        tipoDriver = fileProperties.getTipoDriver();

        switch (tipoDriver) {
            case TipoDriver.appium: {
                selectAppium(fileProperties);
                break;
            }
            case TipoDriver.selenium: {
                selectSelenium(fileProperties);
                break;
            }
        }
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    private void selectSelenium(readProperties fileProperties) {
        Selenium selenium = new Selenium(fileProperties);
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    private void selectAppium(readProperties fileProperties) {
        Appium appium = new Appium(fileProperties);
    }

    private void deleteOldReport() {
        String rutaReports = "/target/report_cucumber/";
        String rutaProyecto = rutaProyecto();
        String rutaCompleta = rutaProyecto + rutaReports;
    }

    public void ScenarioFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            switch (tipoDriver) {
                case 0: //movil
                {
                    Appium.utilsDriver.saveScreenshotsForScenario(scenario);
                    break;
                }
                case 1: // web
                {
                    Selenium.utilsDriver.saveScreenshotsForScenario(scenario);
                    break;
                }
            }
        }
    }

    public void ScenarioEnd() {
        switch (tipoDriver) {
            case 0: //movil
            {
                Appium.utilsDriver.quit();
                break;
            }
            case 1: // web
            {
                Selenium.utilsDriver.quit();
                break;
            }
        }
    }

    public static String rutaProyecto() {
        String rutaProyecto = null;
        try {
            rutaProyecto = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutaProyecto;
    }

    public static void deleteDirectory(String rutaCompleta) {
        File f = new File(rutaCompleta);
        if (f.delete())
            printMsg("The directory " + f.toString() + " has been deleted");
        else
            printMsg("The directory " + f.toString() + " not has been deleted");
    }

    public static void createDirectory(String rutaCompleta) {
        File f = new File(rutaCompleta);
        if (!f.exists()) {
            if (f.mkdir()) {
                printMsg("The directory \n" + f.toString() + "\n has been created");
            } else {
                printMsg("The directory \n" + f.toString() + "\n not has been created");
            }
        }
    }

    public static void printError(String headerErrorText, String bodyErrorText) {
        throw new NullPointerException(
                "\n================================================\n"
                        + headerErrorText +
                        "\n================================================\n"
                        + bodyErrorText
        );
    }

    public static void printMsg(String texto) {
        System.out.println("================================================");
        System.out.println(texto);
        System.out.println("================================================");
    }
}

