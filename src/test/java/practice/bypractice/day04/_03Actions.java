package practice.bypractice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _03Actions extends TestBase {

    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */

    @Test
    public void test() {

        //    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement element = driver.findElement(By.id("div2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitFor(3);

        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement element1 = driver.findElement(By.name("dblClick"));
        actions.doubleClick(element1).build().perform();

        String text = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!",text);

        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source,target).perform();

        String text1 = target.getText();
        Assert.assertEquals("Dropped!",text1);
    }
}
