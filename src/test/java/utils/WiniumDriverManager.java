package utils;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WiniumDriverManager {

    private static WiniumDriver driver;

    public static WiniumDriver runDriver() {
        if (driver == null) {
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(ConfigManager.getApplicationPath()); // Obtiene la ruta de la aplicación

            try {
                // Inicializa el driver de Winium en la URL especificada
                driver = new WiniumDriver(new URL(ConfigManager.getWiniumDriverUrl()), options);
                Thread.sleep(4000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static WiniumDriver getDriver(){
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
