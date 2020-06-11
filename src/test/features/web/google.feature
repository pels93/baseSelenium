Feature: navegar google

  @nasa @google
  Scenario: El navegador busca "nasa"
    Given Encender el navegador
    When  El navegador introduce la URL "https://google.es"
    And   Buscar por "nasa"
    And   Seleccionar el primer resultado en google
    Then  Comprobar que lleva a "https://www.nasa.gov/"


  @web @google
  Scenario Outline: El navegador busca <sitios>
    Given Encender el navegador
    When  El navegador introduce la URL <url>
    And   Buscar por <sitios>
    And   Seleccionar el primer resultado en google
    Then  Comprobar que lleva a <sitioDestino>

    Examples:
      | sitios          | url                 | sitioDestino             |
      | "starfriend.es" | "https://google.es" | "https://starfriend.es/" |
      | "marca.com"     | "https://google.es" | "https://www.marca.com/" |