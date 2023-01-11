package practice.bypractice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Q03_Dropdown_SelectBy {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ////Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectByIndexTest() {

        ////1.Create method selectByIndexTest and Select Option 1 using index
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDownElement = new Select(selectElement);
        dropDownElement.selectByIndex(1);
    }

    @Test
    public void selectByValueTest() {
        ////2.Create method selectByValueTest Select Option 2 by value
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDownElement = new Select(selectElement);
        dropDownElement.selectByValue("2");
    }

    @Test
    public void selectByVisibleTextTest() {
        ////3.Create method selectByVisibleTextTest Select Option 1 value by visible text
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDownElement = new Select(selectElement);
        dropDownElement.selectByVisibleText("Option 1");
    }

    @Test
    public void printAllTest() {
        ////4.Create method printAllTest Print all dropdown value
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDownElement = new Select(selectElement);
        List<WebElement> options = dropDownElement.getOptions();
        List<String> list = new ArrayList<>();

        for (WebElement w : options) {
            System.out.println(w.getText());
            list.add(w.getText());
        }

        ////5. Verify the dropdown has Option 2 text

        Assert.assertTrue(list.contains("Option 2"));
    }

    @Test
    public void printFirstSelectedOptionTest() {
        ////6.Create method printFirstSelectedOptionTest Print first selected option
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dropDownElement = new Select(selectElement);
        String selected = dropDownElement.getFirstSelectedOption().getText();
        System.out.println(selected);

        ////7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        List<WebElement> options = dropDownElement.getOptions();

        System.out.println(options.size()==3 ? "Dropdown Size 3" : "Expected Is Not Equal Actual");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
