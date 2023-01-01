package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _02_AlertsAccept extends TestBase {


    @Test
    public void acceptAlertTest(){
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts

//        1. butona tıklayın,
//        uyarıdaki OK butonuna tıklayın
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        String str = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert",str);

    }

    /*
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */

}
