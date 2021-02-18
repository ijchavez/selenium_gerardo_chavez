package Examen;

import Clase16.TwitterTest;
import org.testng.annotations.Factory;

public class NetflixFactory {
    @Factory
    public Object[] Prueba_netflix(){
        return new Object[]{
                //La fabrica falla en los casos que ingresa usuario y contraseña ya que los usuarios no
                //existen por lo tanto no se va a encontrar Contraseña incorrecta en loginToNetflixErrorTest
                new Prueba_netflix("untest@test.com", "unapassword"),
                new Prueba_netflix("otrotest@otrotest.com", "otrapassword")

        };
    }
}
