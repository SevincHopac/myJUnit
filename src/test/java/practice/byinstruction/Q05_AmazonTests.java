package practice.byinstruction;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Q05_AmazonTests extends TestBase {

    /*    @Test
    public void test1() {

        //Test01 :  1- amazon gidin
        driver.get("https://amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement element = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(element);
        List<WebElement> optionsList =  select.getOptions();

        optionsList.stream().forEach(t-> System.out.println(t.getText()+ " "));


        //dropdown menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals(28, optionsList.size());

    }*/

    @Test
    @Ignore
    public void test2() {

        driver.get("https://amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement element = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(element);
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String text = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(text.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        waitFor(3);
        driver.findElement(By.xpath("(//img[@data-image-latency=\"s-product-image\"])[5]")).click();

        waitFor(3);
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        String title = driver.getTitle();
        System.out.println("title = " + title);

        String price = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println("price = " + price);

        driver.findElement(By.id("add-to-cart-button")).click();

    }
    @Test
    public void test03() {

        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //dropdown’dan bebek bölümüne secin
        WebElement element = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(element);
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        String text = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String[] result = text.split(" ");
        System.out.println("result: "+result[2]);

        //sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(text.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String productTitle= driver.findElement(By.id("productTitle")).getText();
        System.out.println("productTitle = " + productTitle);

        WebElement element1 = driver.findElement(By.id("amazonGlobal_feature_div"));
        WebElement element2 = driver.findElement(with(By.id("amazonGlobal_feature_div")).above(element1));
        System.out.println("element2.getText() = " + element2.getText());

        // Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    }

}
