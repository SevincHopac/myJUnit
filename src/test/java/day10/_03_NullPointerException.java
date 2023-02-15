package day10;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

import java.util.List;

public class _03_NullPointerException {
    WebDriver driver;
    Faker faker;

    @Test
    public void nullPointerExceptionTest() {
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException
    }


    @Test
    public void nullPointerExceptionTest2() {
//        faker=new Faker();
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }


    @Test
    public void name() {
        String ptr = null;
        System.out.println(ptr.length());
    }




  // java da ki version
    public static void main(String args[]) {
        String myString = null;
        printLength(myString);
    }


    private static void printLength(String str) {
        System.out.println(str.length());
    }


}
