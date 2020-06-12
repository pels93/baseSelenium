package pages.mobile;

import driver.typeDriver.appium.Appium;
import io.appium.java_client.MobileElement;

import java.util.List;

public class calculadoraPage {

    public MobileElement punto = Appium.utilsMobileElements.findElementByIdOrXpath("period",
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ImageView[25]");
    public List<MobileElement> auxpunto = Appium.utilsMobileElements.findElementsById("period");
    public MobileElement AC = Appium.utilsMobileElements.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ImageView[8]");
    public List<MobileElement> C = Appium.utilsMobileElements.findElementsById("clear");
    public MobileElement clear = Appium.utilsMobileElements.findElementById("backspace");
    public MobileElement num0 = Appium.utilsMobileElements.findElementById("n0");
    public MobileElement num1 = Appium.utilsMobileElements.findElementById("n1");
    public MobileElement num2 = Appium.utilsMobileElements.findElementById("n2");
    public MobileElement num3 = Appium.utilsMobileElements.findElementById("n3");
    public MobileElement num4 = Appium.utilsMobileElements.findElementById("n4");
    public MobileElement num5 = Appium.utilsMobileElements.findElementById("n5");
    public MobileElement num6 = Appium.utilsMobileElements.findElementById("n6");
    public MobileElement num7 = Appium.utilsMobileElements.findElementById("n7");
    public MobileElement num8 = Appium.utilsMobileElements.findElementById("n8");
    public MobileElement num9 = Appium.utilsMobileElements.findElementById("n9");
    public MobileElement suma = Appium.utilsMobileElements.findElementById("add");
    public MobileElement resta = Appium.utilsMobileElements.findElementById("subtract");
    public MobileElement division = Appium.utilsMobileElements.findElementById("divide");
    public MobileElement multiplicacion = Appium.utilsMobileElements.findElementById("multiply");
    public MobileElement igual = Appium.utilsMobileElements.findElementById("equals");
    public MobileElement pantalla = Appium.utilsMobileElements.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.HorizontalScrollView[1]/android.widget.RelativeLayout/android.widget.RelativeLayout");
    public List<MobileElement> lista = null;
    public MobileElement result = null;

    public void clear() {
        clear = Appium.utilsMobileElements.findElementById("clear");
    }

    public void findResult() {
        lista = Appium.utilsMobileElements.findElementsByXPath("*//android.widget.ListView/android.widget.LinearLayout");
        result = Appium.utilsMobileElements.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
    }

}
