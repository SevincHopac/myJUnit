package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class _03_BasicAuthentication extends TestBase {

    @Test
    public void basicAuthenticationTest() {

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //asagidaki yontem ve test datalarini kullanarak authentication'i yapin


        //URL              : https://username:password@URL
        //Username    : admin
        //password    : admin
        //Basarili sekilde sayfaya girin ve 'Congratulations!' yasizini doğrulayın

        //        AUTHENTICATION URL IMIZ: https://admin:admin@the-internet.herokuapp.com/basic_auth
        //                                 https://the-internet.herokuapp.com/basic_auth


        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        waitFor(3);
        String actualText = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
        Assert.assertTrue(actualText.contains("Congratulations!"));

    }
}
