package driver.typeDriver.selenium.utilsSelenium;


import driver.typeDriver.selenium.Selenium;
import driver.utilsSelectDriver.utilsSelectDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class utilsWebElements {

    private final WebDriver driver;

    public utilsWebElements() {
        this.driver = Selenium.driver;
    }

    public void assertContainText(String textoCompleto, String textoAEncontrar, boolean enableError) {
        try {
            assert (textoCompleto.contains(textoAEncontrar));
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
                throw new AssertionError(msn);
            } else {
                utilsSelectDriver.printMsg(msn);
            }
        }
    }

    public WebElement findElementById(String texto) {
        return driver.findElement(By.id(texto));
    }

    public WebElement findElementAByHref(String texto) {
        return driver.findElement(By.xpath("//a[@href='" + texto + "']"));
    }

    public WebElement findElementLinkByHref(String texto) {
        return driver.findElement(By.xpath("//link[@href='" + texto + "']"));
    }

    public WebElement findElementByName(String texto) {
        return driver.findElement(By.name(texto));
    }

    public WebElement findElementByCssSelector(String texto) {
        return driver.findElement(By.cssSelector(texto));
    }

    public List<WebElement> findElementsByCssSelector(String texto, int milliseconds) {
        Selenium.utilsDriver.waiter(5000);
        return driver.findElements(By.cssSelector(texto));
    }

    public WebElement findElementByText(String texto) {
        return driver.findElement(By.xpath("//*[text()='"+texto+"']"));
        //("//*[contains(text(), 'My Button')]")
    }

    public List<WebElement> findElementsByText(String texto) {
        return driver.findElements(By.xpath("//*[text()='"+texto+"']"));
        //("//*[contains(text(), 'My Button')]")
    }

    public WebElement findElementByHref(String texto) {
        return driver.findElement(By.xpath("//*[@href='"+texto+"']"));
    }

    public List<WebElement> findElementsByHref(String texto) {
        return driver.findElements(By.xpath("//*[@href='"+texto+"']"));
    }

    public WebElement findElementByClassName(String texto) {
        return driver.findElement(By.className(texto));
    }

    public List<WebElement> findElemenstById(String texto,int milliseconds) {
        Selenium.utilsDriver.waiter(milliseconds);
        return driver.findElements(By.id(texto));
    }

}
