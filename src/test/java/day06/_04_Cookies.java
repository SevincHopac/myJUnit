package day06;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class _04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {

        //Amazona git
        driver.get("https://amazon.com");
        waitFor(3);

        //1.toplam cookie sayisini bul

        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();
        System.out.println("numberOfCookies = " + numberOfCookies);


        //3. Bir Cookie yi ismiyle bul
        System.out.println("Cookie yi isimle cagir : " +driver.manage().getCookieNamed("i18n-prefs"));

        //  allCookies.stream().forEach(t-> System.out.print(t.getName()+""));

        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie : " +eachCookie);
            System.out.println("Cookie's Name : " + eachCookie.getName());
        }


        //4. Yeni bir cookie ekle
        Cookie favCookie = new Cookie("myChocolate","Bitter");
        driver.manage().addCookie(favCookie);
        waitFor(3);
        int newNumberOfCookie=driver.manage().getCookies().size();
        System.out.println("newNumberOfCookie = " + newNumberOfCookie);

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();

        waitFor(3);

        System.out.println("tum cookies silindi : "+driver.manage().getCookies().size());


    }
}
