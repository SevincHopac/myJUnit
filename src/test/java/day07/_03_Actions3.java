package day07;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);
/*        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();*/

       actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        waitFor(4);
        actions.sendKeys(Keys.DOWN);

     // ARROW_DOWN  , PAGE_DOWN dan daha az asagi iner

        //Sonra sayfanın üstüne doğru gidelim

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();


    }
}
