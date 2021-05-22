package Basico.Clase12.Ejercicios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class groupTests {

    String URL = "https://www.spotify.com";
    public WebDriver driver;
    @Test(groups = {"successTests","failTests"})

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);

    }
    @Test(groups = {"successTest"})
    public void successTest1(){

    }
    @Test(groups = {"successTest"})
    public void successTest2(){

    }
    @Test(groups = {"successTest"})
    public void successTest3(){

    }
    @Test( priority = 1, groups = {"failTest"})
    public void failTest1(){

    }
    @Test(groups = {"failTest"})
    public void failTest2(){

    }


}
