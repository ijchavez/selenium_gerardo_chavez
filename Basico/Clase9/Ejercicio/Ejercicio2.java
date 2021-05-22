package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class Ejercicio2 {
        //Ejercicio 2
        //Crear un método llamado mostrarTitulo, que muestre el título del sitio web.
        @Test
        public void mostrarTitulo(){
            String URL = "https://www.google.com";
            WebDriver driver = seleniumUtils.getUrlDriver(URL);
            String title = driver.getTitle();

            System.out.println("el titulo de la pagina es " + title);
        }

}
