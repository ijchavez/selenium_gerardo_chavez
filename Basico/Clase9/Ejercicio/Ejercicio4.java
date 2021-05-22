package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Ejercicio4 {

    @Test
    public void bbcMundoLinks() {
        //Ejercicio 4
        //Crear un método llamado bbcMundoLinks
        //Ingresar al sitio https://www.bbc.com/mundo
        //Mostrar todos los links y su texto
        //Mostrar la cantidad de párrafos del sitio
        //Maximizar la página
        //Refrescarla
        String BaseURL = "https://www.bbc.com/mundo";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);
        String unaURL = driver.getCurrentUrl();

        //links es tag name = "a"
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de links es " + listaLinks.size());

        for (WebElement element : listaLinks){
            System.out.println("Link: " + element.getText());

        }

        //parrafos es tag name = "p"
        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("La cantidad de parrafos es " + listaParrafos.size());

        for (WebElement element : listaParrafos) {
            System.out.println("Parrafo: " + element.getText());
        }

        driver.navigate().refresh();
        driver.manage().window().maximize();

    }

}
