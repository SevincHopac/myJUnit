package day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _01_Actions5 extends TestBase {

    @Test
    public void keyboardActions() {

        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);

        actions.
                keyDown(searchBox,Keys.SHIFT).
                sendKeys("iPhone X fiyatlari").
                keyUp(searchBox,Keys.SHIFT).
                sendKeys(" cok pahali!" + Keys.ENTER).
                build().
                perform();
    }
}
