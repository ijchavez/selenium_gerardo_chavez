package Examen;

import org.testng.annotations.DataProvider;

public class DataProviderNetfilx {
    @DataProvider(name="forInicioSesionTest")
    public Object[][] SpotifyMailTest() {
        return new Object[][]{
                {"maildeprueba@pruebas.com"},
                {"clickencomenzarya@mail.com"},
                {"masmails@topmail.com"}

        };
    }
}
