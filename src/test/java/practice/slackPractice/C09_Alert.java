package practice.slackPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C09_Alert extends TestBase {

    @Test
    public void test() {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'

        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());
    }
}
