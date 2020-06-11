Feature: Mobile

  Background:
    Given AppMobile Cerrar Popup
    And Comprobar fecha

  @mobile
  Scenario:validacion del teclado
    When comprueba todos los botones
    And  presione el numero "1234567890.1234"
    Then el resultado tiene que ser "1234567890.1234"

  @mobile
  Scenario Outline:<tipo_operacion> con la calculadora
    When presione el numero <numero1>
    And presione el operador <operacion> para hacer una <tipo_operacion>
    And presione el numero <numero2>
    And presione el boton =
    Then el resultado tiene que ser <resultado>

    Examples:
      | numero1 | numero2 | operacion | tipo_operacion   | resultado |
      | "1.02"  | "1"     | "+"       | "suma"           | "2,02"    |
      | "1"     | "2"     | "-"       | "resta"          | "-1"      |
      | "3"     | "4"     | "*"       | "multiplicacion" | "12"      |
      | "12"    | "4"     | "/"       | "division"       | "3"       |

  @mobile
  Scenario Outline:calculadora con teclado realiza <tipo_operacion>
    When presione el numero <numero1> por teclado
    And presione el operador <operacion> para hacer una <tipo_operacion>
    And presione el numero <numero2> por teclado
    And presione el boton =
    Then el resultado tiene que ser <resultado>

    Examples:
      | numero1 | numero2 | operacion | tipo_operacion   | resultado |
      | "1.02"  | "1"     | "+"       | "suma"           | "2,02"    |
      | "1"     | "2,99"  | "-"       | "resta"          | "-1.99"   |
      | "17,31" | "4"     | "*"       | "multiplicacion" | "69.24"   |
      | "17"    | "4"     | "/"       | "division"       | "4.25"    |