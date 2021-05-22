package Basico.Clase13.Ejercicios.SalesForce;

import org.testng.annotations.Factory;

public class SalesForceFactory {
    @Factory
    public Object[] SalesForceactoryTest() {
        return new Object[]{
                new SalesForceTest(),
                new SalesForceTest()

        };

    }

}