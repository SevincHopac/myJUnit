package practice.byslack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Q03_SauceDemoShopping extends TestBase {


    @Test
    public void test() {

        //1. "https://www.saucedemo.com" Adresine gidin
        TestBase.driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin
        //4. Login tusuna basin
        TestBase.driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.ENTER);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String name = TestBase.driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        TestBase.driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
        TestBase.driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        TestBase.driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String result = TestBase.driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        System.out.println(result);
        Assert.assertEquals("1",result);
    }
}
