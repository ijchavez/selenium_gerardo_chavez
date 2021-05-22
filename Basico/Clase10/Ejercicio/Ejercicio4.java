package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio4 {
    //Ejercicio 4
    //Crear un método de test llamado checkBoxAndComboboxTest
    //Ir a Facebook https://www.facebook.com/
    //Hacer click en “Crear cuenta nueva”
    //
    //Consultas a seleniumcurso@gmail.com Práctico 10
    //
    //Completar el nombre con Alan
    //Completar el apellido con Smith
    //Setear el combo para seleccionar el sexo en Male
    //Completar la fecha de nacimiento con 4 de abril del 2012. Utilizar selectByValue,
    //selectByVisibleText y selectByIndex respectivamente
    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");

        Thread.sleep(3000);

        //Tuve que hacer copy xpath porque por id cambia continuamente
        //Boton derecho >> copy full xpath sobre la siguiente parte del html:
        //<input type="radio" class="_8esa" name="sex" value="2" id="u_2_3">
        //podria haber una manera de buscar por name="sex" value="2"?

        String valorXpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input";
        WebElement genderMale = driver.findElement(By.xpath(valorXpath));

        if (genderMale.isSelected() == false){

            genderMale.click();
        }

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select comboDias = new Select(elementoDias);
        comboDias.selectByValue("4");

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText("abr");

        WebElement elementoAños = driver.findElement(By.id("year"));
        Select comboAños = new Select(elementoAños);
        //Asi esta <option value="2020" selected="1">2020</option>
        //vas bajando uno a uno y contando y te da que el 2012 es el selected 9
        comboAños.selectByIndex(9);

    }


}
