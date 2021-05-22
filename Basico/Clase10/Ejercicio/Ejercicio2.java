package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ejercicio2 {

    //Ejercicio 2
    //Crear un método de test llamado forgotAccountPartialLinkTest
    //Ir a Facebook https://www.facebook.com/
    //Hacer click en “¿Olvidaste” utilizando el partialLink
    //Agregar un assert que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar
    //sesión | Facebook”

    @Test
    public void forgotAccountPartialLinkText(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        String titulo = driver.getTitle();
        System.out.println("Titulo: " + titulo);
        driver.findElement(By.partialLinkText("¿Olvidaste")).click();

        String tituloOlvPass = driver.getTitle();
        System.out.println("Titulo: " + tituloOlvPass);
        Assert.assertEquals("¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook",tituloOlvPass);

        driver.quit();
    }


}
