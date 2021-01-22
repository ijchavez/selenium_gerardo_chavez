package Clase15.TelefonicaTest;

import Clase15.TelefonicaPageObject.TelefonicaIframeBolsa;
import Clase15.TelefonicaPageObject.TelefonicaLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelefonicaTest {
    WebDriver driver;
    public static final String TELEFONICA_URL = "https://www.telefonica.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(TELEFONICA_URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void telefonicaTest() throws InterruptedException {

        TelefonicaLandingPage telefonicaLandingPage = new TelefonicaLandingPage(driver);

        String titulo = telefonicaLandingPage.telefonicaPageTitle();
        String url = telefonicaLandingPage.telefonicaCurrentUrl();
        System.out.println(titulo);
        System.out.println(url);

        Assert.assertEquals(titulo, "Telefónica");
        Assert.assertEquals(url, "https://www.telefonica.com/es/home");

        TelefonicaIframeBolsa telefonicaIframeBolsa = telefonicaLandingPage.clickPruebaGratuitaBtn();

        //Iframes
        telefonicaIframeBolsa.telefonicaIframeCotizaciones();


        telefonicaIframeBolsa.elementoTabsfind();
        Assert.assertEquals(telefonicaIframeBolsa.elementoTabsfind().size(), 2);

        for (WebElement elemTab : telefonicaIframeBolsa.elementoTabsfind()){
            String elemText = elemTab.getText();
            System.out.println(">>> " + elemText);

            if (elemText.equals("NYSE")){
                elemTab.click();

            }

        }

        telefonicaIframeBolsa.activeTabsfind();
        String activeTabText = telefonicaIframeBolsa.activeTabsfind().getText();

        Assert.assertEquals(activeTabText, "NYSE");

        Thread.sleep(10000);

        telefonicaIframeBolsa.elementoDataItemsfind();
        telefonicaIframeBolsa.elementoDataValuesfind();

        for (WebElement elemdatait : telefonicaIframeBolsa.elementoDataItemsfind()) {
            String elemdataitText = elemdatait.getText();
            if(elemdataitText.isEmpty() == false) {
                System.out.println(">>> " + elemdataitText);

            }

        }

        for (WebElement elemdataval : telefonicaIframeBolsa.elementoDataValuesfind()) {
            String elemdatavalText = elemdataval.getText();
            if(elemdatavalText.isEmpty() == false) {
                //Probe de crear una lista con los no vacios asi me traia tres y hacer el assert con 3 en vez de 6
                //List lista = new ArrayList();
                //lista.add(elemdatavalText);
                System.out.println(">>> " + elemdatavalText);
                //System.out.println(lista);
            }

        }
        // hay alguna manera de acortar el telefonicaIframeBolsa.elementoDataItemsfind() ?
        Assert.assertEquals(telefonicaIframeBolsa.elementoDataItemsfind().size(), 6);
        Assert.assertEquals(telefonicaIframeBolsa.elementoDataValuesfind().size(), 6);

    }

    @AfterTest
    public void closeDriver(){
        //driver.close();

    }

}
