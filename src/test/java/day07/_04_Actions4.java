package day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class _04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); // tek iframe var

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();


    }

    @Test
    public void clickAndHoldTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); // tek iframe var

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).
                moveToElement(target).
                release().    // birak
                build().
                perform();
    }

    @Test
    public void moveByOffSetTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0); // tek iframe var

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.
                clickAndHold(source).
                moveByOffset(430,30).
                release().
                build().
                perform();

    }
}
