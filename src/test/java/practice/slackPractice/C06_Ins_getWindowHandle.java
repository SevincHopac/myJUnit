package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C06_Ins_getWindowHandle extends TestBase {

    @Test
    public void test() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String handle1 = driver.getWindowHandle();

        //Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows",driver.getTitle());

        //Click here a tiklayin
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> handeles = driver.getWindowHandles();

        for (String w : handeles){
            if (!w.equals(handle1)) {
                driver.switchTo().window(w);
                break;
            }
        }

        System.out.println(driver.getTitle());
       Assert.assertEquals("New Window",driver.getTitle());
    }
}
