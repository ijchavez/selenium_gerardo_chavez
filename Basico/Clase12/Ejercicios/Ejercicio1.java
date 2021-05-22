package Basico.Clase12.Ejercicios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class Ejercicio1 {
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
    @AfterClass
    public void afterClassTest(){
        System.out.println("Esto es after class");

    }
    @AfterTest
    public void afterTest(){
        System.out.println("Esto es after test");

    }


}
