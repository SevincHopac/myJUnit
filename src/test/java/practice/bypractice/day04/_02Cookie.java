package practice.bypractice.day04;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class _02Cookie extends TestBase {

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test() {

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        waitFor(5);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie w : cookies){
            System.out.println(w.getName()+" : " +w.getValue());
        }

        cookies.stream().forEach(t-> System.out.println(t.getName() +" "+ t.getValue()));

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456");
        driver.manage().addCookie(myCookie);

        System.out.println("------------------------------");
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());

        cookies.stream().forEach(t-> System.out.println(t.getName()+" "+t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();

    }
}
