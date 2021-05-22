package Basico.Clase13.Ejercicios.Shopify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopifyTest {

    private int parametro = 0;

    public ShopifyTest(){
        parametro = 0;

    }
    public ShopifyTest(int parametro){
        this.parametro = parametro;

    }

    public static final String SHOPIFY_URL = "https://es.shopify.com/";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(SHOPIFY_URL);

    }
    @Test
    public void testButtons(){
        List<WebElement> elemButton = driver.findElements(By.tagName("button"));
        ArrayList<WebElement> noEmptyButtons = new ArrayList<WebElement>();

        for(WebElement butt: elemButton){
            if(butt.getText().equals("") == false){
                noEmptyButtons.add(butt);
            }

        }
        WebElement btnParam = noEmptyButtons.get(parametro);
        System.out.println(btnParam.getText());
    }

    @AfterMethod

    public void closeDriver(){
        driver.close();

    }
}
