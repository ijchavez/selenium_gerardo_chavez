package Basico.Clase12.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class spotifyTags {
    String URL = "https://www.spotify.com";
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);

    }
    @Test
    @Parameters({"specificTag"})
    public void spotifyRegistrationForm(@Optional("h1") String tagName){
        driver.get(URL);

        List<WebElement> elementos = driver.findElements(By.tagName(tagName));

        if (tagName.equalsIgnoreCase("h1")){
            System.out.println("Se mostraran los H1");

        }else if(tagName.equalsIgnoreCase("h2")){
            System.out.println("Se mostraran los H2");

        }else if(tagName.equalsIgnoreCase("h3")){
            System.out.println("Se mostraran los H3");
        }

        if (elementos.size() < 0){
            System.out.println("No se encontraron elementos");

        }else{
            for (WebElement e : elementos){
                System.out.println(e.getText());
            }
        }
    }
}
