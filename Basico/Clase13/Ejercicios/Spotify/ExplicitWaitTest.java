package Basico.Clase13.Ejercicios.Spotify;

import Basico.Clase13.Refactoring.DriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTest {

    WebDriver driver;
    public static final String SPOTIFY_URL = "https://www.spotify.com/uy/signup/";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);

    }
    private final String REG_EMAIL_ERR_MESSAGE = "Este correo electrónico " +
            "ya está conectado a una cuenta. Inicia sesión.";

    @Test
    public void SpotifyRegMailErrMessage(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        System.out.println("--> " + driverUtility.getTitle());

        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]")));

        WebElement emailErrorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        String errMessage = emailErrorMessage.getText();

        Assert.assertEquals(errMessage,REG_EMAIL_ERR_MESSAGE);

    }
    @AfterMethod
    public void closeDriver(){
       driver.close();

    }

}
