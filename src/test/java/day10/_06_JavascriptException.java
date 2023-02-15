package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class _06_JavascriptException extends TestBase {

    @Test
    public void name() {

            driver.get("https://www.priceline.com/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String text = js.executeScript("return document.getElementById('hotelDates').value").toString();
            System.out.println("Kutudaki value: " + text);

    }

    @Test
    public void name1() {
        driver.get("https://www.priceline.com/");  //
        WebElement box = driver.findElement(By.xpath("/html//input[@id='endLocation-typeahead-downshift-container-input']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        waitFor(2);
        js.executeScript("arguments[0].setAttribute('value','QA')",box);  // javascript kodunda yanlis yazim olursa // seleniumdan
    }

}
