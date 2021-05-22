package Basico.Clase9.Ejercicio;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio8 {
    //Ejercicio 8
    //Crear un método llamado getGoogleDriver que inicialice un sitio web www.google.com. Debe
    //retornar un objeto de tipo Webdriver

    private WebDriver getGoogleDriver() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver = new ChromeDriver();
        String BaseURL = "https://www.google.com";
        driver.get(BaseURL);

        return driver;
    }
    //el ejercicio esta resuelto como private
}
