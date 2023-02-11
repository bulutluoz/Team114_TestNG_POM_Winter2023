package tests.ders11_testNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {

    // 3 tane test method'u olusturun
    // 1- amazon anasayfaya gidip, amazon'a gittigimizi test edin
    // 2- amazon anasayfasinda arama kutusunun enable oldugunu test edin
    // 3- arama kutusuna Nutella yazipn aratin, sonuclarin Nutella icerdigini test edin

    /*
        Notlar
        1- bagli olan method calismak icin bagli oldugu method'un calismasini bekler
        2- sadece bagli olan method'u calistirmak istesek bile
           testNG otomatik olarak once bagli olunan testi calistirir
           o calisip passed olduktan sonra bagli olan method'u calistirir
        3- eger bagli olunan method failed olursa
           bagli olan method'lari hic calistirmaz
           ignore eder
        4- @Ignore notasyonu kullanilan testi testNG calistirmaz

     */
    WebDriver driver;

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expectedIcerik="amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }

    @Test (dependsOnMethods = "test01")
    public void aramaKutusuTesti(){

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }


    @Test (dependsOnMethods = "aramaKutusuTesti") @Ignore
    public void nutellaTesti(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik= "Nutella";
        String actualAramaSonucYazisi= sonucYaziElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        driver.close();
    }

}
