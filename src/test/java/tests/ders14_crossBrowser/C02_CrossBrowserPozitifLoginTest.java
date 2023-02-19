package tests.ders14_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseCross;

public class C02_CrossBrowserPozitifLoginTest extends TestBaseCross {
    @Test
    public void test01() throws InterruptedException {
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        driver.get(ConfigReader.getProperty("qdUrl"));
        // cookies'i kabul edin

        driver.findElement(By.xpath("//a[text()='Accept']")).click();

        Thread.sleep(2000);
        // Login linkine tiklayin
        driver.findElement(By.linkText("Log in")).click();

        // gecerli kullanici adi ve gecerli password yazip

        WebElement emailKutusu= driver.findElement(By.id("login-email"));
        WebElement passwordKutusu= driver.findElement(By.id("login-password"));
        emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // login butonuna bastiginizda
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // basarili olarak giris yapildigini test edin
        WebElement basariliGirisElementi = driver.findElement(By.linkText("My courses"));

        Assert.assertTrue(basariliGirisElementi.isEnabled());

        Thread.sleep(3000);

    }
}
