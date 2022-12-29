package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P04 {

    @Test
    public void Test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        for (int i = 0; i < 100; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteButtons.size());

        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            driver.findElement(By.xpath("//div[@id='elements']//button[1]")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtons2 = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(10,deleteButtons2.size());

        // Sayfayı kapatınız
        driver.close();


    }
}