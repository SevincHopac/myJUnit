package practice.bypractice.day04;

import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _04BigSmallLetter extends TestBase {

    @Test
    public void test() {

        driver.get("https://google.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        driver.findElement(By.id("W0wltc")).click();

        WebElement element = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        element.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.ENTER);

    }
}
