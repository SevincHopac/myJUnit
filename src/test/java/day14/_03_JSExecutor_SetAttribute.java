package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class _03_JSExecutor_SetAttribute extends TestBase {

    @Test
    public void setAttributeTest() {

        driver.get("https://www.techproeducation.com");
        waitFor(3);

        WebElement clickButton = driver.findElement(By.xpath("//input[@type='search']"));
        setValueByJS(clickButton,"QA");

    }
}
