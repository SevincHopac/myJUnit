package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class _02_WebTabels extends TestBase {

    ///table[@id='table1']//thead//tr//th//span[text()='Email']


    //https://the-internet.herokuapp.com/tables 
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin



    @Test
    public void table1Print() {
        driver.get("https://the-internet.herokuapp.com/tables");

        // print table 1

        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 DATA");
        System.out.println(table1);

        // ayri ayri data

        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td"));

 //       System.out.println(getElementsText1(elements));

        for (WebElement w : elements) {
            System.out.println(w.getText());
        }
    }


    // slackten
    public static List<String> getElementsText1(List<WebElement> list) {
        List<String> elementText = new ArrayList<>();
        for (WebElement w : list) {
            elementText.add(w.getText());
        }
        return elementText;
    }


    @Test
    public void row3PrintTest() {
        //    Task 2 : 3. Row’ datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Elements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Elements.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void lastRowPrintTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> lastRowElements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        lastRowElements.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void column5PrintTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> lastRowElements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        lastRowElements.forEach(t -> System.out.println(t.getText()));
    }

    @Test
    public void methodTest() {
        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        //Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin
        driver.get("https://the-internet.herokuapp.com/tables");
        printData(2, 2, 3);
    }

    private void printData(int tableNumber, int row, int column) {
        String xpath = "//table[@id='table" + tableNumber + "']//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement element = driver.findElement(By.xpath(xpath));
        System.out.println(element.getText());
    }

}
