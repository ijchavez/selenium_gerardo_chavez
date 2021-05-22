package Basico.Clase14.DataProviderEjercicios;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookTest {
    WebDriver driver;
    public static final String FACEBOOK_URL = "https://www.facebook.com/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(FACEBOOK_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (dataProvider = "paises", dataProviderClass = DataProviderFactory.class)
    public void testOfDataProviders(String capital, String pais){
        //no tiene que ver con facebook, es solo para mostrar el dataprovider
        System.out.println("La capital de " + pais + " es " + capital);

    }
    @Test(dataProvider = "loginData", dataProviderClass = DataProviderFactory.class)
    public void registrationTest(String name, String lastName, String city, int phone){
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.shopify.com/");
        //driver.findElement(By.xpath("(//*[@data-ga-event='homepage'])[1]")).click();

        //WebElement titleH2 = driver.findElement(By.id("ModalTitle"));
        //String theTitleH2 = titleH2.getText();
        //Assert.assertEquals(theTitleH2,"Start your free 14-day trial of Shopify");
        // a modo de muestra

        System.out.println(name + " " + lastName + " " + city + " " + phone);

        //driver.findElement(By.name("signup[email]")).sendKeys(name);
        //driver.findElement(By.name("signup[password]")).sendKeys(lastName);
        //driver.findElement(By.name("button")).click();
        //driver.close();

    }
    @Test(dataProvider = "emails", dataProviderClass = DataProviderFactory.class)
    public void facebookTest(String anEmail, String status) {
        if(status.equals("valid")){
            //localizo el mensaje de exito, agrego un assert
            System.out.println("El mail es correcto: " + anEmail);
        }
        if(status.equals("invalid")){
            //localizo el mensaje de error, agrego un assert para encontrar el mensaje invalido
            System.out.println("El mail es incorrecto: " + anEmail);

        }

    }
    @Test
    public void facebookTest(){
        Faker faker_data = new Faker();
        String name = faker_data.name().firstName();
        String lastName = faker_data.name().lastName();
        String email = faker_data.internet().emailAddress();

        System.out.println("--> " + name + " " +  lastName + " " + email);
        //no hace falta este campo en la explicacion va directo al mail de la pagina inicial
        //driver.findElement(By.xpath("//*[@ajaxify='/reg/spotlight/']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("email")). sendKeys(email);

    }



}
