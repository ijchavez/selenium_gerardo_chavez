package Basico.Clase13.Ejercicios.DependentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependentTests {
    WebDriver driver;
    public static final String SPOTIFY_URL = "https://www.spotify.com/uy/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }
    @Test
    public void registerClickTest(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        String xPath = "//*[contains(text(),'Registrarse')]";
        driverUtility.clickBtn(xPath);

        //Verifico dentro de este metodo para ver que este correcto
        //SpotifyGetUrlTest();
        //SpotifyGetTitleTest();
        //SpotifyRegisterTest();
        //VerifyMailExistsTest();
        //VerfifyURLTitleTest();

    }
    @Test (dependsOnMethods = {"registerClickTest"})
    public void SpotifyGetUrlTest(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        String url = driverUtility.getCurrentUrl();
        System.out.println(url);

    }
    @Test  (dependsOnMethods = {"registerClickTest"})
    public void SpotifyGetTitleTest(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        String titulo = driverUtility.getTitle();
        System.out.println(titulo);

    }
    //despues de ejecutar el registerClickTest ingreso esos datos
    @Test (dependsOnMethods = {"registerClickTest"})
    public void SpotifyRegisterTest(){
        SpotifyRegistrationForm spotifyregform = new SpotifyRegistrationForm(driver);
        spotifyregform.registrationFillingForm("test@test.com","test@test.com",
                "unaPass123","unNombrePerfil");

    }
    //una vez que se ejecuto el SpotifyRegisterTest hago un test con un wait para que aparezca el cartel de
    //que existe ya uno conectado a una cuenta
    @Test (dependsOnMethods = {"SpotifyRegisterTest"})
    public void VerifyMailExistsTest(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        String xpathExist = "//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]";

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driverUtility.findTextByXpath(xpathExist)));



        WebElement emailExist = driverUtility.findTextByXpath(xpathExist);
        String errMessage = emailExist.getText();

        Assert.assertEquals(errMessage,"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }
    //pruebo que los titulos y la pagina sean correctos una ves que ejecute registerClickTest
    @Test (dependsOnMethods = {"registerClickTest"})
    public void VerfifyURLTitleTest() {
        DriverUtilities driverUtility = new DriverUtilities(driver);
        String titulo = driverUtility.getTitle();
        String url = driverUtility.getCurrentUrl();
        Assert.assertEquals("Registrarte - Spotify", titulo);
        Assert.assertEquals("https://www.spotify.com/uy/signup/", url);

    }

    @AfterMethod
    public void closeDriver(){
       // driver.close();

    }

}
