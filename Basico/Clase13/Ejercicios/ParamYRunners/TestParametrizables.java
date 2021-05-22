package Basico.Clase13.Ejercicios.ParamYRunners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestParametrizables {
    WebDriver driver;
    public static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);

    }
    @Test
    @Parameters({"tag_name"})
    public void pruebaConParametros(@Optional ("a") String tagName){
        List<WebElement> elementos = driver.findElements(By.tagName(tagName));

        if (tagName.equalsIgnoreCase("h1")){
            System.out.println("Se mostraran los H1");

        }else if(tagName.equalsIgnoreCase("h2")){
            System.out.println("Se mostraran los H2");

        }else if(tagName.equalsIgnoreCase("h3")){
            System.out.println("Se mostraran los H3");

        }else if(tagName.equalsIgnoreCase("a")){
        System.out.println("Se mostraran los Hiperlinks");

        }else{
            System.out.println(tagName);

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
