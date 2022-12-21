package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.xpath("//*[text()='Tümünü reddet']")).click();

        // Sayfa basliginin "Google" ifadesi icerdigini test edin

        String title = driver.getTitle();
        if (title.contains("Google")){
            System.out.println("Title Test Passed");
        }else {
            System.out.println("Title Test Failed");
            System.out.println("title = " + title);
        }

        // Arama cubuguna "Nutella" yazip aratin

        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella", Keys.ENTER);



        // Bulunan sonuc sayisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String text = resultText.getText();

        String[] textArr = text.split(" ");

        String resultString = textArr[1];
        resultString=resultString.replace(".","");

        int resultNum = Integer.parseInt(resultString);

        System.out.println("Number of Result = " + resultNum);

        // sonuc sayisinin 10 milyon'dan fazla oldugunu test edin

        if (resultNum>10000000){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        // Sayfayi kapatin
        driver.close();

    }
}
