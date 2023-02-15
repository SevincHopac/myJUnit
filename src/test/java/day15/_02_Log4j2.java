package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class _02_Log4j2 extends TestBase {

    private static Logger logger = LogManager.getLogger(_02_Log4j2.class.getName());
    @Test
    public void table1Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        logger.info("Table 1 Verileri");
    /*    System.out.println("TABLE 1 DATA");
        System.out.println(table1);*/
    }
}
