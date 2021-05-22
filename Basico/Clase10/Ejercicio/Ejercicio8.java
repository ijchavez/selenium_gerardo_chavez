package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio8 {
    //Ejercicio 8
    //Crear un método privado llamado setBirthdate que reciba como parámetro el driver, el dia, el
    //mes y el año. Debe setear la fecha de nacimiento de la persona que está completando el
    //formulario. Utilizar el método en la clase completeRegistration

    @Test
    public void completeRegistration() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");

        Thread.sleep(3000);

        driver.findElement(By.name("reg_email__")).sendKeys("info.gerardo.chavez@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("info.gerardo.chavez@gmail.com");

        driver.findElement(By.id("password_step_input")).sendKeys("unaPasword123");

        setBirthdate(driver,"29","jun","1986");

        String valorXpath = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input";
        WebElement genderMale = driver.findElement(By.xpath(valorXpath));

        if (genderMale.isSelected() == false){

            genderMale.click();
        }
    }

    private void setBirthdate(WebDriver driver, String unDia, String unMes, String unAño) throws InterruptedException {

        WebElement elementoDias = driver.findElement(By.id("day"));
        Select comboDias = new Select(elementoDias);
        comboDias.selectByVisibleText(unDia);

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        WebElement elementoAños = driver.findElement(By.id("year"));
        Select comboAños = new Select(elementoAños);
        comboAños.selectByVisibleText(unAño);
    }

}
