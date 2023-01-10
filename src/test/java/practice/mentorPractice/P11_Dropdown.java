package practice.mentorPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P11_Dropdown extends TestBase {

    @Test
    public void test01() {
        //navigate to amazon
        driver.get("https://amazon.com");

        // dropdown menu print
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }

        // select baby
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);

    }
}
