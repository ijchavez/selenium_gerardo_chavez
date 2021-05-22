package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.*;

public class Ejercicio10 {
    @Test
    public void searchInGoogle(){
        String BaseURL = "https://www.google.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.cssSelector("[name='q'")).sendKeys("WebElement" + Keys.ENTER);
        //NO SE EXPLICO cssSelector
    }
}
