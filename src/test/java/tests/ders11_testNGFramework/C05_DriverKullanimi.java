package tests.ders11_testNGFramework;

import org.testng.annotations.Test;
import utilities.Driver;

public class C05_DriverKullanimi {

    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("https://www.youtube.com");

        Thread.sleep(2000);

        Driver.getDriver().get("https://www.wisequarter.com");

        Thread.sleep(2000);

        Driver.getDriver().get("https://www.amazon.com");

        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
