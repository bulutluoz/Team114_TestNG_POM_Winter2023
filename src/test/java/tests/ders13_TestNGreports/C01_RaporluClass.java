package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluClass extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Nutella Testi","Kullanici aradigi kelimeye ait sonuclar gorebilmeli");
        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");
        // nutella icin arama yapin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Nutella icin arama yapildi");

        // arama sonuclarinin Nutella icerdigini test edin
        String actualAramaSonucYazisi = amazonPage.aramaSonucYaziElementi.getText();
        String expectedIcerik="Nutella";

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));
        extentTest.pass("Sonuclarin Nutella icerdigi test edildi");

        Driver.closeDriver();
    }
}
