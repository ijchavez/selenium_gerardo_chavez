package Basico.Clase13.Ejercicios.DocuSign;

import org.testng.annotations.Factory;

public class DocuSignFactory {


    @Factory
    public Object[] docuSignFactoryTest() {
        return new Object[]{
                new DocuSignFactoryTest(),
                new DocuSignFactoryTest(),
                new DocuSignFactoryTest()

        };

    }

}
