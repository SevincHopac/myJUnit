package practice.bypractice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {

    //http://www.google.com adresine gidin
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //AfterClass ile kapatın

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void setUp() {
        driver.get("http://www.google.com");
    }

    @Test
    public void Test01() {
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("The God Father", Keys.ENTER);
    }

    @Test
    public void Test02() {
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void Test03() {
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Kill Bill", Keys.ENTER);
    }

    @After
    public void tearDown() {
        String[] arr = driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
        System.out.println(arr[1]);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }


}
