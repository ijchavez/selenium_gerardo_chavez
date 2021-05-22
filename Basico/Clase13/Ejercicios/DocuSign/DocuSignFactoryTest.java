package Basico.Clase13.Ejercicios.DocuSign;

import Basico.Clase13.Refactoring.DriverUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocuSignFactoryTest {
    public static final String DOCUSIGN_URL = "https://go.docusign.com/o/trial/";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(DOCUSIGN_URL);

    }
    @Test
    public void getDocusignTitle(){
        DriverUtilities driverUtility = new DriverUtilities(driver);
        System.out.println("--> " + driverUtility.getTitle());

    }
    @AfterMethod
    public void closeDriver(){
        //driver.close();

    }
}
