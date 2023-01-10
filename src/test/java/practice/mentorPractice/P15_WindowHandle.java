package practice.mentorPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P15_WindowHandle extends TestBase {


    @Test
    public void test() throws InterruptedException {

        //    - https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String windowHandle1 = driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement oynatElementIframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(oynatElementIframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        Thread.sleep(3000);

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        String windowHandle2 = driver.getWindowHandle();

        //    - iphone aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String resultText = driver.findElement(By.xpath("//span[normalize-space()='1-16 of over 1,000 results for']")).getText();
        String[] arr = resultText.split(" ");
        System.out.println("Search result = "+arr[3]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(windowHandle1);
        System.out.println(driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım
        driver.switchTo().window(windowHandle2);
        driver.close();
    }
}
