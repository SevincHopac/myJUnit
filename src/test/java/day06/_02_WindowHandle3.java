package day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class _02_WindowHandle3 extends TestBase {

    @Test
    public void windowHandle() {

        //1. TechPro education sayfasinin title'inin "Techpro Education" metnini icerdigini test edin.
        driver.get("https://techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();

        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        driver.switchTo().window(techProHandle);
    }
}
