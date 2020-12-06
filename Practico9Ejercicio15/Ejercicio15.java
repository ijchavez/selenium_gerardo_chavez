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

        List<WebElement> elemH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> elemH2 = driver.findElements(By.tagName("h2"));
        List<WebElement> elemH3 = driver.findElements(By.tagName("h3"));

        /*
        System.out.println(elemH1.size());
        System.out.println(elemH2.size());
        System.out.println(elemH3.size());

        */
        if (elemH1.size() > elemH2.size() && elemH1.size() > elemH3.size()) {
            System.out.println("*****Elementos H1*****");
            for (WebElement element : elemH1) {
                System.out.println(element.getText());

            }
        }else if (elemH2.size() > elemH1.size() && elemH2.size() > elemH3.size()) {
            System.out.println("*****Elementos H2*****");
            for (WebElement element1 : elemH2) {
                System.out.println(element1.getText());

            }

        }else{
            System.out.println("*****Elementos H3*****");
            for(WebElement element2 : elemH3){
                System.out.println((element2.getText()));

            }

        }
        driver.navigate().refresh();

        List<WebElement> button = driver.findElements(By.tagName("button"));
        for (WebElement elementb : button){
            System.out.println(elementb.getText());

        }

        driver.manage().window().maximize();

        List<WebElement> div = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + div.size());

        String titulo = driver.getTitle();
        System.out.println("El titulo de la pagina es: " + titulo);

        List<WebElement> input = driver.findElements(By.tagName("input"));
        System.out.println("La cantidad de elementos input es: " + input.size());

        List<WebElement> link = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de elementos link es: " + link.size());

        List<Integer> maximo = new ArrayList<Integer>();

        maximo.add(elemH1.size());
        maximo.add(elemH2.size());
        maximo.add(elemH3.size());
        maximo.add(button.size());
        maximo.add(div.size());
        maximo.add(input.size());
        maximo.add(link.size());
        int max = 0;
        for(int i = 0; i < maximo.size(); i++){
            if(maximo.get(i)> max){
                max = maximo.get(i);

            }
        }
        System.out.println("El elemento que mas se repite es " + max);
        // verificacion System.out.println(maximo);

        driver.quit();
    }

}
