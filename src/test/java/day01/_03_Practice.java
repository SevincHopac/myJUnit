package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _03_Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // Sayfa basliginin "Google" ifadesi icerdigini test edin
        String title = driver.getTitle();
        if (title.contains("Google")){
            System.out.println("Title Test Passed");
        }else {
            System.out.println("Title Test Failed");
            System.out.println("title = " + title);
        }

        // Arama cubuguna "Nutella" yazip aratin




        // Bulunan sonuc sayisini yazdirin
        // sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        // Sayfayi kapatin


    }
}
