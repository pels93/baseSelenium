Feature: navegar google

  @web @google
  Scenario Outline: El navegador busca <sitios>
    Given Encender el navegador
    When  Ir a <irA>
    And   Buscar por <sitios>
    Then  Comprobar que lleva a <sitioDestino>


    Examples:
      | sitios          | irA                 | sitioDestino             |
      | "starfriend.es" | "https://google.es" | "https://starfriend.es/" |
      | "marca.com"     | "https://google.es" | "https://www.marca.com/" |
