package Basico.Clase16.pageObject.Twitter;

import Basico.Clase16.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterLandingPage extends BaseUITest {

    public TwitterLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public TwitterRegistrationForm clickRegisterBtn(){
        driver.findElement(By.xpath("//*[@href='/i/flow/signup']")).click();
        return new TwitterRegistrationForm(driver);

    }

}

