package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class amazonPage {

    public Select select = Selenium.utilsWebElements.findSelectorCssSelector("select#searchDropdownBox.nav-search-dropdown.searchSelect");

    public WebElement barrabusqueda = Selenium.utilsWebElements.findElementById("twotabsearchtextbox");

}