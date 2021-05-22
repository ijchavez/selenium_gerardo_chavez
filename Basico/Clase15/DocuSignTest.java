package Basico.Clase15;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DocuSignTest {
    WebDriver driver;
    public static final String DOCUSIGN_URL = "https://www.docusign.com.es/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(DOCUSIGN_URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void docuSignTest(){
        DocuSignLandingPage docusignLandingPage = new DocuSignLandingPage(driver);

        String titulo = docusignLandingPage.docusignPageTitle();
        String url = docusignLandingPage.docusignCurrentUrl();

        System.out.println("*****Titulos y página princial*****");
        System.out.println(">>> " + titulo);
        System.out.println(">>> " + url);

        Assert.assertEquals(url,"https://www.docusign.com.es/" );
        Assert.assertEquals(titulo,"DocuSign | Líder de la industria de firma electrónica");

        /*
         Cuando cambio de pagina en realidad ya tengo que acceder a la siguiente. El metodo que hace click en el boton
         de registracion me tiene que retornar una instancia de la siguiente pagina
        */
        DocusignRegistrationPage docusignRegistrationPage = docusignLandingPage.clickPruebaGratuitaBtn();

        String tituloRegPage = docusignRegistrationPage.docusignPageTitle();
        String urlRegPage = docusignRegistrationPage.docusignCurrentUrl();

        System.out.println("*****Titulos y página de registración*****");
        System.out.println(">>> " + tituloRegPage);
        System.out.println(">>> " + urlRegPage);

        Assert.assertEquals(tituloRegPage,"Prueba gratuita de DocuSign");
        Assert.assertEquals(urlRegPage,"https://go.docusign.com.es/o/trial/" );

        docusignRegistrationPage.fillingRegistrationFields("nombre", "apellido", "test@test.com");

        docusignRegistrationPage.clickOnComenzarBtn();


    }

}
