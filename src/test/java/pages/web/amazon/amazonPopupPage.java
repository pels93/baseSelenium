package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;

import java.util.List;

public class amazonPopupPage {
    public List<WebElement> add;
    public List<WebElement> notAdd;
    public List<WebElement> addSecondType;
    public List<WebElement> notSecondType;

    public amazonPopupPage() {
        add = Selenium.utilsWebElements.findElementsById("attachSiAddCoverage-announce", 1000);
        addSecondType = Selenium.utilsWebElements.findElementsByCssSelector("button#siAddCoverage-announce.a-button-text", 1000);
    }

    public void firstPopup() {
        notAdd = Selenium.utilsWebElements.findElementsByCssSelector("button#attachSiNoCoverage-announce.a-button-text", 1000);
    }

    public void secondPopup() {
        notSecondType = Selenium.utilsWebElements.findElementsByCssSelector("button#siNoCoverage-announce.a-button-text", 1000);
    }


}
