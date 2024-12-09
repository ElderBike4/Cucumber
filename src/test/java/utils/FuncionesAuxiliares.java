package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.winium.WiniumDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FuncionesAuxiliares {

    private static final Map<String, Integer> keyMap = createKeyMap();

    private static Map<String, Integer> createKeyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("ALT", KeyEvent.VK_ALT);
        map.put("F4", KeyEvent.VK_F4);
        map.put("CTRL", KeyEvent.VK_CONTROL);
        map.put("SHIFT", KeyEvent.VK_SHIFT);
        map.put("F1", KeyEvent.VK_F1);
        map.put("V",KeyEvent.VK_V);
        map.put("C",KeyEvent.VK_C);
        return map;
    }

    public void capturarYAdjuntar(WiniumDriver driver) {
        if (driver != null) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try (ByteArrayInputStream inputStream = new ByteArrayInputStream(screenshotBytes)) {
                Allure.attachment("Captura de pantalla", inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El driver no soporta capturas de pantalla.");
        }
    }

    public void click(WiniumDriver driver, By locator, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            throw new TimeoutException("El elemento no se volvió clickeable en el tiempo especificado.");
        }
    }

    public void atajoTeclas(String... keys) {
        try {
            Robot robot = new Robot();
            for (String key : keys) {
                Integer keyCode = keyMap.get(key);
                if (keyCode != null) {
                    robot.keyPress(keyCode);
                }
            }
            for (String key : keys) {
                Integer keyCode = keyMap.get(key);
                if (keyCode != null) {
                    robot.keyRelease(keyCode);
                }
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirTexto(String texto) {
        try {
            Robot robot = new Robot();
            for (char c : texto.toCharArray()) {
                int keyCode = getKeyCodeForChar(c);
                if (keyCode != -1) {
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                }
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    private int getKeyCodeForChar(char c) {
        if (Character.isUpperCase(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        } else if (Character.isLowerCase(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        } else if (Character.isDigit(c)) {
            return KeyEvent.getExtendedKeyCodeForChar(c);
        }
        return -1;
    }
}
