package Basico.Clase14.Ejercicios.Fakers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CompleteSalesForceFormTest {

    WebDriver driver;
    public static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeTest(groups = {"dataProviderTest","fakeTest"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test(groups = {"dataProviderTest","fakeTest"})
    public void TestingErrorMessages() {
        driver.findElement(By.id("signup_link")).click();
        //Me aparece un boton de declaracion de aceptacion de privacidad
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("Start my free trial")).click();

    }

    @Test(dependsOnMethods = "TestingErrorMessages",
            dataProvider = "forCompleteSalesForceformTest",dataProviderClass = DataProviderSalesForce.class,
            groups = {"dataProviderTest"} )
    public void completeSalesforceFormTest(String unName, String unLastName, String unTitle,
                                           String unEmail, String unPhone, String unCompanyName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        WebElement errMesage = driver.findElement(By.xpath
                ("//*[contains(text(),'Please read and agree to the Master Subscription Agreement')]"));
        String textErrMessage = errMesage.getText();
        System.out.println(textErrMessage);
        Assert.assertEquals(textErrMessage,"Please read and agree to the Master Subscription Agreement");

        chequeoAsserts(unName,unLastName,unTitle,unEmail,unPhone,unCompanyName);
    }
    public void chequeoAsserts(String aName, String aLastName, String aTitle,
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

    }

}
