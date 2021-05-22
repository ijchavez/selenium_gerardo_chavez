package Basico.Clase9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TamañoBrowser {

    @Test
    public void TamañoVentNavegador() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

        String BaseUrl = "http://www.spotify.com";
        driver.get(BaseUrl);

        int altura = driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();

        System.out.println("Altura: " + altura);
        System.out.println("Ancho: " + ancho);

    }
}