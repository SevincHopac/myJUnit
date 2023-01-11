package practice.byslack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q10_ShadowRoot extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //1-https://books-pwakit.appspot.com/ adresine gidin.
        TestBase.driver.get("https://books-pwakit.appspot.com/");

        //2-"BOOKS" başlığının görünür olduğunu doğrulayın

        // Assert.assertTrue(driver.findElement(By.xpath("//*[text()='BOOKS']")).isDisplayed());

        SearchContext shadow1 = TestBase.driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        WebElement book = shadow1.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(book.isDisplayed());

        //3-Arama çubuğunda "Selenium" u aratın.

        SearchContext shadow2 = TestBase.driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        shadow2.findElement(By.cssSelector("#input")).sendKeys("Selenium", Keys.ENTER);

        //4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

        SearchContext shadow3 = TestBase.driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        SearchContext shadow4 = shadow3.findElement(By.cssSelector("book-explore[class='_page']")).getShadowRoot();
        SearchContext shadow5 = shadow4.findElement(By.cssSelector("section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)")).getShadowRoot();
        WebElement product1 = shadow5.findElement(By.cssSelector(".title"));
        Assert.assertTrue(product1.getText().contains("Selenium"));
    }
}
