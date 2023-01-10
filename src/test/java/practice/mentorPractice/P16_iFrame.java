package practice.mentorPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P16_iFrame extends TestBase {
    @Test
    public void test() {

      // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String window1 = driver.getWindowHandle();

        //An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        driver.switchTo().defaultContent();

      // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        WebElement footer = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(footer.isDisplayed());

      // Elemental Selenium linkine tıklayın
        footer.click();

      // Açılan sayfada sayfa başlığını yazdırınız

        List<String> windowsHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHandles.get(1));

      // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement souceLabs = driver.findElement(By.xpath("//*[@rel='noopener noreferrer']"));
        Assert.assertTrue(souceLabs.isDisplayed());

        String window2 = driver.getWindowHandle();


      // Source labs linkine tıklayın
        souceLabs.click();

      // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(window1);

      // ilk sekmeyi kapatalım
        driver.close();
    }
}
