package Basico.Clase11;

import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio4 {
    @Test
    public void spotifyByPlaceHolder(){
        String BaseURL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        //placeholder="Introduce tu correo electónico"
        driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys("uncorreo@electronico.com");
        driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("uncorreo@electronico.com");
        driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("unaContraseña");
        driver.findElement(By.xpath("//*[@placeholder='Introduce un nombre de perfil.']")).sendKeys("unNombreDePerfil");


        setBirthdateSpotify(driver,"20","Abril","1955");

        //Intente con //*[@name='gender'][@value='male'] y lo encuentra el inspector, no asi selenium
        //No tiene placeholder
        WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[6]/div[2]/label[1]/span[1]"));
        if (genderMale.isSelected() == false){

            genderMale.click();
        }
        //No tiene placeholder
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[9]/div/button")).click();


    }

    private void setBirthdateSpotify(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.xpath("//*[@placeholder='DD']")).sendKeys(unDia);

        //No pude hacerlo por placeholder porque no lo encontre
        WebElement elementoMeses = driver.findElement(By.xpath("//*[@name='month']"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.xpath("//*[@placeholder='AAAA']")).sendKeys(unAño);
    }

}
