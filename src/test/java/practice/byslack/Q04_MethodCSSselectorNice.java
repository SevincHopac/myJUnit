package practice.byslack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04_MethodCSSselectorNice extends TestBase {

    @Test
    public void test() {

        //      Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        TestBase.driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //      click on Phones & PDAs
        TestBase.driver.findElement(By.xpath("//a[normalize-space()='Phones & PDAs']")).click();

        //      get the brandName of phones
        System.out.println(getBrandNames());

        //      click on add to button for all elements
        addButtonClickAllElements();

        //      click on black total added cart button
        TestBase.driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();


        //      get the names of list from the cart
        System.out.println(getCartList());

        //      compare the names from displaying list and cart list
        compareTwoList();

    }

    private void compareTwoList() {
        System.out.println(getCartList().equals(getBrandNames()));
    }

    private List<String> getCartList() {
        List<WebElement> names = TestBase.driver.findElements(By.cssSelector("tr>td.text-left>a"));  //-----> css selector !!
        List<String> phoneNames = new ArrayList<>();
        names.forEach(t->phoneNames.add(t.getText()));
        Collections.sort(phoneNames);
        return phoneNames;
    }

    private void addButtonClickAllElements() {
        List<WebElement> list = TestBase.driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        list.forEach(t->t.click());
    }

    private List<String> getBrandNames() {

        List<WebElement> brandName = TestBase.driver.findElements(By.xpath("//h4"));
        List<String> brandNames = new ArrayList<>();
        for (WebElement w: brandName){
            brandNames.add(w.getText());
        }
        Collections.sort(brandNames);
        return brandNames;
    }

}
