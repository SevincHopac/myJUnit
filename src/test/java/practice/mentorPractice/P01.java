package practice.mentorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    @Test
    public void Test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        System.out.println("Title--> "+driver.getTitle()+"\nUrl--> " + driver.getCurrentUrl());

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(driver.getTitle().contains("Spend") && driver.getCurrentUrl().contains("Spend"));


        //-Ardindan "trendyol.com" adresine gidelim
        driver.navigate().to("https://trendyol.com.tr");
        driver.findElement(By.xpath("//*[text()='Akzeptieren']")).click();

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        Assert.assertFalse(driver.getTitle().contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        //-sayfayi yenileyelim
        driver.navigate().refresh();
        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.close();

    }
}
