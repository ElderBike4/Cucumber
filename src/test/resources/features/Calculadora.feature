Feature: Calculadora

  @calculadora
  Scenario: Suma de 2 numeros
    Given que estoy en la calculadora, selecciono "Cinco"
    And presiono "Más"
    And presiono el numero "Seis"
    And presiono el signo "Es igual a"
    Then se muestra el resultado
