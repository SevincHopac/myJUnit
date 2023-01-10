package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandle() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        Assert.assertEquals("Opening a new window",text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        waitFor(3);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);
        Assert.assertEquals("New Window",driver.getTitle());
    }
}
