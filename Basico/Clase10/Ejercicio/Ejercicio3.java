package Basico.Clase10.Ejercicio;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ejercicio3 {
    //Ejercicio 3
    //Crear un método de test llamado customSalesforceLink
    //Acceder a: https://login.salesforce.com/
    //Hacer click en el link “Use a Custom Domain”
    //Completar el custom domain con “as”
    //Hacer click en botón Continue
    //Completar el campo de email con “test@test.com”
    public void salesforceTest() {
        String BaseURL = "https://login.salesforce.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        System.out.println("titulo: " + driver.getTitle());

        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();

        driver.findElement(By.name("username")).sendKeys("test@test.com");
    }
}
