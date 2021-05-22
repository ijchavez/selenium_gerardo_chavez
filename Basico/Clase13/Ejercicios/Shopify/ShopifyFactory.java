package Basico.Clase13.Ejercicios.Shopify;

import org.testng.annotations.Factory;

public class ShopifyFactory {
    @Factory
    public Object[] shopiftFactoryTest() {
        return new Object[]{
                new ShopifyTest(1),
                new ShopifyTest(2),
                new ShopifyTest(3)

        };

    }
}
