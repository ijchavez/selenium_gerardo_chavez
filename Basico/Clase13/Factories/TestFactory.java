package Basico.Clase13.Factories;

import Basico.Clase13.Refactoring.FacebookTest;
import org.testng.annotations.Factory;

public class TestFactory {
    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
                new FacebookTest("Gerardo","Chavez",
                        "info.gerardo.chavez@gmail.com","info.gerardo.chavez@gmail.com","unaPassword123"),
                new FacebookTest("Juan", "Perez",
                        "perezjuan@mail.com","perezjuan@mail.com","unaPass123"),
                new CalculadoraTest(3,6),
                new CalculadoraTest(4,2)

        };

    }

}
