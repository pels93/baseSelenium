package driver.typeDriver.appium.utilsAppium;

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

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }


}
