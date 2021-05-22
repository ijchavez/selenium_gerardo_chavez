package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ejercicio3 {
    //Ejercicio 3
    //Crear un método llamado bbcMundo
    //Ingresar al sitio https://www.bbc.com/mundo
    //Mostrar la cantidad de <h1> y de párrafos que hay en el sitio
    //Mostrar la cantidad de <h2>
    //Imprimir 3 títulos <h2>
    //Mostrar la cantidad de <h3> y de párrafos que hay en el sitio
    //Imprimir 3 títulos <h3>
    //Maximizar la página
    //Refrescarla

    @Test
    public void bbcMundo() {

        String BaseURL = "https://www.bbc.com/mundo";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);
        String unaURL = driver.getCurrentUrl();

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de elementos H1 es " + listaDeH1s.size());

        for (WebElement element : listaDeH1s) {
            System.out.println(element.getText());

        }
        System.out.println("*********");
        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de elementos H2 es " + listaDeH2s.size());

        for (WebElement elementH2 : listaDeH2s) {
            System.out.println(elementH2.getText());

        }

        System.out.println("*********");

        List<WebElement> listaDeH3s = driver.findElements(By.tagName("h3"));
        System.out.println("La cantidad de elementos H3 es " + listaDeH3s.size());

        for (WebElement elementH3 : listaDeH3s) {
            System.out.println(elementH3.getText());
            //MOSTRAR 3
            for (int i = 0; i < 3; i++){
                System.out.println("La cantidad de elementos H3 es " + listaDeH3s.size());
            }

        }

        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("La cantidad de parrafos es " + listaParrafos.size());

        for (WebElement element : listaParrafos){
            System.out.println("Parrafo: " + element.getText());

        }
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }

}