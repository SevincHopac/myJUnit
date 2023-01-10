package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class _02_ExplicitWait01 extends TestBase {

    @Test
    public void explicitWait() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

  /*      //Hello World! Yazının sitede oldugunu test et
        WebElement element = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assert.assertEquals("Hello World!",element.getText());*/
        // Implicitwait doesnt work



        //        1. WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        2. wait objesini kullanarak bekleme problemini cozmeye calis
        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

    }
}
