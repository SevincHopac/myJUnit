package practice.byslack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q11_Iframe extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        TestBase.driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        TestBase.driver.switchTo().frame("emoojis");
        TestBase.driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        Thread.sleep(3000);

        // ikinci emoji altındaki tüm öğelere tıklayın

        List<WebElement> emoojisElement = TestBase.driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        emoojisElement.stream().forEach(t->t.click());
        Thread.sleep(3000);

        // ana iframe'e geri dön
        TestBase.driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // uygula butonuna tıklayın

        TestBase.driver.findElement(By.xpath("(//input[@class='mdl-textfield__input'])[1]")).sendKeys(
                "HelloWorld", Keys.TAB,
                "World", Keys.TAB,
                "Tree",Keys.TAB,
                "Water",Keys.TAB,
                "Run",Keys.TAB,
                "Forest",Keys.TAB,
                "Rock",Keys.TAB,
                "xx",Keys.TAB,
                "a",Keys.TAB,
                "qw",Keys.TAB,
                "Hi",Keys.TAB,Keys.ENTER);
        Thread.sleep(3000);
    }

}
