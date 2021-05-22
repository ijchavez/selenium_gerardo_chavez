package Basico.Clase11;
import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio3 {
    @Test
    public void spotifyByNameTest(){
        String BaseURL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("uncorreo@electronico.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys("uncorreo@electronico.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("unaPassword");
        driver.findElement(By.xpath("//*[@name='displayname']")).sendKeys("unNombre");

        setBirthdateSpotify(driver,"20","Abril","1955");

        //intente con //*[@name='gender'][@value='male'] y lo encuentra el inspector, no asi selenium
        WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[6]/div[2]/label[1]/span[1]"));
        if (genderMale.isSelected() == false){

            genderMale.click();
        }

        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[9]/div/button")).click();


    }

    private void setBirthdateSpotify(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.xpath("//*[@name='day']")).sendKeys(unDia);

        WebElement elementoMeses = driver.findElement(By.xpath("//*[@name='month']"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.xpath("//*[@name='year']")).sendKeys(unAño);
    }
}
