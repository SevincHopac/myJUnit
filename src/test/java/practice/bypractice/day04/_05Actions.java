package practice.bypractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class _05Actions extends TestBase {

    @Test
    public void test() {


        //        -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[text()='Fleet']"));
        actions.moveToElement(element).perform();
        element.click();

        //        -Sayfa başlığının Fleet içerdiğini test edelim

        List<String> allHandle = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allHandle.get(1));
        Assert.assertTrue(driver.getTitle().contains("Flett"));

    }
}
