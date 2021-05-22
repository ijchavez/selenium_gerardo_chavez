package Basico.Clase15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocusignRegistrationPage {
    public WebDriver driver;

    public DocusignRegistrationPage(WebDriver remoteDriver){
        driver = remoteDriver;

    }
    public String docusignPageTitle(){
        return driver.getTitle();

    }
    public String docusignCurrentUrl(){
        return driver.getCurrentUrl();

    }
    public void fillingRegistrationFields(String unNombre, String unApellido, String unEmail){
        driver.findElement(By.name("first_name")).sendKeys(unNombre);
        driver.findElement(By.name("last_name")).sendKeys(unApellido);
        driver.findElement(By.name("email")).sendKeys(unEmail);

    }
    public void clickOnComenzarBtn(){
        driver.findElement(By.id("submitMainText_0")).click();

    }
}
