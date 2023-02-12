package tests.ders12_assertions_POMGelistirmeler;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C02_SoftAssertion {

    @Test
    public void test01() throws InterruptedException {

        /*
            Eger bir test adiminda verify veya dogrulayin kelimesi geciyorsa
            genellikle soft assertion kullanilacagi anlasilir

            soft assertion kullandigimizda
            biz assertion'lari raporla deyinceye kadar
            testler failed olsa bile calismaya devam eder
            biz rapopla dedigimizde
            yaptigi tum assertion'lari raporlar
            ve failed olan assertion varsa calismayi durdurup, exception firlatir

            Softassert kullanabilmek icin
            1- softassert objesi olusturun
            2- bu objeyi kullanarak istediginiz tum testleri yapin
            3- tum testler bittiginde, raporlama yapmasi icin
               softassert.assertAll() calistirin
               eger testlerin sonunda assertAll() yazilmazsa
               assertion'lar failed olsa bile test PASSED yazar

            Softassert birden fazla hatayi toptan rapor eder
            ancak, hatalarin satir numarasini degil
            assertAll() kodunun satir numarasini verir

            hatalarin nereden kaynaklandigini kolayca gorebilmemiz icin
            verify kodlarina ACIKLAMA EKLEMELIYIZ



         */
        // yeni bir test method'u olusturun ve 3 gorevi gerceklestirin
        // 1- amazon anasayfaya gidip, amazon'a gittigimizi dogrulayin (verify)
        Driver.getDriver().get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert= new SoftAssert();
        //1.verify
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"1.verify calismiyor, url istenen icerige sahip degil");

        // 2- amazon anasayfasinda arama kutusunun enable oldugunu dogrulayin (verify)
        AmazonPage amazonPage= new AmazonPage();
        // 2.verify
        softAssert.assertTrue(amazonPage.aramaKutusuElementi.isEnabled(),"2.verify calismiyor, arama kutusu ulasilabilir degil");

        // 3- arama kutusuna Nutella yazin aratin, sonuclarin Nutella icerdigini dogrulayin (verify)

        amazonPage.aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);

        expectedIcerik = "Nutella";
        String actualSonucYazisi= amazonPage.aramaSonucYaziElementi.getText();
        // 3.verify
        softAssert.assertTrue(actualSonucYazisi.contains(expectedIcerik),"3.verify calismiyor, arama sonuclari istenen icerige sahip degil");

        softAssert.assertAll();

        Thread.sleep(5000);
        Driver.closeDriver();

    }
}
