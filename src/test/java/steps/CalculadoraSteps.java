package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.winium.WiniumDriver;
import page.Calculadora;
import utils.FuncionesAuxiliares;
import utils.WiniumDriverManager;

import java.io.IOException;

public class CalculadoraSteps {

    private  WiniumDriver winiumDriver = WiniumDriverManager.runDriver();
    private Calculadora calculadora;
    private FuncionesAuxiliares funcionesAuxiliares = new FuncionesAuxiliares();

    @Given("que estoy en la calculadora, selecciono {string}")
    public void que_estoy_en_la_calculadora_selecciono(String cinco) throws IOException {

        calculadora = new Calculadora();

        //funcionesAuxiliares.click(winiumDriver,calculadora.cinco,10);
        //funcionesAuxiliares.atajoTeclas("CTRL","V");
        funcionesAuxiliares.escribirTexto("123");
        funcionesAuxiliares.capturarYAdjuntar(winiumDriver);
    }
    @Given("presiono {string}")
    public void presiono(String mas) {
        calculadora.clickByName(winiumDriver,mas);
    }
    @Given("presiono el numero {string}")
    public void presiono_el_numero(String seis) {
        calculadora.clickByName(winiumDriver,seis);
    }
    @Given("presiono el signo {string}")
    public void presiono_el_signo(String igual) {
        calculadora.clickByName(winiumDriver,igual);
    }

    @Then("se muestra el resultado")
    public void se_muestra_el_resultado() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
