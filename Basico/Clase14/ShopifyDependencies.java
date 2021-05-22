package Basico.Clase14;

import Basico.Clase13.Ejercicios.DependentTest.DriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShopifyDependencies {
        WebDriver driver;
        public static final String SHOPIFY_URL = "https://www.shopify.com/";

        @BeforeTest
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
            driver.get(SHOPIFY_URL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test (dependsOnMethods = {"fillingFormWithoutShopnameTest"})
        public void ShopifyGetUrlTest(){
            DriverUtilities driverUtility = new DriverUtilities(driver);
            String url = driverUtility.getCurrentUrl();
            System.out.println(url);
            Assert.assertEquals(url,"https://www.shopify.com/");

        }
        @Test (dependsOnMethods = {"fillingFormWithoutShopnameTest"})
        public void ShopifyGetTitleTest(){
            DriverUtilities driverUtility = new DriverUtilities(driver);
            String titulo = driverUtility.getTitle();
            System.out.println(titulo);
            Assert.assertEquals(titulo,"Start a Business, Grow Your Business - Shopify 14-Day Free Trial");

        }
        @Test (dependsOnMethods = {"clickOnGetStartTest"})
        public void fillingFormWithoutShopnameTest(){
            driver.findElement(By.name("signup[email]")).sendKeys("testing@testing.com");
            driver.findElement(By.name("signup[password]")).sendKeys("unaPass123");
            driver.findElement(By.name("button")).click();

        }
        @Test
        public void clickOnGetStartTest(){
            driver.findElement(By.xpath("(//*[@data-ga-event='homepage'])[1]")).click();

            Assert.assertEquals(driver.getCurrentUrl(),"https://www.shopify.com/");
            WebElement titleH2 = driver.findElement(By.id("ModalTitle"));
            String theTitleH2 = titleH2.getText();
            Assert.assertEquals(theTitleH2,"Start your free 14-day trial of Shopify");

        }





}
