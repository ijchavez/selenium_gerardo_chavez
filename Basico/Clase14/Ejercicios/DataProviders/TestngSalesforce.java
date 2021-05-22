package Basico.Clase14.Ejercicios.DataProviders;

import org.testng.annotations.Test;

public class TestngSalesforce {

    @Test(dataProvider="personas",dataProviderClass = DataProviderSalesForce.class, groups = {"failTest"})
    public void testCrearPersonas(String nombre, Integer edad){
        System.out.println(nombre + " " + edad);

    }
    @Test(dataProvider = "paises",dataProviderClass = DataProviderSalesForce.class, groups = {"successTest"} )

    public void dataProviderPaisCapital(String capital, String pais){
        System.out.println("la capital de " + pais + " es: " + capital);

    }
    @Test(dataProvider="personasnae",dataProviderClass = DataProviderSalesForce.class)
    public void testCrearPersonasNomApeEd(String nombre, String apellido, Integer edad){
        System.out.println(nombre + " " + apellido + " " + edad);

    }

}
