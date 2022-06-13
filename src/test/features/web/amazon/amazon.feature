Feature: Amazon

  Background:
    Given Encender el navegador
    And   El navegador introduce la URL "https://google.es"
    And   Se visualiza la pagina de busqueda de google
    And   Buscar en google por "amazon.es"
    And   Seleccionar el primer resultado en google
    And   Comprobar que lleva a "https://www.amazon.es/"

  @web @amazon
  Scenario Outline: El navegador busca en amazon <productos> & <productos2>
    When   Se visualiza la pagina de amazon
    And  Buscar en amazon <productos>
    And   Seleccionar el producto de la posicion "1"
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    And   El total de productos es "1"
    And   Buscar en amazon <productos2>
    And   Seleccionar el producto de la posicion "1"
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    Then  El total de productos es "2"



    Examples:
      | productos         | productos2 |
      | "mesita de noche" | "lampara"  |



