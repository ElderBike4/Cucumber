package page;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import utils.WiniumDriverManager;

public class Calculadora {

    public By cinco = By.name("Cinco");
    public By calculadoraResult = By.id("CalculatorResults");

    public Calculadora(){

    }

    public void clickByName(WiniumDriver driver, String element){
        driver.findElement(By.name(element)).click();
    }
}
