package Basico.Clase12.EjerciciosClase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class EjercicioClase {

    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("Esto es before suite");

    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Esto es before test");

    }

    @BeforeClass
    public void beforeclassTest(){
        System.out.println("Esto es before class");

    }
    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("Esto es before method");

    }

    @Test
    public void primerTest(){
        System.out.println("esto es un test");

    }
    @Test
    public void segundoTest(){
        System.out.println("esto es otro test");

    }
    @AfterMethod
    public void afterMethodTest(){
        System.out.println("Esto es after method");

    }

}
