package Basico.Clase9.Ejercicio;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Ejercicio1 {
    //Ejercicio 1
    //Crear un método que abra el browser y muestre el explorador de google con chrome
    @Test

    public void muestraGoogle(){

        String URL = "https://www.google.com";
        WebDriver driver = seleniumUtils.getUrlDriver(URL);
        String unaURL = driver.getCurrentUrl(); //la funcion reemplaza al "driver." y en este caso toma la url actual

        System.out.println("La pagina solicitada es " + unaURL);


    }
}
