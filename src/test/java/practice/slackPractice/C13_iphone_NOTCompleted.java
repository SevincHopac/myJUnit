package practice.slackPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C13_iphone_NOTCompleted extends TestBase {

    @Test
    public void test() {

        //Go to 'https://www.amazon.com.tr/'
        TestBase.driver.get("https://amazon.com.tr/");

        //Search iPhone13 512
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(result.isDisplayed());

        //Click iPhone13 at the top of the list
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));

        List<String> names = products.stream().map(WebElement::getText).filter(t -> t.contains("iPhone 13 (512 GB)")).collect(Collectors.toList());
        Assert.assertTrue(names.size() > 0);

        waitFor(3);
        driver.findElement(By.id("sp-cc-accept")).click();

        driver.findElement(By.xpath("(//*[@class='s-color-swatch-inner-circle-border'])[5]")).click();
        waitFor(3);

        addToCartSize();
    }


    public void addToCartSize(){

        List<WebElement> list = driver.findElements(By.xpath("//*[@data-csa-c-id='qukkfs-uuk6vp-vo1797-h5g477']"));

        for (int i = 0; i < list.size(); i++) {
            driver.findElement(By.id("size_name_"+i)).click();
            waitFor(3);
            driver.findElement(By.id("add-to-cart-button")).click();
            waitFor(3);
            driver.findElement(By.id("attach-close_sideSheet-link")).click();
            waitFor(3);
        }
    }
}
