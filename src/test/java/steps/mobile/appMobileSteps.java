package steps.mobile;

import driver.interfacesTypeDriver.TypeTime;
import driver.typeDriver.appium.Appium;
import driver.utilsSelectDriver.utilsSelectDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.calculadoraPage;
import pages.mobile.popupPage;

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

    @And("Comprobar fecha")
    public void comprobarFecha() {
        int auxCompareDate = utilsSelectDriver.compareTime(Appium.utilsDriver.getTimeDevice(TypeTime.days),
                Appium.utilsDriver.getTimeDevice(TypeTime.mouht),
                Appium.utilsDriver.getTimeDevice(TypeTime.years),
                utilsSelectDriver.getTimeSystem(TypeTime.days),
                utilsSelectDriver.getTimeSystem(TypeTime.mouht),
                utilsSelectDriver.getTimeSystem(TypeTime.years));
        assert (auxCompareDate == 0);
    }

    @When("comprueba todos los botones")
    public void comprobarTodosLosBotones() {
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.punto, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.igual, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.suma, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.resta, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.multiplicacion, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.division, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.clear, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.AC, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.clear, false);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num0, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num1, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num2, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num3, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num4, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num5, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num6, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num7, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num8, true);
        Appium.utilsMobileElements.isDisplayOrEnable(calculadora.num9, true);
    }

    @When("presione el numero {string}")
    public void cuandoPresioneElNumeroNumero(String arg0) {

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

    @Then("el resultado tiene que ser {string}")
    public void elResutladoTieneQueSer(String arg0) {
        Appium.utilsMobileElements.longPressElement(calculadora.pantalla, 2000);
        calculadora.findResult();
        String textResult = calculadora.result.getText();
        String aux;
        //get number
        if (textResult.contains("\"")) {
            aux = textResult.substring(textResult.indexOf('\"') + 1, textResult.lastIndexOf('\"'));
        } else {
            aux = textResult.substring(textResult.indexOf('(') + 1, textResult.lastIndexOf(')'));
        }

        if (calculadora.auxpunto.isEmpty()) {
            aux = aux.replace(".", "");
        } else {
            aux = aux.replace(",", "");
        }

        Appium.utilsMobileElements.assertEqualsTextToDouble(aux, arg0, true);
    }

    @When("presione el numero {string} por teclado")
    public void cuandoPresioneElNumeroNumeroPorTeclado(String arg0) {

        String auxArg0 = arg0;
        if (calculadora.auxpunto.isEmpty()) {
            if (auxArg0.contains("."))
                auxArg0 = auxArg0.replace(".", ",");
        } else {
            if (auxArg0.contains(","))
                auxArg0 = auxArg0.replace(",", ".");
        }
        Appium.utilsMobileElements.keyboardWrite(null, auxArg0);
    }
}
