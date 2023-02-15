package day05;

import com.mongodb.client.model.geojson.LineString;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _01_WindowHandle extends TestBase {

    @Test
    public void test() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String windowHandle1 = driver.getWindowHandle();


        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String title1 = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        Assert.assertTrue(title1.contains("Opening a new window"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet",driver.getTitle());

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> allWindowaHandles = driver.getWindowHandles();
       // List<String> allWindowaHandles = new ArrayList<>(driver.getWindowHandles());

        for (String w: allWindowaHandles){
            if (!w.equals(windowHandle1)) {
                driver.switchTo().window(w);
                break;
            }
        }

        //allWindowHandles.stream().skip(1).limit(1).forEach(t-> driver.switchTo().window(t));
        //driver.switchTo().window(allWindowHandles.stream().filter(t-> !t.contains(ilk)).findFirst().get());

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText());

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın
        driver.switchTo().window(windowHandle1);
        Assert.assertEquals("The Internet",driver.getTitle());


    }
}
