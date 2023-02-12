package tests.ders12_assertions_POMGelistirmeler;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegatifLoginTesti {


    @Test
    public void negatifLoginTesti(){
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // cookies'i kabul edin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        // Login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();
        // gecerli kullanici adi ve gecersiz password yazip
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();
        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());
        // ve sayfayi kapatin
        Driver.closeDriver();
    }

    @Test
    public void negatifLoginTesti2(){
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // cookies'i kabul edin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();

        // Login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();

        // gecersiz kullanici adi ve gecersiz password yazip
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // ve sayfayi kapatin
        Driver.closeDriver();

    }




}
