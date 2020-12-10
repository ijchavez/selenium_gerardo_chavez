package Clase9.Ejercicio;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio15 {
    //Ejercicio 15
    //********* Ejercicio GIT *********
    //Crear un método con un nombre a seleccionar
    //Acceder a Netflix: https://www.netflix.com/uy/
    //Mostrar los elementos h1, h2 o h3 que se encuentren en mayor cantidad en el sitio.
    //Refrescar la página
    //Mostrar el texto de los botones que se encuentran en la página
    //Maximizar la página
    //Mostrar la cantidad de elementos div que contiene el sitio
    //Obtener y mostrar el título de la página
    //Mostrar la cantidad de elementos de tipos input
    //Mostrar la cantidad de elementos de tipos link
    //Indicar la cantidad de elementos que más se repiten en el sitio
    @Test
    public void ej15Netflix() {
        String BaseURL = "https://www.netflix.com/uy/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        List<WebElement> listaDeH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> listaDeH2 = driver.findElements(By.tagName("h2"));
        List<WebElement> listaDeH3 = driver.findElements(By.tagName("h3"));

        /*
        System.out.println(elemH1.size());
        System.out.println(elemH2.size());
        System.out.println(elemH3.size());

        */
        if (listaDeH1.size() > listaDeH2.size() && listaDeH1.size() > listaDeH3.size()) {
            System.out.println("*****Elementos H1*****");
            for (WebElement element : listaDeH1) {
                System.out.println(element.getText());

            }
        }else if (listaDeH2.size() > listaDeH1.size() && listaDeH2.size() > listaDeH3.size()) {
            System.out.println("*****Elementos H2*****");
            for (WebElement element1 : listaDeH2) {
                System.out.println(element1.getText());

            }

        }else{
            System.out.println("*****Elementos H3*****");
            for(WebElement element2 : listaDeH3){
                System.out.println((element2.getText()));

            }

        }
        driver.navigate().refresh();

        List<WebElement> listaDeButton = driver.findElements(By.tagName("button"));
        for (WebElement elementb : listaDeButton){
            System.out.println(elementb.getText());

        }

        driver.manage().window().maximize();

        List<WebElement> listaDeDivs = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + listaDeDivs.size());

        String titulo = driver.getTitle();
        System.out.println("El titulo de la pagina es: " + titulo);

        List<WebElement> listaDeInput = driver.findElements(By.tagName("input"));
        System.out.println("La cantidad de elementos input es: " + listaDeInput.size());

        List<WebElement> listaDeLinks = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de elementos link es: " + listaDeLinks.size());

        List<Integer> maximo = new ArrayList<Integer>();
        List<List> listaDeListas = new ArrayList<>();



        maximo.add(listaDeH1.size());
        maximo.add(listaDeH2.size());
        maximo.add(listaDeH3.size());
        maximo.add(listaDeButton.size());
        maximo.add(listaDeDivs.size());
        maximo.add(listaDeInput.size());
        maximo.add(listaDeLinks.size());

        List<String> nombreDeLista = new ArrayList<String>();

        nombreDeLista.add("Lista de H1s");
        nombreDeLista.add("Lista de H2s");
        nombreDeLista.add("Lista de H3s");
        nombreDeLista.add("Lista de Buttons");
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

        System.out.println("El elemento que mas se repite es " + masCantidad + " con " +  max + " elementos");
        // verificacion System.out.println(maximo);

        driver.quit();
    }

}
