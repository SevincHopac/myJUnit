package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class _01_FileUploader extends TestBase {

    @Test
    public void fileUploadTest() {

        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String path = System.getProperty("user.home")+"\\OneDrive\\Desktop\\logo (1).jpeg";
        chooseFileButton.sendKeys(path);
        waitFor(5);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String actualText= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",actualText);
    }
}
