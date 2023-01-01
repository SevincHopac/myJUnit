package practice.mentorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P07 {

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
        //// https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //// dropdown'dan "Books" secenegini secin
        WebElement element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(element);
        options.selectByVisibleText("Books");

        //// arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        //// arama sonuclarinin Java icerdigini test edin
        String result = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("Java"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
