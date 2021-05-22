package Basico.Clase9.Ejercicio;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ejercicio14 {
    //Ejercicio 14
    //Crear un método de test llamado sendKeysToFacebook
    //Ir a Facebook https://www.facebook.com/
    //Completar el email y contraseña con los datos: test@test.com y holamundo
    //respectivamente
    //Hacer click en login
    //Validar que se despliegue un mensaje de error
    @Test
    public void sendKeysToFacebook(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        //como se que los Id's son esos?
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("holamundo");
        driver.findElement(By.id("loginbutton")).click();

        driver.quit();

    }
}
