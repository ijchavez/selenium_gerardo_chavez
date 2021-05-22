package Basico.Clase11;
import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio2 {
    @Test
    public void defaultXpath(){
        String BaseURL = "https://go.docusign.com/o/trial/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.xpath("//*[@id='dsFormLabel_First_Name']/input")).sendKeys("Gerardo");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Last_Name']/input")).sendKeys("Chavez");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Email']/input")).sendKeys("info.gerardo.chavez@gmail.com");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Phone']/input")).sendKeys("4069581305");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Job_Title']/input")).sendKeys("QA");

        //Usar esto para el ComboBox - Dropdown
        WebElement industry = driver.findElement((By.xpath("//*[@id='dsFormLabel_Industry']/select")));
        //Instanciamos el objeto y le mandamos la seleccion luego
        Select industryDropDown = new Select(industry);
        industryDropDown.selectByVisibleText("Education");

    }
}
