package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _01_Actions1 extends TestBase {

    @Test
    public void actions1() {

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",text);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

        driver.quit();
   //     driver.navigate().refresh();
    }
}
