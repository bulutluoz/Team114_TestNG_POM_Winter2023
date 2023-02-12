package tests.ders12_assertions_POMGelistirmeler;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_HardAssertion {

    /*
        JUnit'de de kullandigimiz Assert class'i ilk assertion failed oldugunda
        calismayi durdurur ve exception firlatir.

        Bunun pozitif tarafi hemen tek bir hataya odaklanabilmemizdir

        Bunun negatif tarafi ise birden fazla hata olan class'lardaki
        hatalari gorebilmemiz icin
        class'i tekrar tekrar calistirmak zorunda kalmamizdir.

        TestNG bu negatifligi ortadan kaldirabilmemiz icin bize SoftAssertion
        alternatifi gelistirmistir.
     */

    // yeni bir test method'u olusturun ve 3 gorevi gerceklestirin
    // 1- amazon anasayfaya gidip, amazon'a gittigimizi test edin
    // 2- amazon anasayfasinda arama kutusunun enable oldugunu test edin
    // 3- arama kutusuna Nutella yazipn aratin, sonuclarin Nutella icerdigini test edin

    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidip, amazon'a gittigimizi test edin
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        // 2- amazon anasayfasinda arama kutusunun enable oldugunu test edin

        AmazonPage amazonPage= new AmazonPage();

        Assert.assertTrue(amazonPage.aramaKutusuElementi.isEnabled());


        // 3- arama kutusuna Nutella yazip aratin, sonuclarin Nutella icerdigini test edin

        amazonPage.aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);

        expectedIcerik= "Nutella";
        String actualSonucYazisi= amazonPage.aramaSonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        Thread.sleep(5000);

        Driver.closeDriver();


    }
}
