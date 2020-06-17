Feature: Amazon

  Background:
    Given Encender el navegador
    And   El navegador introduce la URL "https://google.es"
    And   Se visualiza la pagina de busqueda de google
    And   Buscar en google por "amazon.es"
    And   Seleccionar el primer resultado en google
    And   Comprobar que lleva a "https://www.amazon.es/"

  @web @amazon
  Scenario Outline: El navegador busca en amazon <productos>
    When  Buscar en amazon <productos>
    And   Seleccionar el producto de la posicion "1"
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    And   Si salta oferta se cierra
    And   El producto <productos> esta en la cesta de "amazon.es"
    And   Buscar en amazon "cebolla"
    And   Seleccionar el producto de la posicion "1"
    And   Se visualiza la pagina del producto
    And   Se add a la cesta
    And   El producto <productos> esta en la cesta de "amazon.es"
    Then  El total de productos es "2"


    Examples:
      | productos         |
      | "patatas"         |
      | "ajo"             |
      | "pintura"         |



