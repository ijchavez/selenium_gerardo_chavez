package Basico.Clase10;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PrimerTest {


    @Test
    public void forgotAccountTest(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);
        String titIni = driver.getTitle();

        Assert.assertEquals(BaseURL,"https://www.facebook.com");
        System.out.println("titulo: " + titIni);
        Assert.assertEquals(titIni,"Facebook - Inicia sesión o regístrate","Se esperaba otro titulo");

        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        String titOlvPass = driver.getTitle();
        System.out.println("titulo: " + titOlvPass);
        Assert.assertNotEquals(titOlvPass,"Facebook - Inicia sesión o regístrate", "Los titulos no deberian ser iguales");

        String URLOlvPass = driver.getCurrentUrl();
        Assert.assertNotEquals(URLOlvPass,BaseURL);
    }
    @Test
    public void forgotAccountPartialLinkText(){
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        System.out.println("Titulo: " + driver.getTitle());
        driver.findElement(By.partialLinkText("¿Olvidaste")).click();
        System.out.println("Titulo: " + driver.getTitle());
    }
    @Test
    public void salesforceTest() {
        String BaseURL = "https://login.salesforce.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        System.out.println("titulo: " + driver.getTitle());

        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();

        driver.findElement(By.name("username")).sendKeys("test@test.com");

    }

    @Test
    public void registrationTest() throws InterruptedException {
        String BaseURL = "https://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        //Completar Fecha de Nacimiento
        //despues va a explicar esto
        Thread.sleep(3000);

        WebElement dias = driver.findElement(By.id("day"));
        Select comboDias = new Select(dias);
        comboDias.selectByValue("25");

        WebElement meses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText("jul");



    }
}
