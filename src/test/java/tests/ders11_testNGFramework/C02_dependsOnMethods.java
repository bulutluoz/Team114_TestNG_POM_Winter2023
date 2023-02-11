package tests.ders11_testNGFramework;

import org.testng.annotations.Test;

public class C02_dependsOnMethods {

    /*
        dependsOnMethos ozelligi ile
        bir method'un calismasini, baska method'un calismasindan sonraya ayarlayabilirsiniz

        bu durumda bagli olunan method calisip, passed olmadan
        bagli olan method calismaz
     */


    @Test(priority = 5)
    public void amazonTest(){
        System.out.println("amazon");
    }

    @Test(priority = -7,dependsOnMethods = "amazonTest")
    public void youtubeTest(){
        System.out.println("youtube");
    }

    @Test
    public void wisequarterTest(){
        System.out.println("wise quarter");
    }

    @Test (dependsOnMethods = "youtubeTest")
    public void bestBuyTest(){
        System.out.println("bestBuy");
    }
}
