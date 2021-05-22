package Basico.Clase9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrimerTest {


    @Test
    public void primerTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        String BaseUrl = "http://www.spotify.com";
        driver.get(BaseUrl);

        System.out.println(driver.getTitle()); //toma el titulo de la pagina

        String url = driver.getCurrentUrl(); //trae la url
        System.out.println("la url actual es " + url); // muestra url actual

        // driver.close(); // cierra la pagina automaticamente

    }
}
