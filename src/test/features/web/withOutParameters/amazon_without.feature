Feature: Amazon

  Background:
    Given Encender el navegador
    And El navegador introduce la URL "https://google.es"
    And Se visualiza la pagina de busqueda de google
    And Buscar en google por "amazon.es"
    And Seleccionar el primer resultado en google
    And Comprobar que lleva a "https://www.amazon.es/"


  @without
  Scenario: El navegador busca en amazon patatas
    When Buscar por amazon patatas
    And  Seleccionar el primer resultado
    And  Se visualiza la pagina del producto
    And  Se add a la cesta
    And  Si salta oferta se cierra
    Then El total de productos es uno





