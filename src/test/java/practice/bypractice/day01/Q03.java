package practice.bypractice.day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {


        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps

        getWebEl("//*[@id=\"calculatetest\"]").click();

        // Type any number in the first input
        // Type any number in the second input
        // Click on Calculate

        WebElement input = getWebEl("//*[@id='number1']");
        input.sendKeys("10", Keys.TAB,Keys.TAB,"20",Keys.ENTER);

        // Print the result

        WebElement sonuc = getWebEl("//*[@id='answer']");
        System.out.println("Sonuc = " + sonuc.getText());


    }

    public static WebElement getWebEl (String locator) throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(By.xpath(locator));

    }
}
