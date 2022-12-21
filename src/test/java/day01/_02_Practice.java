package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine “username” yazdirin
        WebElement loginElement = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginElement.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement passElement = driver.findElement(By.xpath("//input[@id='user_password']"));
        passElement.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[normalize-space()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amauntElement = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amauntElement.sendKeys("2000");
      //  Thread.sleep(3000);

        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
       // Thread.sleep(3000);

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement textElement = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String actualResultText = textElement.getText();
        String expectedResultText = "The payment was successfully submitted.";

        if (actualResultText.equals(expectedResultText)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        //2.way
/*
        if (textElement.isDisplayed()) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        */

        driver.close();
    }
}
