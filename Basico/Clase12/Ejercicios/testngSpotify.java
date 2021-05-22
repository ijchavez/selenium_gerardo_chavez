package Basico.Clase12.Ejercicios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testngSpotify {
    String URL = "https://www.spotify.com";
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);

    }
    @Test (priority = 5)
    public void verifySpotify(){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,"Escuchar es todo - Spotify");

    }
    @Test (priority = 4)
    public void verifySignUpUrlTest() {
        String xpath = "/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a";
        String xpathRel = "//*[@href='https://www.spotify.com/ar/signup/']";
        //driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath(xpathRel)).click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        //Valida que sea cierto que la url actual contenga la palabra signup
        Assert.assertTrue(currentUrl.contains("signup"));

    }
    @Test (priority = 3)
    public void validatingExistingMail() throws InterruptedException {
        String xpath = "/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a";
        String xpathRel = "//*[@href='https://www.spotify.com/ar/signup/']";
        //driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath(xpathRel)).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        String xpathExist = "//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]";
        WebElement emailExist = driver.findElement(By.xpath(xpathExist));

        Thread.sleep(3000);

        String textExiEmail = emailExist.getText();
        Thread.sleep(3000);

        //paso a escribir una contraseña para que al cambiar el cursor el campo se visualice el error
        //No lo encuentra, el cartel aparece como vacio
        driver.findElement(By.id("password")).sendKeys("unapass");
        Thread.sleep(3000);
        System.out.println("Cartel: " + textExiEmail);
        Assert.assertEquals(textExiEmail,"");

    }
    @Test (priority = 2)
    public void checkEqualEmailsError() throws InterruptedException {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("email")).sendKeys("test2999@test.com");
        driver.findElement(By.name("confirm")).sendKeys("hola@hola.com");

        //paso a escribir una contraseña para que al cambiar el cursor el campo se visualice el error
        driver.findElement(By.id("password")).sendKeys("unapass");
        Thread.sleep(3000);

        WebElement mailNoCoin = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]"));

        String textMailNoCoin = mailNoCoin.getText();
        System.out.println("Cartel--> " + textMailNoCoin);

        String compTextMailNoCoin = "Las direcciones de correo electrónico no coinciden.";
        Assert.assertEquals(textMailNoCoin,compTextMailNoCoin);



    }
    @Test (priority = 0)
    public void checkErrorMessages() throws InterruptedException {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/ar/signup/']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //mensajes de error

        String errMail = "Es necesario que introduzcas tu correo electrónico.";
        String errConfMail = "Es necesario que confirmes tu correo electrónico.";
        String errPass = "Debes introducir una contraseña.";
        String errPerf = "Introduce un nombre para tu perfil.";
        String errDia = "Indica un día del mes válido.";
        String errMes = "Selecciona tu mes de nacimiento.";
        String errYear = "Indica un año válido.";
        String errSex = "Selecciona tu sexo.";
        String errBot = "Confirma que no eres un robot.";

        //tomo los webelements

        WebElement mailErr = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        WebElement mailConfErr = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));
        WebElement passErr = driver.findElement(By.xpath("//*[contains(text(),'Debes introducir una contraseña.')]"));
        WebElement perfErr = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
        WebElement diaErr = driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"));
        WebElement mesErr = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"));
        WebElement yearErr = driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"));
        WebElement sexErr = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo.')]"));
        WebElement botErr = driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"));

        //Valido el getText() poniendolo en un string y un println
        String mensErrMail = mailErr.getText();
        String mensErrConfMail = mailConfErr.getText();
        String mensErrPass = passErr.getText();
        String mensErrPerf = perfErr.getText();
        String mensErrDia = diaErr.getText();
        String mensErrMes = mesErr.getText();
        String mensErrYear = yearErr.getText();
        String mensErrSex = sexErr.getText();
        String mensErrBot = botErr.getText();

        System.out.println(mensErrMail + "\n" + mensErrConfMail + "\n" + mensErrPass + "\n" + mensErrPerf + "\n" + mensErrDia + "\n" + mensErrMes + "\n");
        System.out.println(mensErrYear + "\n" + mensErrSex + "\n" + mensErrBot);

        //Comparo
        Assert.assertEquals(mensErrMail,errMail);
        Assert.assertEquals(mensErrConfMail,errConfMail);
        Assert.assertEquals(mensErrPass,errPass);
        Assert.assertEquals(mensErrPerf,errPerf);
        Assert.assertEquals(mensErrDia,errDia);
        Assert.assertEquals(mensErrMes,errMes);
        Assert.assertEquals(mensErrYear,errYear);
        Assert.assertEquals(mensErrSex,errSex);
        Assert.assertEquals(mensErrBot,errBot);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }






}

