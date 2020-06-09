package driver.typeDriver.appium.utilsAppium;

import driver.interfacesTypeDriver.TypeTime;
import driver.typeDriver.appium.Appium;
import io.appium.java_client.MobileDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("rawtypes")
public class utilsAppiumDriver {

    private final MobileDriver driver;

    public utilsAppiumDriver() {
        this.driver = Appium.driver;
    }

    public void waiter(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "attachment");
    }

    public String getLanguageMobile() {
        return driver.getSessionDetails().get("language").toString();
    }

    public String getAppPackage() {
        return driver.getSessionDetails().get("appPackage").toString();
    }

    public void goToBack() {
        driver.navigate().back();
    }

    public void goToNext() {
        driver.navigate().back();
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }

    public Integer getTimeDevice(int selectTypeTime) {
        String it = driver.getDeviceTime();
        switch (selectTypeTime) {
            case TypeTime.days: {
                return Integer.valueOf(it.substring(it.indexOf('T') - 2, it.indexOf('T')));
            }
            case TypeTime.mouht: {
                return Integer.valueOf(it.substring(it.indexOf('-') + 1, it.indexOf('-') + 3));
            }
            case TypeTime.years: {
                return Integer.valueOf(it.substring(0, it.indexOf('-')));
            }
            case TypeTime.hours: {
                return Integer.valueOf(it.substring(it.indexOf('T') + 1, it.indexOf(':')));
            }
            case TypeTime.minutes: {
                return Integer.valueOf(it.substring(it.indexOf(':') + 1, it.indexOf(':') + 3));
            }
            default: {
                return Integer.valueOf(it.substring(it.indexOf('+') - 2, it.indexOf('+')));
            }
        }

    }


}
