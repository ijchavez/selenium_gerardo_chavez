package Basico.Clase9.Ejercicio;

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

        List<WebElement> listaDeH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> listaDeH2 = driver.findElements(By.tagName("h2"));

        System.out.println("*****Elementos H1*****");
        for (WebElement element : listaDeH1) {
            System.out.println(element.getText());

        }
        System.out.println("*****Elementos H2*****");
        for (WebElement element : listaDeH2) {
            System.out.println(element.getText());

        }

        driver.navigate().back();

        driver.navigate().refresh();

        List<WebElement> listaDeDivs = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + listaDeDivs.size());

        String titulo = driver.getTitle();
        System.out.println("Titulo de la pagina: " + titulo);

        List<WebElement> listaDeInput = driver.findElements(By.tagName("input"));
        System.out.println("La cantidad de elementos input es: " + listaDeInput.size());

        List<WebElement> listaDeLinks = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de elementos link es: " + listaDeLinks.size());

        List<Integer> maximo = new ArrayList<Integer>();

        maximo.add(listaDeH1.size());
        maximo.add(listaDeH2.size());
        maximo.add(listaDeDivs.size());
        maximo.add(listaDeInput.size());
        maximo.add(listaDeLinks.size());

        List<String> nombreDeLista = new ArrayList<String>();

        nombreDeLista.add("Lista de H1s");
        nombreDeLista.add("Lista de H2s");
        nombreDeLista.add("Lista de Divs");
        nombreDeLista.add("Lista de Input");
        nombreDeLista.add("Lista de Links");

        int max = 0;
        String masCantidad = "";


        for(int i = 0; i < maximo.size(); i++){
            if(maximo.get(i)> max){
                max = maximo.get(i);
                masCantidad = nombreDeLista.get(i);

            }
        }

        System.out.println("El elemento que mas se repite es " + masCantidad + " con " + max + " elementos");

        /* Verificacion System.out.println(maximo);*/

        driver.quit();

    }
}
