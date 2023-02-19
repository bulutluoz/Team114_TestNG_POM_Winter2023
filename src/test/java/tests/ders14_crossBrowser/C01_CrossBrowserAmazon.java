package tests.ders14_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.CrossDriver;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_CrossBrowserAmazon extends TestBaseCross {
    /*
        Crossbrowser testi hazirlamak istedigimizde
        Class'i TestBaseCross'a extends edip orada olusturulan driver'i kullaniyoruz
        artik page sayfalarinda kullandigimiz driver'dan farkli bir driver kullandigimiz icin
        page sayfalarini kullanamayiz
        tum locate'leri eski usulle icinde oldugumuz class'da yapmaliyiz
     */

    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidip, amazon'a gittigimizi test edin
        driver.get("https://www.amazon.com");
        String expectedIcerik="amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        // 2- amazon anasayfasinda arama kutusunun enable oldugunu test edin

        WebElement aramaKutusuElementi= driver.findElement(By.id("twotabsearchtextbox"));

        Assert.assertTrue(aramaKutusuElementi.isEnabled());


        // 3- arama kutusuna Nutella yazip aratin, sonuclarin Nutella icerdigini test edin

        aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);

        expectedIcerik= "Nutella";
        String actualSonucYazisi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        Thread.sleep(5000);



    }
}
