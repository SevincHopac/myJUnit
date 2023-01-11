package practice.byslack;

import org.junit.Test;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Q01 extends TestBase {

    @Test
    public void test01(){


        // 1-Test01 isimli bir class olusturun

        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        // 4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // 5-”Salesforce Apex Questions Bank” icin arama yapiniz
        getWebElById("twotabsearchtextbox").sendKeys("Salesforce Apex Questions Bank" + Keys.ENTER);

        // 6- Kac sonuc bulundugunu yaziniz
        String [] arr = getWebElByXpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]").getText().split(" ");
        System.out.println("Sonuç Sayisi: " + arr[0]);

        String sonucYazisi = getWebElByXpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]").getText();
        System.out.println("Sonuc Yazisi = " + sonucYazisi);

    }
}
