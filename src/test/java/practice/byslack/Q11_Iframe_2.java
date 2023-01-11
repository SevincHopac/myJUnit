package practice.byslack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q11_Iframe_2 extends TestBase {

    @Test
    public void test() {

        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        TestBase.driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        int size = TestBase.driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total iframes : " + size);

        WebElement iframeElement = TestBase.driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        TestBase.driver.switchTo().frame(iframeElement);
        TestBase.driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> elements = TestBase.driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        elements.stream().forEach(t->t.click());

        // ana iframe'e geri dön
        TestBase.driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<String> inputs = new ArrayList<>(Arrays.asList("Hello World!", "Java", "Turkey" ,"Master", "Java ile Hayat Cok Guzel",
                "İstanbul", "Adam" ,"58" , "34", "63", "63"));

        List<WebElement> forum = TestBase.driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        for (int i = 0; i < inputs.size(); i++) {
            forum.get(i).sendKeys(inputs.get(i));
        }


        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();

    }
}
