package pages.web.amazon;

import driver.typeDriver.selenium.Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class amazonPage {

    public Select select = Selenium.utilsWebElements.findSelectorCssSelector("select#searchDropdownBox.nav-search-dropdown.searchSelect");
    public WebElement barrabusqueda = Selenium.utilsWebElements.findElementById("twotabsearchtextbox");

    public amazonPage()
    {
        List<WebElement> accept_cookies =Selenium.utilsWebElements.findElementsByCssSelector("form#sp-cc",2);
        if (accept_cookies.size()>0)
        {
            WebElement btn_accept  = Selenium.utilsWebElements.findElementByCssSelector("input#sp-cc-accept");
            btn_accept.click();
        }
    }


}
