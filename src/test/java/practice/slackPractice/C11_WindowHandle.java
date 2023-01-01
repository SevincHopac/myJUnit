package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.Set;

public class C11_WindowHandle extends TestBase {

    @Test
    public void test() {

        //       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //       ilk pencereyi al
        String windowHandle1 = driver.getWindowHandle();

        //       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //       setteki tüm pencereyi al
        Set<String> allWindow = driver.getWindowHandles();

        //       diğer pencereye geç
        for (String w : allWindow){
            if (!w.equals(windowHandle1)){
                driver.switchTo().window(w);
                break;
            }
        }


        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //       Gönder düğmesine tıklayarak

        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.ENTER);


        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actual = driver.findElement(By.xpath("//h3[normalize-space()='This access is valid only for 20 days.']")).getText();
        String expected = "This access is valid only for 20 days.";
        Assert.assertEquals(expected,actual);

        //       Tekrar ilk pencereye geç
        driver.switchTo().window(windowHandle1);

        //       İlk pencerede olduğunu doğrula
        String actualWindowHandle = driver.getWindowHandle();
        Assert.assertEquals(windowHandle1,actualWindowHandle);
    }
}
