package day11;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _02_Screenshot2 extends TestBase {

    @Test
    public void screenshotOfSpecificElements() throws IOException {

        //Techpro education a git
        driver.get("https://techproeducation.com");


        //Sosyal medya elemanlarını goruntusunu al

        WebElement socialMediaIcons = driver.findElement(By.xpath("//*[@data-id='d7545f2']"));
        File image = socialMediaIcons.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyy.MM.dd--hh.mm.ss").format(new Date());


        //        Path of screenshot save folder               folder / folder    /file name

        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
//------------------------------------------------------------------------------------------------------------------

        WebElement logo = getWebElById("NDU1Ojc5MQ==-1");
        takeScreenshotOfElement(logo);

    }
}
