package Examen;

import Clase16.DataFactoryFaker.DataFactoryFaker;
import SimulacroExamen.DataProviderBooking;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prueba_netflix {
    String nombre = "";
    String password = "";

    public Prueba_netflix(String unNombre, String unaPassword){
        this.nombre = unNombre;
        this.password = unaPassword;

    }
    public Prueba_netflix(){

    }
    public static final String NETFLIX_URL = "https://www.netflix.com/";
    public static Faker FAKER = new Faker();

    public WebDriver driver;

    @BeforeMethod(groups = { "NetflixTest" })
    public void setNetflixUrl(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(NETFLIX_URL);
        driver.manage().window().maximize();
    }
    @Test(groups = { "NetflixTest" },priority = 6)
    public void validarTituloTest(){

        String titulo = driver.getTitle();
        System.out.println(titulo);

        Assert.assertEquals(titulo,"Netflix Argentina: Ve series online, ve películas online");


    }
    @Test(groups = { "NetflixTest" },priority = 5)
    public void iniciarSesionPageTest(){
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        String tituloInicioSesion = driver.getTitle();
        System.out.println(">>> " + tituloInicioSesion);

        Assert.assertEquals(tituloInicioSesion,"Netflix");
        Assert.assertFalse(tituloInicioSesion.contains("Netflix Argentina: Ve series online, ve películas online"));

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));

        boolean textFound = false;
        for (WebElement unalistaDeH1s : listaDeH1s){
            String h1Text = unalistaDeH1s.getText();
            System.out.println(">>> " + h1Text);

            if(h1Text.contains("Inicia sesión")){
                textFound = true;

            }

        }

        Assert.assertTrue(textFound);

        WebElement iniciaSesionConFb = driver.findElement(By.className("fbBtnText"));
        String iniciaSesionConFbText = iniciaSesionConFb.getText();
        System.out.println(">>> " + iniciaSesionConFbText);

        Assert.assertEquals(iniciaSesionConFbText,"Iniciar sesión con Facebook");
    }
    @Test(groups = { "NetflixTest" },priority = 4)
    public void loginToNetflixErrorTest(){
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        /*
            El ejercicio indica que hay que completar el email con XXX y el error de "Contraseña incorrecta no se presenta
            en la imagen aparece test@test.com y voy a ir con ese.
            Tambien para que la factory tenga sentido cree un if indicando que si se ejecuta desde el test de manera unitaria
            nombre y password van a ser iguales a vacio entonces se va a ejecutar el mailinvalido y la pass "hola mundo"
            si se ejecuta desde la fabria nombre y password pasan a tener valor y se van a incluir en los test, pero
            no va a estar el cartel de contraseña incorrecta.

         */


        if (nombre.equals("") || password.equals("")){
            //con esto puedo ejecutarlo desde la clase, sino desde NetflixFactory
            String unMailInvalido = "test@test.com";
            String unaPassword = "holamundo";
            driver.findElement(By.id("id_userLoginId")).sendKeys(unMailInvalido);
            driver.findElement(By.id("id_password")).sendKeys(unaPassword);


        }else{
            driver.findElement(By.id("id_userLoginId")).sendKeys(nombre);
            driver.findElement(By.id("id_password")).sendKeys(password);

        }


        driver.findElement(By.xpath("//*[contains(text(),'Recuérdame')]")).click();


        driver.findElement(By.xpath("//*[contains(text(),'Iniciar sesión')]")).click();

        WebElement passIncorrectaErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Contraseña incorrecta')]"));
        String passIncorrectaErrMsgText = passIncorrectaErrMsg.getText();

        System.out.println(">>> " + passIncorrectaErrMsgText);
        Assert.assertEquals(passIncorrectaErrMsgText,"Contraseña incorrecta.");

        WebElement rememberMeChecK = driver.findElement(By.id("bxid_rememberMe_true"));

        Assert.assertTrue(rememberMeChecK.isSelected());

        if (rememberMeChecK.isSelected() == true){
            System.out.println("Recuerdame está seleccionado");

        }

    }
    @Test(groups = { "NetflixTest" },priority = 3)
    public void fakeEmailTest() throws InterruptedException {
        String email = FAKER.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //Le agrego un sleep porque sino hace el assert demasiado rapido y me dice que la pagina todavia es la landingpage
        Thread.sleep(3000);

        String urlComienzaYa = driver.getCurrentUrl();
        System.out.println(">>> " + urlComienzaYa);

        Assert.assertTrue(urlComienzaYa.contains("signup"));

    }
    @Test(dataProvider = "forInicioSesionTest",dataProviderClass = DataProviderNetfilx.class,
            groups = { "NetflixTest" },priority = 2)
    public void dataProviderEmailTest(String unEmail){
        //el ejercicio plantea ingrear "iniciar sesion y completar el campo mail y luego hago click en Comenzar ya
        // pero no tengo esa opcion, o clickeo en inicio sesion o clickeo en comenzar ya, iniciar sesion no tiene
        //un boton comenzar ya. Voy a hacer un dataprovider con mails validos y que clickeen en comenzar ya
        driver.findElement(By.name("email")).sendKeys(unEmail);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }
    @Test(groups = { "NetflixTest" },priority = 1)
    @Parameters({"tag_name"})
    public void printTagTest(@Optional("h1") String tagName) {
        List<WebElement> elementos = driver.findElements(By.tagName(tagName));

        if (tagName.equalsIgnoreCase("h1")) {
            System.out.println("Se mostraran los H1");

        }
        if (elementos.size() < 0){
            System.out.println("No se encontraron elementos");

        }else{
            for (WebElement e : elementos){
                System.out.println(e.getText());
            }
        }
    }
    @AfterMethod(groups = { "NetflixTest" })
    public void tearDown(){
       driver.close();

    }
}
