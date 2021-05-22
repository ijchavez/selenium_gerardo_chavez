package Basico.Clase14.DataProviderEjercicios;

import org.testng.annotations.Test;

public class DataProviderEjemplo1 {


    @Test (dataProvider = "datos", dataProviderClass = DataProviderFactory.class)
    //(dataProvider = "personas", dataProviderClass = DataProviderFactory.class)
    public void mostrarInfoTest(String nombre, Integer edad){
        System.out.println("Nombre: " + nombre + " y edad " + edad);
    }

}
