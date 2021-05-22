package Basico.Clase11;
import Basico.Clase9.Ejercicio.seleniumUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
public class EjercicioClase {

    @Test
    public void testint() throws InterruptedException {
        String BaseURL = "http://www.facebook.com";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        WebElement footer = driver.findElement(By.xpath("//*[@data-referrer='page_footer']"));

        driver.findElement(By.xpath("//*[@role='button'][@ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@name='sex'][@value = '1']")).click();

        driver.findElement(By.xpath("//*[contains(text(), 'Es rápido y fácil')]"));

    }

    @Test
    public void completeDocusignRegistration(){
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

    @Test
    public void spotifyByPlaceHolder() throws InterruptedException {
        String BaseURL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        //placeholder="Introduce tu correo electónico"
        driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("unaContraseña");
        driver.findElement(By.xpath("//*[@placeholder='Introduce un nombre de perfil.']")).sendKeys("unNombreDePerfil");

        //Introduce un nombre de perfil.
        //que salga el texto que la cuenta existe si existe
        Thread.sleep(3000);
        WebElement errMessage = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        System.out.println("-->" + errMessage.getText());
        Assert.assertEquals(errMessage.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

        List<WebElement> listaErrMsg = driver.findElements(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        System.out.println("La cantidad de elementos con este mensaje de error son: " + listaErrMsg.size());

        for (WebElement element : listaErrMsg){
            System.out.println("--> " + element.getText());
        }

    }

    @Test
    public void cssSelectorByName() throws InterruptedException {
        String BaseURL = "https://www.spotify.com/uy/signup/";
        WebDriver driver = seleniumUtils.getUrlDriver(BaseURL);

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("unaContraseña");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("unNombreDePerfil");

    }


}
