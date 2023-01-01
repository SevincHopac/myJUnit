package practice.mentorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    @Test
    public void Test01() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //// Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //// Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

        ////    Type any number in the first input
        ////    Type any number in the second input
        ////    Click on Calculate
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("3", Keys.TAB,"minus",Keys.TAB,"2",Keys.ENTER);

        //// Print the result
        System.out.println(driver.findElement(By.xpath("//div[@class='centered']//p[1]")).getText());
        //// close driver
        driver.close();


    }
}