package practice.byinstruction;

import com.github.javafaker.Team;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Q02_WindowHandle extends TestBase {


    @Test
    public void test() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        TestBase.driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String handle1 = TestBase.driver.getWindowHandle();

        //Title in ‘Windows’ oldugunu test edin
        Assert.assertEquals("Windows", TestBase.driver.getTitle());

        //Click here a tiklayin
        TestBase.driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> handeles = TestBase.driver.getWindowHandles();

        for (String w : handeles){
            if (!w.equals(handle1)) {
                TestBase.driver.switchTo().window(w);
                break;
            }
        }

        System.out.println(TestBase.driver.getTitle());
        Assert.assertEquals("New Window", TestBase.driver.getTitle());
    }
}
