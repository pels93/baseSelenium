package driver.typeDriver.appium.utilsAppium;

import driver.typeDriver.appium.Appium;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

import java.time.Duration;
import java.util.List;

@SuppressWarnings("rawtypes")
public class utilsMobileElements {

    private final MobileDriver driver;
    private final String appPackageAndroid;
    private final AndroidDriver driverAndroid;
    private final IOSDriver driverIos;

    public utilsMobileElements(AndroidDriver driverAndroid, IOSDriver driverIos) {
        this.driver = Appium.driver;
        this.driverAndroid = driverAndroid;
        this.driverIos = driverIos;
        appPackageAndroid = Appium.utilsDriver.getAppPackage();
    }

    private String isAndroidPlatform(String texto) {
        if (Appium.platform == Platform.ANDROID) {
            texto = this.appPackageAndroid + ":id/" + texto;
        }
        return texto;
    }

    public void isDisplayOrEnable(MobileElement elements, Boolean enableError) {
        if (!enableError) {
            try {
                Assert.assertTrue(elements.isDisplayed());
            } catch (Exception e) {
                utilsSelectDriver.printMsg("WARNING -> is NOT Displayed the element " + elements);
            }
            try {
                Assert.assertTrue(elements.isEnabled());
            } catch (Exception e) {
                utilsSelectDriver.printMsg("WARNING ->  is NOT Enabled the element " + elements);
            }
        } else {
            Assert.assertTrue(elements.isDisplayed());
            Assert.assertTrue(elements.isEnabled());
        }
    }

    public void assertContainText(String textoCompleto, String textoAEncontrar, boolean enableError) {
        try {
            assert (textoCompleto.toLowerCase().contains(textoAEncontrar.toLowerCase()));
        } catch (AssertionError a) {
            String msn = "WARNING -> el texto \n" + textoAEncontrar + "\n no esta en  \n" + textoCompleto;
            if (enableError) {
                throw new AssertionError(msn);
            } else {
                utilsSelectDriver.printMsg(msn);
            }
        }
    }

    public void assertEqualsText(String textoEncotrado, String textoAEncontrar, boolean enableError) {
        try {
            Assert.assertEquals(textoEncotrado, textoAEncontrar);
        } catch (AssertionError a) {
            String msn = "WARNING -> se esperaba \n" + textoAEncontrar + "\n y ha llegado \n" + textoEncotrado;
            if (enableError) {
                utilsSelectDriver.printError("WARNING ->", a.toString());
            } else {
                utilsSelectDriver.printMsg(msn);
            }
        }
    }

    public void assertEqualsTextToDouble(String textoEncotrado, String textoAEncontrar, boolean enableError) {
        try {
            assert (Double.parseDouble(textoEncotrado.replace(',', '.')) == Double.parseDouble(textoAEncontrar.replace(',', '.')));
        } catch (AssertionError a) {
            String msn = "WARNING -> se esperaba \n" + textoAEncontrar + "\n y ha llegado \n" + textoEncotrado;
            if (enableError) {
                utilsSelectDriver.printError("WARNING ->", a.toString());
            } else {
                utilsSelectDriver.printMsg(msn);
            }
        }
    }

    public void keyboardWrite(MobileElement element, String text) {

        if (Appium.platform == Platform.IOS) {
            element.sendKeys(text);
            driverIos.getKeyboard().pressKey(text);
        } else {
            driverAndroid.getKeyboard().sendKeys(text);
        }
    }

    public void saveHideKeyboard() {
        if (Appium.platform == Platform.IOS) {
            driverIos.hideKeyboard();
        } else {
            driverAndroid.hideKeyboard();
        }
    }

    public MobileElement findElementById(String texto) {
        return (MobileElement) driver.findElement(By.id(isAndroidPlatform(texto)));
    }

    public List<MobileElement> findElementsById(String texto) {
        return (List<MobileElement>) driver.findElements(By.id(isAndroidPlatform(texto)));
    }

    public MobileElement findElementByXPath(String texto) {
        return (MobileElement) driver.findElement(By.xpath(texto));
    }

    public List<MobileElement> findElementsByXPath(String texto) {
        return (List<MobileElement>) driver.findElements(By.xpath(texto));
    }

    public MobileElement findElementByIdOrXpath(String id, String xpath) {
        MobileElement aux;
        Appium.utilsDriver.waiter(1000);
        if (findElementsById(id).size() > 0) {
            aux = findElementsById(id).get(0);
        } else {
            aux = findElementByXPath(xpath);
        }
        return aux;
    }

    public MobileElement findElementByName(String texto) {
        return (MobileElement) driver.findElement(By.xpath("//*[@name='" + texto + "']"));
    }

    public MobileElement findElementByText(String texto) {
        return (MobileElement) driver.findElement(By.xpath("//*[contains(text()='" + texto + "']"));
    }

    public MobileElement findElementByValue(String texto) {
        return (MobileElement) driver.findElement(By.xpath("//*[@value='" + texto + "']"));
    }

    public void swipe(int iniX, int iniY, int finalX, int finalY, int milliseconds) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(iniX, iniY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(milliseconds)))
                .moveTo(PointOption.point(finalX, finalY))
                .release()
                .perform();
    }

    public void longPressPosition(int iniX, int iniY, int milliseconds) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(iniX, iniY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(milliseconds)))
                .release()
                .perform();
    }

    public void longPressElement(MobileElement element, int milliseconds) {
        int iniX = element.getLocation().getX();
        int iniY = element.getLocation().getY();
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(iniX, iniY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(milliseconds)))
                .release()
                .perform();
    }

}
