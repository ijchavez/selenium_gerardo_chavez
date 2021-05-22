package Basico.Clase9.Ejercicio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class seleniumUtils {

    public static final String FACEBOOK_URL = "https://www.facebook.com";
    public static final String SPOTIFY_URL = "https://www.spotify.com/uy/";
    public static final String SALESFORCE_URL = "https://login.salesforce.com/";



    public static WebDriver getUrlDriver(String unaURL) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver = new ChromeDriver();
        driver.get(unaURL);

        return driver;
    }

    private void setBirthdateSpotify(WebDriver driver, String unDia, String unMes, String unAño){

        driver.findElement(By.cssSelector("*[name='day']")).sendKeys(unDia);

        //No pude hacerlo por placeholder porque no lo encontre
        WebElement elementoMeses = driver.findElement(By.cssSelector("*[name='month']"));
        Select comboMeses = new Select(elementoMeses);
        comboMeses.selectByVisibleText(unMes);

        driver.findElement(By.cssSelector("*[name='year']")).sendKeys(unAño);
    }
    private void setBirthdateFacebook(WebDriver driver, String unDia, String unMes, String unAño) throws InterruptedException {

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
