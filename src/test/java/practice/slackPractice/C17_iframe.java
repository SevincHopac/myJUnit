package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C17_iframe extends TestBase {


    @Test
    public void test() {

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        waitFor(3);

        //videoyu calistirdiginizi test edin
/*
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        Assert.assertFalse(element.isDisplayed());
*/

        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());
    }
}
