package Basico.Clase9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class GoogleTest {
    @Test
    public void NombreUrl() {

        Scanner input = new Scanner(System.in);
        /*
        System.out.println("Ingrese nombre de la pagina");
        String URL = input.next();
        System.out.println("Ingrese Titulo");
        String titulo = input.next();
        */
        String URL = "https://www.google.com";
        String title = getUrlDriver(URL).getTitle();


        if (title.equals("Google")){
            System.out.println("Test passed!");
        }else{
            System.out.println("Test Failed");
            System.out.println(title);
        }
    }
    public WebDriver getUrlDriver(String unaURL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get(unaURL);

        return driver;

    }
}
