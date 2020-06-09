package driver.utilsSelectDriver;


import driver.interfacesTypeDriver.TypeDriver;
import driver.interfacesTypeDriver.TypeTime;
import driver.typeDriver.appium.Appium;
import driver.typeDriver.selenium.Selenium;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class utilsSelectDriver {

    private final int tipoDriver;
    public static readProperties fileProperties;

    public utilsSelectDriver() {
        //reading in RunCumcumber
        tipoDriver = fileProperties.getTypeDriver();

        switch (tipoDriver) {
            case TypeDriver.appium: {
                selectAppium(fileProperties);
                break;
            }
            case TypeDriver.selenium: {
                selectSelenium(fileProperties);
                break;
            }
        }
    }

    private void selectSelenium(readProperties fileProperties) {
        Selenium selenium = new Selenium(fileProperties);
    }

    private void selectAppium(readProperties fileProperties) {
        Appium appium = new Appium(fileProperties);
    }

    public void ScenarioFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            switch (tipoDriver) {
                case TypeDriver.appium: {
                    Appium.utilsDriver.saveScreenshotsForScenario(scenario);
                    break;
                }
                case TypeDriver.selenium: {
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

    public static String ProjectDirectory() {
        String ProjectDirectory = null;
        try {
            ProjectDirectory = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ProjectDirectory;
    }

    public static void manageDirectory(String fullDirectory, int mode) {
        File directory = new File(fullDirectory);
        switch (mode) {
            case 0: //create directory
            default: {
                if (!directory.exists()) {
                    if (directory.mkdir()) {
                        printMsg("The directory \n" + directory.toString() + "\n has been created");
                    } else {
                        printMsg("The directory \n" + directory.toString() + "\n not has been created");
                    }
                }
                break;
            }
            case 1: { //delete directory
                if (directory.exists()) {
                    try {
                        FileUtils.deleteDirectory(directory);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
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

    public static void printMsg(String text) {
        System.out.println("================================================");
        System.out.println(text);
        System.out.println("================================================");
    }

    public static Integer getTimeSystem(int selectTypeTime) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj;
        switch (selectTypeTime) {
            case TypeTime.days: {
                myFormatObj = DateTimeFormatter.ofPattern("dd");
                break;
            }
            case TypeTime.mouht: {
                myFormatObj = DateTimeFormatter.ofPattern("MM");
                break;
            }
            case TypeTime.years: {
                myFormatObj = DateTimeFormatter.ofPattern("yyyy");
                break;
            }
            case TypeTime.hours: {
                myFormatObj = DateTimeFormatter.ofPattern("HH");
                break;
            }
            case TypeTime.minutes: {
                myFormatObj = DateTimeFormatter.ofPattern("mm");
                break;
            }
            default: {
                myFormatObj = DateTimeFormatter.ofPattern("ss");
                break;
            }
        }

        String formattedDate = myDateObj.format(myFormatObj);
        return Integer.valueOf(formattedDate);

    }

    public static int compareTime(int day1, int mouht1, int year1, int day2, int mouht2, int year2) {
        Date date1 = null;
        Date date2 = null;
        int aux = 0;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(day1 + "/" + mouht1 + "/" + year1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(day2 + "/" + mouht2 + "/" + year2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 != null) {
            aux = date1.compareTo(date2);
        }
        return aux;
    }

}

