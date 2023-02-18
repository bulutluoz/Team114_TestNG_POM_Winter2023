package tests.ders11_testNGFramework;

import org.testng.annotations.Test;

public class C01_Priority {

    /*
        JUnit'te testlerin calisma sirasi bilinemez ve yonetilemezdi
        TestNG testleri isim sirasina gore calistirir

        istersek isim siralamasi disinda da test calisma siralamasi yapabiliriz
        bunun icin test method'larina priority degeri atanir

        TestNG kucuk priority'den, yuksege dogru calistirir
        bir method'a priority tanimlanmazsa 0 olarak kabul eder
        esit oncelikli iki method varsa, harf sirasina gore calistirir
     */

    @Test (priority = 5)
    public void amazonTest(){
        System.out.println("amazon");
    }

    @Test(priority = -7,groups = "smoke")
    public void youtubeTest(){
        System.out.println("youtube");
    }

    @Test
    public void wisequarterTest(){
        System.out.println("wise quarter");
    }

    @Test
    public void bestBuyTest(){
        System.out.println("bestBuy");
    }

}
