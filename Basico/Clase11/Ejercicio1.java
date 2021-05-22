package Basico.Clase11;
import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio1 {
    @Test
    public void completeDocusignRegistrationFrom(){
        String BaseURL = "https://go.docusign.com/o/trial/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Gerardo");
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Chavez");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("info.gerardo.chavez@gmail.com");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("4069581305");
        driver.findElement(By.xpath("//*[@name='title']")).sendKeys("QA");

        //Usar esto para el ComboBox - Dropdown
        WebElement industry = driver.findElement((By.xpath("//*[@name='ds_industry']")));
        //Instanciamos el objeto y le mandamos la seleccion luego
        Select industryDropDown = new Select(industry);
        industryDropDown.selectByVisibleText("Education");

    }

}
