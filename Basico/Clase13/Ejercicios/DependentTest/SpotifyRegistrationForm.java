package Basico.Clase13.Ejercicios.DependentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpotifyRegistrationForm {
    WebDriver driver;

    public SpotifyRegistrationForm(WebDriver remoteDriver){

        driver = remoteDriver;

    }
    public void registrationFillingForm(String mail, String mailconfirm, String password, String nombreperf){
        driver.findElement(By.id("email")).sendKeys(mail);
        driver.findElement(By.id("confirm")).sendKeys(mailconfirm);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("displayname")).sendKeys(nombreperf);

        setBirthDates(driver,"29","Junio","1986");
        //no funciono el xpath //*[@name='gender'][@value='male'] pero si lo encuentro desde la inspeccion
        driver.findElement(By.xpath("//*[contains(text(),'Hombre')]")).click();


    }
    public void setBirthDates(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.id("day")).sendKeys(unDia);

        WebElement elementoMeses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.id("year")).sendKeys(unAño);

    }



}
