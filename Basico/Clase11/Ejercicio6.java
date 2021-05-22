package Basico.Clase11;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ejercicio6 {

    @Test
    public void checkBoxTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);


        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        WebElement genderMale = driver.findElement(By.xpath("//*[@name='sex'][@value='2']"));
        WebElement genderFemale = driver.findElement(By.xpath("//*[@name='sex'][@value='1']"));
        WebElement genderPersonalizado = driver.findElement(By.xpath("//*[@name='sex'][@value='-1']"));

        if (genderMale.isSelected() == false && genderFemale.isSelected() == false && genderPersonalizado.isSelected() == false ){
            System.out.println("No hay ningun genero seleccionado");

        }

        Thread.sleep(3000);

        Assert.assertTrue(genderMale.isSelected() == false);
        Assert.assertTrue(genderFemale.isSelected() == false);
        Assert.assertTrue(genderPersonalizado.isSelected() == false );

        System.out.println("Haciendo la seleccion");

        if (genderMale.isSelected() == false){
            System.out.println("Se selecciono masculino");
            genderMale.click();
        }
        Thread.sleep(3000);
        Assert.assertTrue(genderMale.isSelected());
    }
}
