package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P09 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test() {
        //       https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //       cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Tümünü reddet']")).click();

        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));

        //       Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella", Keys.ENTER);

        //       Bulunan sonuc sayisini yazdirin
        String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        String[] arr = result.split(" ");
        System.out.println(arr[1]);

        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String str = arr[1].replace(".","");
        int num = Integer.parseInt(str);
        Assert.assertTrue(num>10000000);
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
