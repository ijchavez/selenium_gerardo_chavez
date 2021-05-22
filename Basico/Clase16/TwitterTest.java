package Basico.Clase16;

import Basico.Clase16.DataFactoryFaker.DataFactoryFaker;
import Basico.Clase16.pageObject.Twitter.TwitterLandingPage;
import Basico.Clase16.pageObject.Twitter.TwitterRegistrationForm;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TwitterTest extends BaseTest{

    String nombre = "";
    String telefono = "";

    public TwitterTest(String unNombre, String unTelefono){
        this.nombre = unNombre;
        this.telefono = unTelefono;

    }
    public TwitterTest(){

    }

    public static final String TWITTER_URL = "https://twitter.com/?lang=es";

    @BeforeMethod
    public void setTwitterUrl(){
        driver.get(TWITTER_URL);

    }
    @Test
    public void twitterRegistrationTest() throws InterruptedException {
        BaseUITest baseUITest = new BaseUITest(driver);

        String titulo = baseUITest.getTitle();
        System.out.println(">>> " + titulo);

        String url = baseUITest.getCurrentUrl();
        System.out.println(">>> " + url);

        Assert.assertEquals(titulo,"");
        Assert.assertEquals(url,"https://twitter.com/?lang=es");

        TwitterLandingPage twitterLandingPage = new TwitterLandingPage(driver);
        TwitterRegistrationForm twitterRegistrationForm = twitterLandingPage.clickRegisterBtn();

        if (nombre.equals("") || telefono.equals("")){
            //con esto puedo ejecutarlo desde la clase, sino desde TwitterFactory
            String unNombre = DataFactoryFaker.getFirstName();
            String unTelefono = DataFactoryFaker.getCellPhone();

            twitterRegistrationForm.fillingForm(unNombre,unTelefono);

        }else{
            twitterRegistrationForm.fillingForm(nombre,telefono);

        }


        WebElement validTelErrMgs = twitterRegistrationForm.getValidPhoneErrMst();
        String validTelErrMsgText = validTelErrMgs.getText();

        Assert.assertEquals(validTelErrMsgText,"Introduce un número de teléfono válido.");

    }


}
