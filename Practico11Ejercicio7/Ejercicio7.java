package Clase11;

import Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio7 {

    @Test
    public void spotifyByPlaceholder(){
        String BaseURL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("unaContraseña");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("unNombreDePerfil");

        setBirthdateSpotify(driver,"20","Abril","1955");

        //Intente con //*[@name='gender'][@value='male'] y lo encuentra el inspector, no asi selenium
        //No tiene placeholder como para usar
        WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[6]/div[2]/label[1]/span[1]"));
        if (genderMale.isSelected() == false){

            genderMale.click();
        }
        //No tiene placeholder como para usar
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[9]/div/button")).click();


    }

    private void setBirthdateSpotify(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.cssSelector("*[name='day']")).sendKeys(unDia);

        //No pude hacerlo por placeholder porque no lo encontre
        WebElement elementoMeses = driver.findElement(By.cssSelector("*[name='month']"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.cssSelector("*[name='year']")).sendKeys(unAño);
    }
}
