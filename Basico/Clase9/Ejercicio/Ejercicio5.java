package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ejercicio5 {
    @Test
    public void bbcMundoListas(){
        //Ejercicio 5
        //Crear un método llamado bbcMundoListas
        //Ingresar al sitio https://www.bbc.com/mundo
        //Mostrar todos los elementos li y su texto
        //Mostrar la cantidad de párrafos del sitio
        //Maximizar la página
        //Refrescarla
        String BaseURL = "https://www.bbc.com/mundo";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);
        String unaURL = driver.getCurrentUrl();

        List<WebElement> listadeLis = driver.findElements(By.tagName("li"));
        System.out.println("La cantidad de li`s es " + listadeLis.size());

        for (WebElement element : listadeLis) {
            System.out.println("Li: " + element.getText());

        }

        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("La cantidad de parrafos es " + listaParrafos.size());

        for (WebElement element : listaParrafos) {
            System.out.println("Parrafo: " + element.getText());

        }

        driver.navigate().refresh();
        driver.manage().window().maximize();

    }

}
