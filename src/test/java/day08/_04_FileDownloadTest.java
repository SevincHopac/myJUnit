package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class _04_FileDownloadTest extends TestBase {


    @Test
    public void fileDownload() {

        //https://testcenter.techproeducation.com/index.php?page=file-download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);


        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home")+"\\ indirilenler\\b10 all test cases.docx";

        boolean isDownload = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownload);
    }
}
