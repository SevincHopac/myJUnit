package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C04 extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        //   Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        //    Then new butonuna basar
        driver.findElement(By.xpath("//span[normalize-space()='New']")).click();

        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        //    When Create tusuna basar
        driver.findElement(By.xpath("//input[@id='DTE_Field_first_name']")).sendKeys("Sevinc", Keys.TAB,"Hanks",Keys.TAB,
                "Mana",Keys.TAB,"Manhat",Keys.TAB,"exten",Keys.TAB,"2022-12-12",Keys.ENTER,Keys.TAB,"30000",Keys.TAB,Keys.ENTER);

        //    Then Kullanıcının eklendiğini doğrular.

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Sevinc");

        String searchResult = driver.findElement(By.xpath("//td[2]")).getText();
        System.out.println(searchResult);
        Assert.assertTrue(searchResult.contains("Sevinc"));

        //    And Eklediği kullanıcı kaydını siler
        //    Then Kullanıcinin silindiğini doğrular.

        driver.findElement(By.xpath("//td[@class='sorting_1']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
        driver.findElement(By.xpath("//button[@class='btn']")).click();

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Sevinc");

        String actual = driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();
        String expected = "No matching records found";

        Assert.assertEquals(expected,actual);


    }
}
