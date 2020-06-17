Feature: Crear cuenta de Gmail

  Background:
    Given Encender el navegador
    And   El navegador introduce la URL "https://google.es"
    And   Se visualiza la pagina de busqueda de google

  @google @gmail
  Scenario: Crear cuenta de Gmail
    When presiona en el boton iniciar sesion en google


