package practice.slackPractice;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C08_Dropdown extends TestBase {

    @Test
    public void test() {

        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        TestBase.driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        Assert.assertTrue(TestBase.driver.findElement(By.xpath("//legend[normalize-space()='Dropdown Example']")).isDisplayed());

        //3-Option3 ü seçin.
        WebElement dropdown = TestBase.driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option3");

        //4-Option3 ün seçili olduğunu doğrulayın.
        String actualSelect = select.getFirstSelectedOption().getText();
        String expected = "Option3";
        Assert.assertEquals(expected,actualSelect);

    }
}
