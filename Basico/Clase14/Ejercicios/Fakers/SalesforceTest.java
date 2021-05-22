package Basico.Clase14.Ejercicios.Fakers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalesforceTest {
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
    public void TestingErrorMessages(){
        driver.findElement(By.id("signup_link")).click();
        //Me aparece un boton de declaracion de aceptacion de privacidad
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("Start my free trial")).click();
        //Intente por inspector encontrar por el ID pero no lo encuentra Selenium
        //WebElement webElName = driver.findElement(By.id("UserLastName-yQaf-errMsg"));

        List<WebElement> errMessList = driver.findElements(By.className("error-msg"));

        checkErrorMessages(errMessList);

    }
    public void checkErrorMessages(List<WebElement> anErrorMessList){
        Boolean fNameError = false;
        Boolean lNameError = false;
        Boolean titleError = false;
        Boolean emailAddressError = false;
        Boolean phoneError = false;
        Boolean companyNameError = false;
        Boolean numberOfEmployessError = false;
        Boolean companyLanguageError = false;

        for (WebElement element : anErrorMessList){
            String elementText = element.getText();
            System.out.println(elementText);

            if (elementText.equals("Enter your first name")){
                fNameError = true;

            }
            if (elementText.equals("Enter your last name")){
                lNameError = true;

            }
            if (elementText.equals("Enter your title")){
                titleError = true;

            }
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = true;

            }
            if (elementText.equals("Enter a valid phone number")){
                phoneError = true;

            }
            if (elementText.equals("Enter your company name")){
                companyNameError = true;

            }
            if (elementText.equals("Select the number of employees")){
                numberOfEmployessError = true;

            }
            if (elementText.equals("Select company language")){
                companyLanguageError = true;

            }


        }
        Assert.assertTrue(fNameError);
        Assert.assertTrue(lNameError);
        Assert.assertTrue(emailAddressError);
        Assert.assertTrue(titleError);
        Assert.assertTrue(phoneError);
        Assert.assertTrue(companyNameError);
        Assert.assertTrue(numberOfEmployessError);
        Assert.assertTrue(companyLanguageError);
    }

   @Test (dependsOnMethods = "TestingErrorMessages",
            dataProvider = "registerData",dataProviderClass = DataProviderSalesForce.class,
            groups = {"dataProviderTest"} )
    public void completarCampos(String unName, String unLastName, String unTitle,
            String unEmail, String unPhone){
        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> errMessList = driver.findElements(By.className("error-msg"));
        Boolean emailAddressError = true;

        for (WebElement element : errMessList) {
            String elementText = element.getText();
            System.out.println(elementText);
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = false;

            }

        }
        Assert.assertTrue(emailAddressError);

    }

    @Test (dependsOnMethods = "TestingErrorMessages", groups = {"fakeTest"} )
    public void completarCampos(){

        Faker faker_data = new Faker();

        String unName = faker_data.name().firstName();
        String unLastName = faker_data.name().lastName();
        String unTitle = faker_data.name().title();
        String unEmail = faker_data.internet().emailAddress();
        String unPhone = faker_data.phoneNumber().cellPhone();

        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> errMessList = driver.findElements(By.className("error-msg"));
        Boolean emailAddressError = false;

        for (WebElement element : errMessList) {
            String elementText = element.getText();
            System.out.println(elementText);
            if (elementText.equals("Enter a valid email address")){
                emailAddressError = true;

            }

        }
        Assert.assertFalse(emailAddressError);

    }
    @Test (dependsOnMethods = "TestingErrorMessages",
            dataProvider = "forCompleteSalesForceformTest",dataProviderClass = DataProviderSalesForce.class,
            groups = {"dataProviderTest"} )
    public void completeSalesforceFormTest(String unName, String unLastName, String unTitle,
                                String unEmail, String unPhone, String unCompanyName) {
        driver.findElement(By.name("UserFirstName")).sendKeys(unName);
        driver.findElement(By.name("UserLastName")).sendKeys(unLastName);
        driver.findElement(By.name("UserTitle")).sendKeys(unTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(unEmail);
        driver.findElement(By.name("UserPhone")).sendKeys(unPhone);
        driver.findElement(By.name("CompanyName")).sendKeys(unCompanyName);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

}
