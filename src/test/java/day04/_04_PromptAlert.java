package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _04_PromptAlert extends TestBase {

    @Test
    public void sendKeysMethod() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        ////    3. butona tıklayın,
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

        ////    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Hello world!");
        Thread.sleep(3000);

        ////    OK butonuna tıklayın
        driver.switchTo().alert().accept();

        ////    ve result mesajında "Hello world!" görüntülendiğini doğrulayın.
        String message = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(message.contains("Hello world!"));
        Thread.sleep(3000);



    }
}
