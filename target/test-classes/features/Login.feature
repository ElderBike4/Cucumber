Feature: Login

  @login
  Scenario: Resta
    Given que estoy en la calculadora, selecciono "Dos"
    And presiono "Más"
    And presiono el numero "Cuatro"
    And presiono el signo "Es igual a"
    Then se muestra el resultado
