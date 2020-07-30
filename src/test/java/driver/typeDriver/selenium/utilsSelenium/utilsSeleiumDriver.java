package driver.typeDriver.selenium.utilsSelenium;

import driver.typeDriver.selenium.Selenium;
import driver.typeDriver.selenium.interfacesSelenium.WindowsSize;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class utilsSeleiumDriver {

    WebDriver driver;

    public utilsSeleiumDriver() {
        this.driver = Selenium.driver;
    }

    public void setWindowsSize(int tipo, int ancho, int alto) {
        switch (tipo) {
            case WindowsSize.oculto: // oculto
            {
                ancho = -2000;
                driver.manage().window().setPosition(new Point(ancho, alto));
                break;
            }
            case WindowsSize.dimensionado: // dimensionado
            {
                if (ancho == 0) {
                    ancho = 400;
                }
                if (alto == 0) {
                    alto = 600;
                }
                driver.manage().window().setSize(new Dimension(ancho, alto));
                break;
            }
            default: // maximizado
            {
                driver.manage().window().maximize();
                break;
            }
        }
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

    public void println(String texto) {
        System.out.println(texto);
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public void saveScreenshotsForScenario(final Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "attachment");
    }

    public String getURLPage() {
        return Selenium.driver.getCurrentUrl();
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

    public void sendKeys(Keys keys) {
       /*
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_P);
        } catch (Exception e) {
        }

        */
    }

    public void moveElementByPosition(WebElement elem) {
        int width = elem.getSize().getWidth();
        Actions act = new Actions(driver);
        act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().release().perform();
    }

    public void clickLong(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element)
                .release()
                .perform();
    }

    public void clickposition(int posX, int posY) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(posX, posY).click()
                .release()
                .perform();
    }

    public void clickButtonRight(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element)
                .release()
                .perform();
    }

    public void Scroll(int posY) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + posY + ")");
    }


    public void dragAndDropElement(WebElement element, int posX, int posY) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, posX, posY)
                .release()
                .perform();
    }

    public void dragAndDropElementToElement(WebElement element, WebElement elementFinal) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, elementFinal)
                .release()
                .perform();
    }

}
