package day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Random;

public class _03_DropDownRe extends TestBase {

    @Test
    public void test() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dropdownElement = driver.findElement(By.id("year"));
        Select select = new Select(dropdownElement);
        WebElement result = selectRandomTextFromDropdown(select);
        System.out.println(result.getText());
    }

    public static WebElement selectRandomTextFromDropdown(Select select) {

        Random random = new Random();

        List<WebElement> weblist = select.getOptions();

        int optionIndex = 1 + random.nextInt(weblist.size() - 1);

        select.selectByIndex(optionIndex);

        return select.getFirstSelectedOption();
    }
}
