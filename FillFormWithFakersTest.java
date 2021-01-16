package Clase14.Ejercicios.Fakers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FillFormWithFakersTest {
    WebDriver driver;
    public static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void clickStartMyFreeTrial() {
        driver.findElement(By.id("signup_link")).click();
        //Me aparece un boton de declaracion de aceptacion de privacidad
        
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //hago el click en este metodo para que cuando busque el assert en el otro
        //ya el cartel exista y el assert lo encuentre.
      
        driver.findElement(By.name("Start my free trial")).click();

        //Creo un assert para no hacer un @Test sin utilidad
        String url = "https://www.salesforce.com/eu/form/signup/freetrial-sales-pe/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
    String unName = DataFactory.getFirstName();
    String unLastName = DataFactory.getLastName();
    String unTitle = DataFactory.getTitle();
    String unEmail = DataFactory.getEmail();
    String unPhone = DataFactory.getPhone();
    String unCompanyName = DataFactory.getCompanyName();
    public void fillForm(){

        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);
        driver.findElement(By.name("CompanyName")).sendKeys(unCompanyName);

        Select selEmployeeQty = new Select(driver.findElement(By.name("CompanyEmployees")));
        selEmployeeQty.selectByValue("50");

        Select selLanguage = new Select(driver.findElement(By.name("CompanyLanguage")));
        selLanguage.selectByValue("es");


    }
    @Test (dependsOnMethods = "clickStartMyFreeTrial")
    public void fillFormWithFakersTest(){

        fillForm();

        WebElement errMesage = driver.findElement(By.xpath
                ("//*[contains(text(),'Please read and agree to the Master Subscription Agreement')]"));
        String textErrMessage = errMesage.getText();
        System.out.println(textErrMessage);

        
        Assert.assertEquals(textErrMessage,"Please read and agree to the Master Subscription Agreement");

        /*No se usa ya que sale todo de la clase Faker
        chequeoAsserts(unName,unLastName,unTitle,unEmail,unPhone,unCompanyName);*/
    }

    /*public void chequeoAsserts(String aName, String aLastName, String aTitle,
                               String anEmail, String aPhone, String aCompanyName ){
        String name = "John";
        String lastName = "Smith";
        String title = "Tester";
        String email = "test@test.com";
        String phone = "1234123412";
        String cny = "FakeCny";

        Assert.assertEquals(name,aName);
        Assert.assertEquals(lastName,aLastName);
        Assert.assertEquals(title,aTitle);
        Assert.assertEquals(email,anEmail);
        Assert.assertEquals(phone,aPhone);
        Assert.assertEquals(cny,aCompanyName);

    }*/
    @AfterTest
    public void closeDriver(){
        driver.close();

    }

}
