package Basico.Clase12.EjerciciosClase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpotifyTestNG {
    String URL = "https://www.spotify.com";
    public WebDriver driver;
    @Test (priority = 0, groups = {"successTest"})
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test (priority = 0, groups = {"successTest"})
    public void verifySpotify(){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,"Escuchar es todo - Spotify");

    }
    @Test (priority = 2, groups = {"successTest"})
    public void verifySignUpUrlTest(){
     String xpath = "/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a";
     String xpathRel = "//*[@href='https://www.spotify.com/ar/signup/']";
     //driver.findElement(By.xpath(xpath)).click();
     driver.findElement(By.xpath(xpathRel)).click();
     String currentUrl = driver.getCurrentUrl();
     System.out.println(currentUrl);
     //Valida que sea cierto que la url actual contenga la palabra signup
     Assert.assertTrue(currentUrl.contains("signup"));

    }
    @Test (priority = 1, groups = {"successTest"})
    public void invalidMailTest(){
        String xpath = "/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a";
        String xpathRel = "//*[@href='https://www.spotify.com/ar/signup/']";
        //driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath(xpathRel)).click();
        driver.findElement(By.id("email")).sendKeys("test.com");
        driver.findElement(By.id("confirm")).sendKeys("test.com");

        String xpathCont = "//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]";
        WebElement emailErrorMsg = driver.findElement(By.xpath(xpathCont));
        Assert.assertEquals(emailErrorMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");


    }

    @Test (priority = 3)
    public void validatingExistingMail() throws InterruptedException {
        String xpath = "/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a";
        String xpathRel = "//*[@href='https://www.spotify.com/ar/signup/']";
        //driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath(xpathRel)).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        String xpathExist = "//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]";
        WebElement emailExist = driver.findElement(By.xpath(xpathExist));

        Thread.sleep(3000);

        String textExiEmail = emailExist.getText();
        Thread.sleep(3000);

        System.out.println("Cartel: " + textExiEmail);
        Assert.assertEquals(textExiEmail,"");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }



}
