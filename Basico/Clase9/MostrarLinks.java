package Basico.Clase9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MostrarLinks {
    @Test
    public void TamañoVentNavegador() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver = new ChromeDriver();

        String BaseUrl = "http://www.spotify.com";
        driver.get(BaseUrl);

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de links es " + listaLinks.size());

        for (WebElement element : listaLinks){
            System.out.println("Link: " + element.getText());

        }

    }
}

