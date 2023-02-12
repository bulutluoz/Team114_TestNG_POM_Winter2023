package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {
    // page class'lari locate islemleri
    // ve login gibi basit islev yapan method'lari icerir
    // bir page class'i olusturuldugunda ilk isimiz driver'i bu class'a tanitmak olmalidir


    public QualitydemyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLoginLinki;

    @FindBy(id="login-email")
    public WebElement emailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText = "My courses")
    public WebElement basariliGirisElementi;

    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cookiesKabulButonu;



}
