package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registrationFacebookTest {
    //Ejercicio 9


    //Crear una nueva branch llamada prácticoSelenium y subir una clase llamada
    //registrationFacebookTest, con el siguiente ejercicio:
    //Crear un método de test llamado fullRegistrationTest
    //Ir a Facebook https://www.facebook.com/
    //Completar los campos de registro con los siguientes valores:
    //First Name: “John”
    //Last Name: “Smith”
    //Mobile: “5555555”
    //New Password: “123456789”
    //Birthday: Jun 26 1980
    //Gender: Male

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");

        //para usar esto IntelliJ me pide que haga una throw InterruptedExcepcion que se pone en el metodo
        //a la derecha de fullRegistrationTest()
        Thread.sleep(3000);

        driver.findElement(By.name("reg_email__")).sendKeys("555555");
        Thread.sleep(3000);

        //habia puesto esto tambien porque cuando pones un mail te pide la confirmacion pero no asi cuando es un telefono
        //driver.findElement(By.name("reg_email_confirmation__")).sendKeys("5555555");

        driver.findElement(By.id("password_step_input")).sendKeys("123456789");

        setBirthdate(driver,"26","jun","1980");

        //Tuve que hacer copy xpath porque por id cambia continuamente
        //Boton derecho >> copy full xpath sobre la siguiente parte del html:
        //<input type="radio" class="_8esa" name="sex" value="2" id="u_2_3">
        //podria haber una manera de buscar por name="sex" value="2"?
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

