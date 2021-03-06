Feature: navegar por google

  @web @google
  Scenario Outline: El navegador busca <sitios>
    Given Encender el navegador
    When  El navegador introduce la URL <url>
    And   Se visualiza la pagina de busqueda de google
    And   Buscar en google por <sitios>
    And   Seleccionar el primer resultado en google
    Then  Comprobar que lleva a <sitioDestino>

    Examples:
      | sitios          | url                 | sitioDestino             |
      | "starfriend.es" | "https://google.es" | "https://starfriend.es/" |
      | "marca.com"     | "https://google.es" | "https://www.marca.com/" |