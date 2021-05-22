package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Ejercicio12 {
    //Ejercicio 12
    //Crear un método llamado getBrowserSizes
    //Abrir un navegador con facebook
    //Imprimir el ancho y el alto del navegador
    //Maximizar la pantalla
    //Imprimir el ancho y el alto del navegador
    @Test
    public void getBrowserSizes(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        int altura = driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();

        System.out.println("Alto: " + altura);
        System.out.println("Ancho: " + ancho);

        driver.manage().window().maximize();
        System.out.println("****Maximizando...****");

        int alturaMax = driver.manage().window().getSize().getHeight();
        int anchoMax = driver.manage().window().getSize().getWidth();

        System.out.println("Alto maximizado: " + alturaMax);
        System.out.println("Ancho maximizado: " + anchoMax);

        driver.quit();
    }
}
