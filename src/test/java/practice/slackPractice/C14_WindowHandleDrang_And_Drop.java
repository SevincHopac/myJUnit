package practice.slackPractice;

import org.bouncycastle.operator.AADProcessor;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C14_WindowHandleDrang_And_Drop extends TestBase {

    WebElement city, country;
    @Test
    public void dragAndDropTest() {

        Actions actions = new Actions(driver);

        // #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        TestBase.driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // #Fill in capitals by country
        WebElement cities = driver.findElement(By.id("dropContent"));
        String[] arrCity = cities.getText().split("\n");

        for (int i = 1; i <= arrCity.length; i++) {
            city = driver.findElement(By.id("box" + i));
            country = driver.findElement(By.id("box" + (100+i)));
            actions.dragAndDrop(city, country).perform();
            waitFor(3);
        }
    }
}
