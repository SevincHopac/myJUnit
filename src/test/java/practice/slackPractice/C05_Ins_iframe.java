package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_Ins_iframe extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());

        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String title = driver.findElement(By.xpath("//h3[normalize-space()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(title.contains("Editor"));

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).clear();

        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        driver.findElement(By.xpath("//body//p")).sendKeys("iframein icindeyim");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();

        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        String footerText = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Elemental Selenium"));

    }
}
