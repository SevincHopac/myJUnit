package day04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class _01_TestBaseDemo extends TestBase {

    /*
   UTILITIES:
   - Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase -> Bugun
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra

   - Utilities paketinde Test case'ler yazilmaz.

   - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.

   - Bu support class'lar test case'lerin yazilmasini hizlandirir.
 */

    @Test
    public void test1() {
        driver.get("https://techproeducation.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamps"));
    }
}
