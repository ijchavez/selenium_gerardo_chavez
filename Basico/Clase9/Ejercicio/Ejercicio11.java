package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.*;

public class Ejercicio11 {
    //Ejercicio 11
    //Crear un método llamado searchInGoogleAndGoBack
    //Acceder a google.com
    //Imprimir el título del sitio
    //Buscar: selenium driver
    //Volver atras
    //Refrescar la página
    //Ir hacia adelante

    @Test
    public void searchinGoogleAndGoBack(){
        String BaseURL = "https://www.google.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        String pagActual = driver.getCurrentUrl();
        System.out.println("La pagina actual es: " + pagActual);

        String tituloActual = driver.getTitle();
        System.out.println("El titulo de la pagina es: " + tituloActual);

        driver.findElement(By.cssSelector("[name='q'")).sendKeys("selenium driver" + Keys.ENTER);

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }
}
