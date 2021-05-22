package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio6 {
    //Ejercicio 6
    //Crear un método de test llamado birthdateTest
    //Ir a Facebook https://www.facebook.com/
    //Setear la fecha de nacimiento para el 20 de diciembre de 1990

    @Test
    public void birthdateTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select comboDias = new Select(elementoDias);
        comboDias.selectByVisibleText("20");

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText("oct");

        WebElement elementoAños = driver.findElement(By.id("year"));
        Select comboAños = new Select(elementoAños);
        comboAños.selectByVisibleText("1990");

    }

}
