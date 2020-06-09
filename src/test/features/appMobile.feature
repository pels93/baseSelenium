Feature: Mobile

  Background:
    Given AppMobile Cerrar Popup

  @mobile
  Scenario Outline: <tipo_operacion> con la calculadora
    When Cuando presione el numero <numero1>
    And presione el operador <operacion> para hacer una <tipo_operacion>
    And Cuando presione el numero <numero2>
    And presione el boton =
    Then El resultado tiene que ser <resultado>

    Examples:
      | numero1 | numero2 | operacion | tipo_operacion   | resultado |
      | "1.02"  | "1"     | "+"       | "suma"           | "2,02"    |
      | "1"     | "2"     | "-"       | "resta"          | "-1"      |
      | "3"     | "4"     | "*"       | "multiplicacion" | "12"      |
      | "12"    | "4"     | "/"       | "division"       | "3"       |



