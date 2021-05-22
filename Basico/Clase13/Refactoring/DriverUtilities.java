package Basico.Clase13.Refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
