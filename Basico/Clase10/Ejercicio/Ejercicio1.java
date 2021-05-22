package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Ejercicio1 {
    //Ejercicio 1
    //Crear un método de test llamado forgotAccountTest
    //Ir a Facebook https://www.facebook.com/
    //Validar que el título sea “Facebook - Inicia sesión o regístrate”
    //Hacer click en ¿Olvidaste tu contraseña?
    //Validar que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar sesión |
    //Facebook”
    //Validar que la url sea diferente a “https://www.facebook.com/”

    @Test
    public void forgotAccountTest() {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);
        String titIni = driver.getTitle();


        System.out.println("titulo: " + titIni);
        Assert.assertEquals(BaseURL, "https://www.facebook.com");
        Assert.assertEquals(titIni, "Facebook - Inicia sesión o regístrate", "Se esperaba otro titulo");

        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        String titOlvPass = driver.getTitle();
        System.out.println("titulo: " + titOlvPass);
        Assert.assertEquals(titOlvPass,"¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook");
        Assert.assertNotEquals(titOlvPass, "Facebook - Inicia sesión o regístrate", "Los titulos no deberian ser iguales");

        String URLOlvPass = driver.getCurrentUrl();
        Assert.assertNotEquals(URLOlvPass, BaseURL);

        driver.quit();

    }
}