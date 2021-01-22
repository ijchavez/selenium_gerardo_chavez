package Clase15.TelefonicaPageObject;

import Clase15.DocusignRegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelefonicaLandingPage {

        public WebDriver driver;

        public TelefonicaLandingPage(WebDriver remoteDriver){
            driver = remoteDriver;

        }
        public String telefonicaPageTitle(){
            return driver.getTitle();

        }
        public String telefonicaCurrentUrl(){
            return driver.getCurrentUrl();

        }


        public TelefonicaIframeBolsa clickPruebaGratuitaBtn(){
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            return new TelefonicaIframeBolsa(driver);

        }
}
