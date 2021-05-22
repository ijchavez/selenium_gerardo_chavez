package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class Ejercicio7 {
    //Ejercicio 7
    //Crear un método de test llamado comboboxTest
    //Ir a Facebook https://www.facebook.com/
    //Obtener todos los meses disponibles por su nombre
    //Validar que la lista no esté vacía
    //Seleccionar el elemento de enero, febrero y por último marzo
    //Validar que se encuentre el elemento “Jun”
    @Test
    public void comboboxTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);

        List<WebElement> valorMeses = comboMeses.getOptions();
        Assert.assertNotEquals(valorMeses.size(),0);

        boolean mesJun = false;
        System.out.println("****Valores Disponibles en mes*****");
        for(WebElement element : valorMeses){
            System.out.println(element.getText());
            if(element.getText().contentEquals("jun")){
                mesJun = true;

            }

        }
        Assert.assertTrue(mesJun);


    }

}
