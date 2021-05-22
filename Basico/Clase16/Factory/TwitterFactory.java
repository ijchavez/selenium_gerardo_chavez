package Basico.Clase16.Factory;

import Basico.Clase16.BaseUITest;
import Basico.Clase16.TwitterTest;
import org.testng.annotations.Factory;

public class TwitterFactory extends BaseUITest {
    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
                new TwitterTest("Gerardo", "9934127981"),
                new TwitterTest("Fabiana", "9933317981")

        };
    }
}
