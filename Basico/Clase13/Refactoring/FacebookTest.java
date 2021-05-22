package Basico.Clase13.Refactoring;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FacebookTest {
    public static final String FACEBOOK_URL = "https://www.facebook.com";
    WebDriver driver;

    String nombre = "";
    String apellido = "";
    String email = "";
    String mailconfirm = "";
    String password = "";

    public FacebookTest(){

    }

    public FacebookTest(String unNombre, String unApellido, String unEmail, String unMailConfirm, String unaPassword){
        nombre = unNombre;
        apellido = unApellido;
        email = unEmail;
        mailconfirm = unMailConfirm;
        password = unaPassword;
    }

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(FACEBOOK_URL);

    }

    @Test
    public void facebookRegistrationTest() throws InterruptedException {
        DriverUtilities driverUtilitiy = new DriverUtilities(driver);
        FacebookRegistrationForm registrationForm = new FacebookRegistrationForm(driver);

        System.out.println("--> " + driverUtilitiy.getTitle());

        String xpathNewAccount = "//*[@ajaxify='/reg/spotlight/']";
        driverUtilitiy.clickBtn(xpathNewAccount);
        Thread.sleep(3000);

        registrationForm.fillingForm("nombre","apellido","email@mail.com","email@mail.com", "password");
        //registrationForm.fillingForm(nombre,apellido,email,mailconfirm,password);

        String xPathReg = "(//*[@type='submit'])[2]";
        driverUtilitiy.clickBtn(xPathReg);

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();

    }
}
