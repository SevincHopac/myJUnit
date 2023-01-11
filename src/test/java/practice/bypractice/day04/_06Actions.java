package practice.bypractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class _06Actions extends TestBase {

    @Test
    public void test() {

        //https://demoqa.com/ url'ine gidin.

        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap

        WebElement kutu = driver.findElement(By.xpath("(//*[@class='card-up'])[6]"));

        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");

        Actions actions = new Actions(driver);

        //actions.moveToElement(kutu).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();


        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        String text = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']")).getText();
        Assert.assertEquals("Please select an item from left to start practice.",text);

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.id("tabButton"));

        Assert.assertTrue(newTab.isDisplayed());

        //New Tab butonuna click yap
        newTab.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));

        WebElement text1 = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(text1.isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(allWindow.get(0));

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
