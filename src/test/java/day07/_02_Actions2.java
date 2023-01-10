package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _02_Actions2 extends TestBase {

    @Test
    public void actionsTest() {

 /*
            MANUAL:
            1. Amazon home sayfasina git
            2. Account & list e uzerinde bekle
            3.Acilan pencerede Account linkine tokla
            4.Acilan sayfanin Title inin, your Account oldugunu dogrula
 */

        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("(//*[@class='nav-link nav-item'])[4]")).click();
        String text = driver.findElement(By.xpath("//*[@class='a-row a-spacing-base']")).getText();
        Assert.assertEquals("Your Account",text);
    }
}
