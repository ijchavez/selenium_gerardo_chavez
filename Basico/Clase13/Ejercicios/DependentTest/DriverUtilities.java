package Basico.Clase13.Ejercicios.DependentTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtilities {
    WebDriver driver;

    public DriverUtilities(WebDriver remoteDriver){
        driver = remoteDriver;

    }


    public void clickBtn(String unXpath){
        driver.findElement(By.xpath(unXpath)).click();

    }
    public String getTitle(){
        return driver.getTitle();

    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();

    }
    public WebElement findTextByXpath(String unXpath){
        WebElement emailExist;
        return emailExist = driver.findElement(By.xpath(unXpath));

    }

}
