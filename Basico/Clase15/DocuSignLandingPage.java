package Basico.Clase15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocuSignLandingPage {
    public WebDriver driver;

    public DocuSignLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public String docusignPageTitle(){
        return driver.getTitle();

    }
    public String docusignCurrentUrl(){
        return driver.getCurrentUrl();

    }

    public DocusignRegistrationPage clickPruebaGratuitaBtn(){
        driver.findElement(By.xpath("//*[@href='https://go.docusign.com.es/o/trial/']")).click();
        return new DocusignRegistrationPage(driver);

    }
}
