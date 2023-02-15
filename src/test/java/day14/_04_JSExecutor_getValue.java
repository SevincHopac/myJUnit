package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _04_JSExecutor_getValue extends TestBase {

    @Test
    public void name() {

      /*  1)getValueTest metotu olustur
        2)https://www.priceline.com/ a git
        3)Tarih kısmındaki Yazili metinleri al ve yazdır*/

        driver.get("https://www.priceline.com/");
        waitFor(3);
        driver.findElement(By.xpath("//*[.='Accept All Cookies ']")).click();
        getValueByJS("hotelDates");
    }
}
