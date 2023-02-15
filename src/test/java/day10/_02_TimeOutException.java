package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class _02_TimeOutException  {

    //Çözüm
    //Süreyi artırabiliriz.
    //Farkli explicit wait yöntemleri kullanırız. Örn: VisibilityOfElementLocated çözmedi yerine presenceOfElementLocator kullanılabilir.
    //Ya da javascript executor da ki waitleri sayfa geçişlerini beklemek için kullanabiliriz.
    //Locatorı kontrol ederiz.
    //Frameworkümde hazır reusable methodlar var. Bu durumda TimeOutException aldığımda o methodlar yardımıyla problemi çözebiliriz.


    //TimeOutException:
    //If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
    //Simply put, wait time is over but the commend is not completed
    //Solution:
    //-Increase the wait time
    //-Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
    //-I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
    //-Case by case, I prefer different explicit waits to maximize the performance of the automation script


    /*
    TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim
     */

    protected static WebDriver driver;

    //    setUp
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();                                // Hard Wait  -Java
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // If necessary Wait - Selenium
    }




    @Test
    public void timeOutExceptionTest() {
        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
    }


    @Test
    public void iFrameTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String text = driver.findElement(By.xpath("//p[normalize-space()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(text.contains("black border"));

        //driver.switchTo().frame(0); // because first iFrame

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Applications lists']")));

        Assert.assertTrue(element.isDisplayed());

    }


    @Test
    public void waitTimeOut() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));    // yetersiz explicitly wait
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        String helloWorldText = element.getText();

        Assert.assertEquals("Hello World!", helloWorldText);

    }


//  TimeOutException hatasi, Selenium driverin bulundugu  sayfa öğesinde yer bulmada başarısız olduğunda atılır.
//Buna aşağıdakilerden biri neden olabilir:
//1)
//Yanlış bir locater kullanıyorsunuz.
//2)
//Öğe bir iframe içinde olabilir.
//3)
//Tarayıcınızda yeni bir sekme / pencere açtınız ancak driveri yeni açılan sekmeye geçirmediniz.
//4)HTML DOM da öge style="display:none;" olabilir
//

}