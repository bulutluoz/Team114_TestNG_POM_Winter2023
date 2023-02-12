package tests.ders12_assertions_POMGelistirmeler;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTest {

    /*
        Yeni hedefimiz test datalarini manuel olarak girmek degil
        test datalarini configuration.properties dosyasindan alip kullanmak

        Boylece test datalarinda herhangi bir update yapilmasi istendiginde
        sadece configuration.properties'deki degeri degistirerek
        tum testlerimizi update edebilmek
     */


    @Test
    public void test01() throws InterruptedException {
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // cookies'i kabul edin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        Thread.sleep(2000);
        // Login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve gecerli password yazip

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();
        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isEnabled());

        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
