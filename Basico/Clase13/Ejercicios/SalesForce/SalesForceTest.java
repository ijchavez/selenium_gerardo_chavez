package Basico.Clase13.Ejercicios.SalesForce;

import Basico.Clase13.Refactoring.DriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesForceTest {
    WebDriver driver;
    public static final String SALESFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);

    }
    @Test
    public void salesForceForgotPassword() throws InterruptedException {
        DriverUtilities driverUtility = new DriverUtilities(driver);
        System.out.println("--> " + driverUtility.getTitle());

        Thread.sleep(5000);
        driver.findElement(By.id("forgot_password_link")).click();
    }
    @AfterMethod
    public void closeDriver(){
        driver.close();

    }
}
