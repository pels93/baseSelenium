package pages.mobile;

import driver.typeDriver.appium.Appium;
import io.appium.java_client.MobileElement;

import java.util.List;

public class popupPage {
  public List<MobileElement> el1 = Appium.utilsMobileElements.findElementsById("consent_dialog_no_button");
}
