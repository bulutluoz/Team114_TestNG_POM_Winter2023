package tests.ders13_TestNGreports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluPositiveLoginTest extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Login testi","Dogru bilgilerle giris yapilabilmeli");
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("qualitydemy anasayfaya gidildi");
        // cookies'i kabul edin
        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        extentTest.info("cookies kabul edildi");
        Thread.sleep(2000);
        // Login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();
        extentTest.info("ilk login linkine tiklandi");

        // gecerli kullanici adi ve gecerli password yazip

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        extentTest.info("gecerli kullanici adi ve sifre girildi");
        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");
        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isEnabled());
        extentTest.pass("basarili sekilde giris yapildigi test edildi");
        Driver.closeDriver();
    }
}
