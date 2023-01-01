package day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _05_IFrame extends TestBase {

    //User Story:
    //https://testcenter.techproeducation.com/index.php?page=iframe
    //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
    //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
    //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
    //Collapse


    @Test
    public void iFrameTest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String text = driver.findElement(By.xpath("//p[normalize-space()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(text.contains("black border"));

        driver.switchTo().frame(0); // because first iFrame
        String head = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        Assert.assertTrue(head.contains("Applications lists"));

        driver.switchTo().defaultContent();
        // defaultContent()  --> direct Homepage
        //  parentFrame      --> parent Frame
        // ( switch) edilir

        //defaultContent takes us to main page directly
        //parentFrame takes us to upper frame

        String actualFooterText = driver.findElement(By.xpath("//footer[@class='blog-footer']//p[1]")).getText();
        Assert.assertTrue(actualFooterText.contains("Povered By"));


    }
}
