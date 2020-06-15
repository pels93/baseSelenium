package driver.typeDriver.selenium.utilsSelenium;


import driver.typeDriver.selenium.Selenium;
import driver.utilsSelectDriver.utilsSelectDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement findElementAByHref(String Href) {
        return driver.findElement(By.xpath("//a[@href='" + Href + "']"));
    }

    public WebElement findElementByLinkHref(String LinkHref) {
        return driver.findElement(By.xpath("//link[@href='" + LinkHref + "']"));
    }

    public WebElement findElementByName(String Name) {
        return driver.findElement(By.name(Name));
    }

    public WebElement findElementByCssSelector(String CssSelector) {
        return driver.findElement(By.cssSelector(CssSelector));
    }

    public List<WebElement> findElementsByCssSelector(String CssSelector, int milliseconds) {
        Selenium.utilsDriver.waiter(5000);
        return driver.findElements(By.cssSelector(CssSelector));
    }

    public WebElement findElementByText(String text) {
        return driver.findElement(By.xpath("//*[text()='" + text + "']"));
        //("//*[contains(text(), 'My Button')]")
    }

    public List<WebElement> findElementsByText(String text) {
        return driver.findElements(By.xpath("//*[text()='" + text + "']"));
        //("//*[contains(text(), 'My Button')]")
    }

    public WebElement findElementByHref(String href) {
        return driver.findElement(By.xpath("//*[@href='" + href + "']"));
    }

    public List<WebElement> findElementsByHref(String xpath) {
        return driver.findElements(By.xpath("//*[@href='" + xpath + "']"));
    }

    public WebElement findElementByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public List<WebElement> findElementsById(String id, int milliseconds) {
        Selenium.utilsDriver.waiter(milliseconds);
        return driver.findElements(By.id(id));
    }

    public Select findSelectorCssSelector(String Css) {
        return new Select(Selenium.utilsWebElements.findElementByCssSelector(Css));
    }

    public Select findSelectorById(String id) {
        return new Select(Selenium.utilsWebElements.findElementById(id));
    }

    public void clickDouble(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element)
                .release()
                .perform();
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

}
