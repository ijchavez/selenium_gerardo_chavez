package Basico.Clase9.Ejercicio;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio9 {
    public static WebDriver getDriver(String unaURL) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver = new ChromeDriver();
        driver.get(unaURL);

        return driver;
    }
    //el get properties no lo puedo utilizar ¿?
}
