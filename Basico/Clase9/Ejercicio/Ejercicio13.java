package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Ejercicio13 {

    //Ejercicio 13
    //Crear un método llamado facebookPageTest
    //Abrir un navegador con facebook: https://www.facebook.com/
    //Contabilizar la cantidad de elementos div que tiene el sitio
    //Mostrar la cantidad de tipos div que existen
    //Mostrar el texto de todos los tipos anchor
    //Mostrar la cantidad de botones que tiene la página
    //Mostrar los textos de los botones que se encuentran en la página

    @Test
    public void facebookPageTest(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        List<WebElement> elementosDiv = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + elementosDiv.size());

        List<WebElement> anchor = driver.findElements(By.tagName("a"));
        System.out.println("***** Anchors *****");
        //agregado cantidad de elementos a
        System.out.println("La cantidad de elemntos a es: " + anchor.size());
        for(WebElement element : anchor){
            System.out.println("Anchors: " + element.getText());

        }

        List<WebElement> button = driver.findElements(By.tagName("button"));
        System.out.println("***** Botones *****");
        //Agregado cantidad de botones
        System.out.println("La cantidad de botones es: " + button.size());
        for (WebElement element : button){
            System.out.println("Boton: " + element.getText());

        }
        driver.quit();

    }
}
