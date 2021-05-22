package Basico.Clase16;

import Basico.Clase16.DataFactoryFaker.DataFactoryFaker;
import Basico.Clase16.pageObject.DocuSign.DocuSignLandingPage;
import Basico.Clase16.pageObject.DocuSign.DocusignRegistrationPage;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocuSignTest extends BaseTest {

    public static final String DOCUSIGN_URL = "https://www.docusign.com.es/";

    @BeforeMethod
    public void setDocusignUrl(){
        driver.get(DOCUSIGN_URL);

    }
    @Test
    public void docuSignTest(){
        DocuSignLandingPage docusignLandingPage = new DocuSignLandingPage(driver);
        BaseUITest baseUITest = new BaseUITest(driver);
        String titulo = baseUITest.getTitle();
        String url = baseUITest.getCurrentUrl();

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

        String tituloRegPage = baseUITest.getTitle();
        String urlRegPage = baseUITest.getCurrentUrl();

        System.out.println("*****Titulos y página de registración*****");
        System.out.println(">>> " + tituloRegPage);
        System.out.println(">>> " + urlRegPage);

        Assert.assertEquals(tituloRegPage,"Prueba gratuita de DocuSign");
        Assert.assertEquals(urlRegPage,"https://go.docusign.com.es/o/trial/" );

        String name = DataFactoryFaker.getFirstName();
        String lastName = DataFactoryFaker.getFirstName();
        String email = DataFactoryFaker.getEmail();

        docusignRegistrationPage.fillingRegistrationFields(name,lastName,email);

        docusignRegistrationPage.clickOnComenzarBtn();


    }

}
