package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _03_DismissAlert extends TestBase {

    @Test
    public void dismissAlertTest() {

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel",result);

    }
}
