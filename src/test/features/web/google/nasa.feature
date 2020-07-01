Feature: buscar en google Nasa

  @nasa @web
  Scenario: El navegador busca "nasa"
    Given Encender el navegador
    When  El navegador introduce la URL "https://google.es"
    And   Se visualiza la pagina de busqueda de google
    And   Buscar en google por "nasa"
    And   Seleccionar el primer resultado en google
    Then  Comprobar que lleva a "https://www.nasa.gov/"