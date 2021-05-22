package Basico.Clase9.Ejercicio;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Ejercicio7 {
    //Ejercicio 7
    //Crear un método llamado getWindowsSizeTest
    //Abrir el explorador con google.com
    //Obtener y mostrar el ancho y alto de la página
    //Obtener las dimensiones y mostrarla en pantalla
    //Setear un nuevo tamaño de pantalla 1024x768
    //Validar que el ancho y el alto sea el esperado
    @Test

    public void getWindowsSizeTest(){
        String URL = "https://www.google.com";
        WebDriver driver = seleniumUtils.getUrlDriver(URL);
        String title = driver.getTitle();


        int altura = driver.manage().window().getSize().getHeight();
        int ancho = driver.manage().window().getSize().getWidth();

        System.out.println("Altura: " + altura);
        System.out.println("Ancho: " + ancho);
        //estos dos Asserts verifican que no son las nuevas alturas las alturas actuales
        Assert.assertNotEquals(altura,768);
        Assert.assertNotEquals(ancho,1024);

        Dimension size = driver.manage().window().getSize();

        int nuevaAltura = 768;
        int nuevoAncho = 1024;

        driver.manage().window().setSize(new Dimension(nuevoAncho,nuevaAltura));
        //En este punto altura y ancho cambian

        altura = driver.manage().window().getSize().getHeight();
        Assert.assertEquals(nuevaAltura,altura);

        ancho = driver.manage().window().getSize().getWidth();
        Assert.assertEquals(nuevoAncho,ancho);

        System.out.println("Alto x Ancho: " + altura + " X " + ancho);

        driver.quit();
        //mostrar la resolucion porque el que esta resuelto no lo entiendo

    }

}
