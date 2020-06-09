package steps;

import driver.typeDriver.appium.Appium;
import driver.typeDriver.appium.interfacesAppium.mobileIdioma;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.appMobile.calculadoraPage;
import pages.appMobile.popupPage;

public class appMobileSteps {
    calculadoraPage calculadora;

    @Given("AppMobile Cerrar Popup")
    public void appmobileCerrarPopup() {
        popupPage popupPage = new popupPage();
        if (!popupPage.el1.isEmpty()) {
            popupPage.el1.get(0).click();
        }
        Appium.utilsDriver.sleep(1);
        calculadora = new calculadoraPage();
    }

    @When("Cuando presione el numero {string}")
    public void cuandoPresioneElNumeroNumero(String arg0) {

        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.punto, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num0, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num1, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num2, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num3, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num4, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num5, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num6, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num7, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num8, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num9, false);

        for (int c = 0; c < arg0.length(); c++) {
            String aux = String.valueOf(arg0.charAt(c));
            switch (aux.charAt(0)) {
                case ',':
                case '.': {
                    calculadora.punto.click();
                    break;
                }
                case '0': {
                    calculadora.num0.click();
                    break;
                }
                case '1': {
                    calculadora.num1.click();
                    break;
                }
                case '2': {
                    calculadora.num2.click();
                    break;
                }
                case '3': {
                    calculadora.num3.click();
                    break;
                }
                case '4': {
                    calculadora.num4.click();
                    break;
                }
                case '5': {
                    calculadora.num5.click();
                    break;
                }
                case '6': {
                    calculadora.num6.click();
                    break;
                }
                case '7': {
                    calculadora.num7.click();
                    break;
                }
                case '8': {
                    calculadora.num8.click();
                    break;
                }
                case '9': {
                    calculadora.num9.click();
                    break;
                }
            }
        }
    }

    @And("presione el operador {string} para hacer una {string}")
    public void presioneElOperadorOperacion(String arg0, String arg1) {
        switch (arg0.charAt(0)) {
            case '+': {
                calculadora.suma.click();
                break;
            }
            case '-': {
                calculadora.resta.click();
                break;
            }
            case '/': {
                calculadora.division.click();
                break;
            }
            case '*': {
                calculadora.multiplicacion.click();
                break;
            }
        }
    }

    @And("presione el boton =")
    public void presioneElBoton() {
        calculadora.igual.click();
    }

    @Then("El resultado tiene que ser {string}")
    public void elResutladoTieneQueSerResultado(String arg0) {
        Appium.utilsMobileElements.longPressElement(calculadora.pantalla, 2000);
        calculadora.findResult();
        String textResult = calculadora.result.getText();
        String aux;
        if (mobileIdioma.en.equals(Appium.driver.getSessionDetails().get("language").toString())) {
            aux = textResult.substring(textResult.indexOf('\"') + 1, textResult.length() - 1);
        } else {
            aux = textResult.substring(textResult.indexOf('(') + 1, textResult.length() - 1);
        }
        Appium.utilsMobileElements.assertEqualsTextToDouble(aux, arg0, true);
    }


}
