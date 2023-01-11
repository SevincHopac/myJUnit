package practice.byslack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Q09_WindowHandle extends TestBase {

    @Test
    public void test() {


        //https://demoqa.com/ url'ine gidin.
        TestBase.driver.get("https://demoqa.com/");
        String windowHandle1 = TestBase.driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        TestBase.driver.findElement(By.xpath("//div[3]//div[1]//div[1]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = TestBase.driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertEquals("Please select an item from left to start practice.",text.getText());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        TestBase.driver.findElement(By.xpath("//span[normalize-space()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = TestBase.driver.findElement(By.xpath("//button[@id='tabButton']"));
        Assert.assertTrue(newTab.isDisplayed());

        //New Tab butonuna click yap
        newTab.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Set<String> allWindows = TestBase.driver.getWindowHandles();

        for (String w : allWindows) {
            if (!w.equals(windowHandle1)) {
                TestBase.driver.switchTo().window(w);
                break;
            }
        }

        Assert.assertEquals("This is a sample page", TestBase.driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

        //İlk Tab'a geri dön
        TestBase.driver.switchTo().window(windowHandle1);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
