package Basico.Clase14.Ejercicios.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderSalesForce {
    @DataProvider(name="personas")
    public Object[][] crearPersonas() {
        return new Object[][]{
                {"Juan", 29},
                {"Maria", 22},

        };

    }
    @DataProvider (name="paises")
    public Object[][] ciudades() {
        return new Object[][]{
                {"Buenos Aires", "Argentina"},
                {"Montevideo", "Uruguay"},
                {"Santiago", "Chile"}

        };

    }
    @DataProvider(name="personasnae")
    public Object[][] crearPersonasNomApeEd() {
        return new Object[][]{
                {"Juan", "Gomez", 29},
                {"Maria","Fernandez", 22},

        };

    }

}
