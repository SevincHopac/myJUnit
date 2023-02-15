package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class _02_JSExecutorClick extends TestBase {


    @Test
    public void clickByJSTest() {

        //        Techpro education ana sayfasina git
        //        LMS LOGIN elementine tikla
        //        Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et


        driver.get("https://www.techproeducation.com");
        waitFor(3);

        WebElement clickButton = driver.findElement(By.linkText("LMS LOGIN"));
        clickByJS(clickButton);
    }
}
