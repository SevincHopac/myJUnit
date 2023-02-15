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
import utilities.TestBase;

import java.time.Duration;

public class _01_NoSuchElementException extends TestBase{



    @Test
    public void yanlisLocator() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER);
        //org.openqa.selenium.NoSuchElementException
    }


    @Test
    public void waitNoSuch() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//div[@id='start']//button")).click();

     //   waitFor(1);

        WebElement element = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        String helloWorldText = element.getText();
        Assert.assertEquals("Hello World!", helloWorldText);


        /*
         wait ten kaynakli nosuch element imp. wait ise yaramiyor
         Thread yada excplicit wait le cozulur

         */
    }



}
