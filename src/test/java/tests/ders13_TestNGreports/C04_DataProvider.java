package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProvider {


    @DataProvider
    public static Object[][] aranacakUrunListesi() {

        String [][] urunList ={{"Nutella"},{"Java"},{"Samsung"},{"Apple"}};
        return urunList;
    }

    @Test (dataProvider = "aranacakUrunListesi")
    public void test01(String urunIsmi){

        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // istenen urun icin arama yapin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys(urunIsmi + Keys.ENTER);

        // arama sonuclarinin istenen urun ismini icerdigini test edin

        String actualAramaSonucYazisi= amazonPage.aramaSonucYaziElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(urunIsmi));
    }

}
