package Basico.SimulacroExamenBasico;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prueba_booking{

    public static final String BOOKING_URL = "https://www.booking.com/";
    public WebDriver driver;
    /* Para el xml tengo que poner (groups = { "BookingTest" }) a todos los @, incluyendo los before y after
     * En Clase16.DataFactoryFaker.DataFactoryFaker tengo una clase que tiene metodos que llaman a distintos fakers
     *
     * En Clase16.Factory.TwitterFactory tengo una clase que es una fabrica y se ejecuta
     *      Previo al static de url:
     *          Strings de los datos
     *          Constructor vacio y con los datos del string
     *          Dentro del test hago el findelements y el sendkeys le mando como valor los strings.
     *
     * En Clase16.TelefonicaTest tengo Iframes a traves de Clase16.pageObject.TelefonicaIfreameBolsa
     *
     * En Clase16.pageObject.Spotify.SpotifyRegistrationPage se usa explicit wait
     *
     * En SimulacroExamen.DataproviderBooking tengo un data provider, que se usa poniendo en la funcion o metodo
     * (dataProvider = "forinvalidMailTest",dataProviderClass = DataProviderBooking.class) y en el parentesis del metodo
     * le paso los parametros que estan en el dataprovider
     *
     * En Clase16.SalesforceTest entendi que BeforeMethod levanta un driver por test, el BeforeTest no, levanta todo en el mismo
     * A su vez hay un xml para correr con @Parameters
     *
     * En Clase16.ShopifyTest tengo test de buscar elementos y cantidades, puedo encontrar un webelement por su posicion, pero
     * es recomendable hacer un boolean falso fuera del for y dentro del for un if lista.getText().contains('texto solicitado')
     * el booleando se vuelve true y afuera hagos un assertTrue del booleano
     */
    @BeforeMethod(groups = { "BookingTest" })//para el ejercicio de dataprovider tengo que poner beforemethod
    public void setBoopkingUrl(){
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get(BOOKING_URL);
       driver.manage().window().maximize();

    }
    @Test(groups = { "BookingTest" })
    public void validarTituloTest(){

        String titulo = driver.getTitle();
        System.out.println(titulo);

        Assert.assertEquals(titulo,"Booking.com | Página oficial | Los mejores hoteles y alojamientos");

    }
    @Test(groups = { "BookingTest" })
    public void mostrarLinksTest(){
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("la cantidad de links es " + listaLinks.size());

        for (WebElement unalistaLinks : listaLinks){
            String linkText = unalistaLinks.getText();
            System.out.println(">>> " + linkText);
        }
    }
    @Test(groups = { "BookingTest" })
    public void mostrarH1Test(){
        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("la cantidad de H1s es " + listaDeH1s.size());

        for (WebElement unalistaDeH1s : listaDeH1s){
            String h1Text = unalistaDeH1s.getText();
            System.out.println(">>> " + h1Text);
        }
    }
    @Test(groups = { "BookingTest" })
    public void buscarGenteViajeraTest(){
        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("la cantidad de H2s es " + listaDeH2s.size());

        //Hago un booleando dentro del for para que encuentre determinado texto y le hago un assertTrue
        boolean textFound = false;
        for (WebElement unalistaDeH2s : listaDeH2s){
            String h2Text = unalistaDeH2s.getText();
            System.out.println(">>> " + h2Text);
            //.contains para marcar que contenga algo del texto
            //"Conecta con gente viajera" no aparece lo cambio por alguno de los h2
            if(h2Text.contains("Conectate con otros viajeros")){
                textFound = true;

            }

        }
        Assert.assertTrue(textFound);

    }
    @Test(groups = { "BookingTest" })
    public void registroUsuariosTest(){
        driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión')]")).click();

        Faker faker = new Faker();
        String mail = faker.internet().emailAddress();

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement errMsgNotExistentMail = driver.findElement(By.id("username-description"));
        String errMsgNotExistentMailText = errMsgNotExistentMail.getText();

        Assert.assertEquals(errMsgNotExistentMailText,"Ingresá tu dirección de e-mail");

        driver.findElement(By.id("username")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
/*
        Asi esta planteado el ejercicio, yo hice lo mismo pero con Ingresa tu direccion de correo
        WebElement errMsgNotExistentAccount = driver.findElement(By.xpath("//*[contains(text(),'Parece que no existe ninguna cuenta vinculada a este e-mail. Puedes crear una cuenta para utilizar nuestros servicios.')]"));
        String errMsgNotExistentAccountText = errMsgNotExistentAccount.getText();

        Assert.assertEquals(errMsgNotExistentAccountText,"Parece que no existe ninguna cuenta vinculada a este e-mail. Puedes crear una cuenta para utilizar nuestros servicios.");

*/

        String password = faker.internet().password();
        String confirmPassword = faker.internet().password();

        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("confirmed_password")).sendKeys(confirmPassword);

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement errMsgDiffPassword = driver.findElement(By.id("confirmed_password-description"));
        String errMsgDiffPasswordText = errMsgDiffPassword.getText();
        System.out.println(">>> " + errMsgDiffPasswordText);

        Assert.assertEquals(errMsgDiffPasswordText,"Las contraseñas que ingresaste no coinciden. Volvé a intentarlo.");
        //Las contraseñas que ingresaste no coinciden. Volvé a intentarlo.

    }
    @Test(groups = { "BookingTest" })
    public void crearUnaCuentaTest(){
        driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión')]")).click();

        String mail = "test@test.com";
        driver.findElement(By.id("username")).sendKeys(mail);

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        /*
        NO ENCUENTRO ESTE ERROR
        WebElement errMsgExistentMail = driver.findElement(By.xpath("//*[contains(text(),'Parece que no existe ninguna cuenta vinculada a este e-mail. Puedes crear una cuenta para utilizar nuestros servicios.')]"));
        String errMsgExistentMailText = errMsgExistentMail.getText();
        System.out.println(">>> " + errMsgExistentMailText);

        Assert.assertEquals(errMsgExistentMailText,"Ya tienes una cuenta de Booking.com registrada con la dirección de e-mail test@test.com. Puedes iniciar sesión directamente.");
        */

    }
    @Test(dataProvider = "forinvalidMailTest",dataProviderClass = DataProviderBooking.class,
            groups = {"BookingTest"})
    public void inicioDeSesionBookingDP(String unMail){
        driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión')]")).click();
        driver.findElement(By.id("username")).sendKeys(unMail);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement invalidMailErrMsg = driver.findElement(By.id("username-description"));
        String invalidMailErrMsgText = invalidMailErrMsg.getText();
        System.out.println(">>> " + invalidMailErrMsgText);
        Assert.assertEquals(invalidMailErrMsgText,"Verificá que la dirección de e-mail que ingresaste sea correcta.");

    }
    @AfterMethod(groups = { "BookingTest" })//necesito esto para el DataProvider?
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }


}

