package Basico.Clase14.DataProviderEjercicios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class DataProviderFactory {


    @DataProvider (name="datos")
    public Object[][] personas() {
        return new Object[][]{
                {"Juan", 29},
                {"Maria", 22},
                {"Andres", 28}
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
    @DataProvider (name="loginData")
    public Object[][] loginInfo() {
        return new Object[][]{
                {"John", "Smith", "New York", 1231234},
                {"Alan", "Rowen", "Dallas", 3333333},
                {"Brianne", "Cowen", "Miami", 2222222},

        };

    }
    @DataProvider (name="emails")
    public Object[][] emailInfo() {
        return new Object[][]{
                {"testing@test.com", "valid"},
                {"testing@@@@@", "invalid"},
                {"asdsddfsg", "invalid"},

        };

    }

}
