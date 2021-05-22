package Basico.Clase12.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestngSalesforce {
    public static final String SALESFORCE_URL = "https://login.salesforce.com/";
    public static final String SALESFORCELOCAL_URL = "https://login.salesforce.com/?locale=eu";

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);

    }
    @Test(priority = 1)
    public void validateSalesforceLogoTest(){

        WebElement salesforceLogo = driver.findElement(By.id("logo"));
        //muestro tagname de id y alt
        String tagName = salesforceLogo.getTagName();

        String alt = "alt";
        String altAttrib = salesforceLogo.getAttribute(alt);
        System.out.println(tagName + "\n" + altAttrib);

    }

    @Test (priority = 4)
    public void RememberMeIsSelectedTest() throws InterruptedException {
        driver.get(SALESFORCE_URL);

        Thread.sleep(3000);
        WebElement rememberMe = driver.findElement(By.id("rememberUn"));

        if (rememberMe.isSelected() == false){
            rememberMe.click();

        }
        Assert.assertTrue(rememberMe.isSelected(),"No está seleccionado");

    }

    @Test (priority = 2)/*(enabled = false)*/
    public void FooterIsValidTest() throws InterruptedException {
        driver.get(SALESFORCELOCAL_URL);

        Thread.sleep(3000);
        WebElement footer = driver.findElement(By.id("footer"));

        String mensAllRightRes = footer.getText();
        System.out.println(mensAllRightRes);

        Assert.assertTrue(footer.getText().contains("All rights reserved."));

    }
    /************************ Ejercicio GIT **********************/
    @Test(priority = 3)
    public void LoginFailureTest() throws InterruptedException {
        //Uso una nueva URL porque cambia una parte con respecto a https://login.salesforce.com/
        driver.get(SALESFORCELOCAL_URL);

        Thread.sleep(3000);
        WebElement salesForceLogo = driver.findElement(By.id("logo"));
        String src = "src";
        String srcAttrib = salesForceLogo.getAttribute(src);

        //imprimo el valor del atributo
        System.out.println("Valor del atributo SRC: " + srcAttrib);

        //en el HTML, el valor src="/img/logo214.svg", por eso hago un assert true a si contiene eso.
        Assert.assertTrue(srcAttrib.contains("/img/logo214.svg"));

        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("123466");

        driver.findElement(By.id("Login")).click();

        //le doy una espera de 3 seg por las dudas
        Thread.sleep(3000);
        WebElement errMessage = driver.findElement(By.id("error"));
        String mensErrMessage = errMessage.getText();

        System.out.println("Mensaje de error: " + mensErrMessage);

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}
