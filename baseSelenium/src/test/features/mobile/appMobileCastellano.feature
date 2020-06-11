# language: es
Característica:Feature de movil en castellano

  Antecedentes:
    Dada AppMobile Cerrar Popup
    Y Comprobar fecha

  @mobile
  Escenario: validacion del teclado
    Cuando comprueba todos los botones
    Y presione el numero "1234567890.1234"
    Entonces el resultado tiene que ser "1234567890.1234"

  Esquema del escenario: <tipo_operacion> con la calculadora
    Cuando presione el numero <numero1>
    Y presione el operador <operacion> para hacer una <tipo_operacion>
    Y presione el numero <numero2>
    Y presione el boton =
    Entonces el resultado tiene que ser <resultado>

    Ejemplos:
      | numero1 | numero2 | operacion | tipo_operacion   | resultado |
      | "1.02"  | "1"     | "+"       | "suma"           | "2,02"    |
      | "1"     | "2"     | "-"       | "resta"          | "-1"      |
      | "3"     | "4"     | "*"       | "multiplicacion" | "12"      |
      | "12"    | "4"     | "/"       | "division"       | "3"       |