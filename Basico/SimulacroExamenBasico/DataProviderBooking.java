package Basico.SimulacroExamenBasico;

import org.testng.annotations.DataProvider;

public class DataProviderBooking {
    @DataProvider(name="forinvalidMailTest")
    public Object[][] SpotifyMailTest() {
        return new Object[][]{
                {"testt.com"},
                {"test123a.com"},
                {"testtest.com"}

        };
    }
}
