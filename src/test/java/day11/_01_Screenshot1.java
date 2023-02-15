package day11;

import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _01_Screenshot1 extends TestBase {

    @Test
    public void fullPageScreenshotTest() throws IOException {

        // -Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");

        //      1. Ekran goruntusunu getScreenshotAs method'u ile alip File olarak olusturalim
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //      2. Almis oldugum ekran goruntusunu belirledigim bir PATH'e kaydet.
        String currentDate = new SimpleDateFormat("yyyy.MM.dd--hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/"+ currentDate +"image.png";
        File target = new File(path);

        //      3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(screenshot,target);


        // -“QA” aramasi yap
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
        searchBox.sendKeys("QA"+ Keys.ENTER);

        waitFor(3);


//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));
        takeScreenShotOfPage();
    }
}
