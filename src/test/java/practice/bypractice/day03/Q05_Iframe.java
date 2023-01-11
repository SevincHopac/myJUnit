package practice.bypractice.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Q05_Iframe extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement accept = driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(accept);
        driver.findElement(By.xpath("//*[text()='Tümünü Kabul Et']")).click();

        String webHandle1 = driver.getWindowHandle();

        //    2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        System.out.println(iframes.size());

        //    3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtube = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(youtube);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        Thread.sleep(4000);

        //    4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //    5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) click

        WebElement iframe2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        Set<String> webHandles = driver.getWindowHandles();
        for (String w: webHandles){
            if (!w.equals(webHandle1)){
                driver.switchTo().window(w);
                break;
            }
        }

        driver.findElement(By.xpath("(//*[@class='fc-button-label'])[1]")).click();
    }
}
