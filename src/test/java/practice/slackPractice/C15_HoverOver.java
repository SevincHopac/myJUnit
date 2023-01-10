package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C15_HoverOver extends TestBase {

    @Test
    public void hoverOverTest() {

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@class='dropbtn']"));
        actions.moveToElement(element).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();

        //4. Popup mesajini yazdirin
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        //5. Popup'i tamam diyerek kapatin
        alert.accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement element1 = driver.findElement(By.id("click-box"));
        actions.clickAndHold(element1).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String text = element1.getText();
        System.out.println("text = " + text);

        //8. "Double click me" butonunu cift tiklayin
        WebElement element2 = driver.findElement(By.id("double-click"));
        actions.doubleClick(element2).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement element3 = driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        Assert.assertTrue(element3.isDisplayed());

    }
}
