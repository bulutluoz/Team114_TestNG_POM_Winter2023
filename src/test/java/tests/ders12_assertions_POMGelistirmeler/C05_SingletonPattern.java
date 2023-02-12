package tests.ders12_assertions_POMGelistirmeler;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SingletonPattern {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        /*
            Biz POM framework'lerde webdriver'in
            Driver class'indaki getDriver() undan kullanilmasini istiyoruz

            eger bu kullanim yontemi disinda
            obje olusturularak bu method kullanilmaya calisilmasin istiyorsaniz
            Driver class'indan obje uretilmesine engel olmalisiniz

            Bunu parametresiz bir constructor olusturup
            access modifier'ini private yaparak saglayabilirsiniz

            Bu yontemle bir class'dan obje uretilmesini engellemeye SINGLETON PATTERN denir

         */

        // Driver driver= new Driver();

    }
}
