package Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio16 {
    @Test
    //Ejercicio 16
    //********* Ejercicio GIT *********
    //Acceder a Netflix: https://www.netflix.com/uy/
    //Hacer click en el botón Iniciar sesión.
    //Mostrar los elementos H1 y H2
    //Volver atras
    //Refrescar la página y mostrar los elementos div que contiene el sitio
    //Obtener y mostrar el título de la página
    //Mostrar la cantidad de elementos de tipos input
    //Mostrar la cantidad de elementos de tipos link
    //Indicar la cantidad de elementos que más se repiten en el sitio
    public void Ej16Netflix() {
        String BaseURL = "https://www.netflix.com/uy/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        //no encontre como hacerlo por ID entonces busque en el html en herramientas del desarrollador
        //y buscando el boton puse copy >>xpath, y le pegue lo que me devolvio.
        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")).click();

        List<WebElement> elemH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> elemH2 = driver.findElements(By.tagName("h2"));

        System.out.println("*****Elementos H1*****");
        for (WebElement element : elemH1) {
            System.out.println(element.getText());

        }
        System.out.println("*****Elementos H2*****");
        for (WebElement element : elemH1) {
            System.out.println(element.getText());

        }

        driver.navigate().back();

        driver.navigate().refresh();

        List<WebElement> ediv = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + ediv.size());

        String titulo = driver.getTitle();
        System.out.println("Titulo de la pagina: " + titulo);

        List<WebElement> input = driver.findElements(By.tagName("input"));
        System.out.println("La cantidad de elementos input es: " + input.size());

        List<WebElement> link = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de elementos link es: " + link.size());

        List<Integer> maximo = new ArrayList<Integer>();

        maximo.add(elemH1.size());
        maximo.add(elemH2.size());
        maximo.add(ediv.size());
        maximo.add(input.size());
        maximo.add(link.size());

        int max = 0;

        for(int i = 0; i < maximo.size(); i++){
            if(maximo.get(i)> max){
                max = maximo.get(i);

            }
        }
        System.out.println("El elemento que mas se repite es " + max);
        // Verificacion System.out.println(maximo);

        driver.quit();

    }
}
