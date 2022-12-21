package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class _01_mavenFirstClass {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3"Samsung headphones" ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);

        // 4Bulunan sonuc sayisini yazdiralim
        WebElement resultText = driver.findElement(By.xpath("//span[normalize-space()='1-16 of 234 results for']"));
        String[] arrText = resultText.getText().split(" ");
        String numberOfResult = arrText[2];
        System.out.println("numberOfResult = " + numberOfResult);

        //5Ilk urunu tiklayalim
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//img"));
        firstProduct.click();

        //6Sayfadaki tum basliklari yazdiralim

        List<WebElement> allHead = driver.findElements(By.xpath("//h1"));

        for (WebElement w : allHead){
            System.out.println(w.getText());
        }

        // with Lambda
        // allHead.stream().forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}
