package Basico.Clase9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ListaDeElementos {

        @Test
        public void mostrarHs() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver = new ChromeDriver();

            String BaseUrl = "http://www.spotify.com";
            driver.get(BaseUrl);

            List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
            System.out.println("La cantidad de elementos H1 es " + listaDeH1s.size());

            for (WebElement element : listaDeH1s){
                System.out.println(element.getText());

            }
            System.out.println("*********");
            List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
            System.out.println("La cantidad de elementos H2 es " + listaDeH2s.size());

            for (WebElement element : listaDeH2s){
                System.out.println(element.getText());

            }
            System.out.println("*********");
            List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
            System.out.println("La cantidad de parrafos es " + listaParrafos.size());

            for (WebElement element : listaParrafos){
                System.out.println("Parrafo: " + element.getText());

            }
        }


}