Feature: Amazon

  Background:
    Given Encender el navegador
    When  Ir a "https://google.es"

  @web @amazon
  Scenario Outline: El navegador busca en amazon <productos>
    And   Buscar por "amazon.es"
    And   Comprobar que lleva a "https://www.amazon.es/"
    And   Buscar en amazon <productos>
    And   Seleccionar el primer resultado
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    And   Si salta oferta se cierra
    And   El producto <productos> esta en la cesta de "amazon.es"
    And   Buscar en amazon "cebolla"
    And   Seleccionar el primer resultado
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    And   El producto <productos> esta en la cesta de "amazon.es"
    Then  El total de productos es "2"


    Examples:
      | productos   |
      | "patatas"   |
      | "ajo"       |
      | "reloj"     |
      | "paño"      |
      | "camion"    |
      | "juguete"   |
      | "alambre"   |
      | "tornillos" |
      | "lampara"   |
      | "muebles"   |



