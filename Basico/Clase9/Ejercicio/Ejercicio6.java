package Basico.Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Ejercicio6 {

    @Test

    public void getTileTest(){
        //Ejercicio 6
        //Crear un método llamado getTileTest
        //Debe inicializar Google.com
        //Validar que el título del sitio sea Google. Si lo es, debe indicar “Test Passed!!” sino, debe
        //mostrar “Test failed”.

        String URL = "https://www.google.com";
        WebDriver driver = seleniumUtils.getUrlDriver(URL); //REEMPLAZAR ESTO EN TODOS LOS EJERCICIOS ANTERIORES
        String title = driver.getTitle();


        if (title.equals("Google")){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test Failed");
            System.out.println(title);
        }

    }

}
