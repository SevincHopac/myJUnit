package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class TestBase {

    //    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
    //    TestBase testBase = new TestBase(); -> YAPILAMAZ
    //    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
    //    driver objesini olustur. Driver ya public yada protected olmali.
    //    Sebepi child classlarda gorulebilir olmasi


    protected static WebDriver driver;

    //    setUp
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();                                // Hard Wait  -Java
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // If necessary Wait - Selenium
    }

    //    tearDown
/*    @After
    public void tearDown() {
        waitFor(4);
        driver.quit();
    }*/




    public static WebElement getWebElById(String locator) {
        return driver.findElement(By.id(locator));
    }


//    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")


    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }


    //    windowNumber sıfır (0)'dan başlıyor.
    //    index numarasini parametre olarak alir
    //    ve o indexli pencerece gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    // Emin Z.
    public static void switchToWindow_URL(String url) {
        for (String w : driver.getWindowHandles()) {
            driver.switchTo().window(w);
            if (driver.getCurrentUrl().equals(url)) return;
        }
    }

    //  -----------------ACTIONS---------------------------------------------------------
    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();
    }

    /*   HARD WAIT:         ------------------------------------------------
      @param : second
   */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    DYNAMIC SELENIUM WAITS:                 -----------------------------------------------------------------------


//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }


    //   SCREENSHOTS ----------------------------------------------------------------------------------------------------
    public void takeScreenShotOfPage() {

        //        1. Take screenshot
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        //       2. Save screenshot
        //        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyy.MM.dd--hh.mm.ss").format(new Date());


        //        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //    SCREENSHOT
//    @params: WebElement
//    takes screenshot
    public void takeScreenshotOfElement(WebElement element) {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot path

        String currentTime = new SimpleDateFormat("yyyy.MM.dd--hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "/image.png";      //C:\Users\sevin\IdeaProjects\Maven_JUnit\test-output
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*-------------------------------------------------------------------------------------------------------------------
    Javascript Executer


    @param : webelement
    Accepts a web element and scrolls into that element

    We can need to scroll for capturing the screenshots property
    We may need to scroll to specific elements with js executor
    because some elements may not LOAD properly
    unless we scroll to that elements
     */
    public void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
    scroll the page all the down
     */
    public void scrollDownByJS() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /*
       scroll the page all the upp
        */
    public void scrollUpByJS() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }


    /*
    click on an element
    @param WebElement
    Normally we use element.click() method in Selenium
    When there is an issue with click()-hidden, different UI,...
    Then we can use javascript click that works better
     */

    public void clickByJS(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /*
    @param : WebElement,String
    Types the string in the WebElement
    Normally : element.sendKeys("text") to type in an input
    ALTERNATIVELY we can use js executer to type in an input
    "arguments[0].setAttribute('value','admin123');  -> SAME AS element.sendKeys("admin123");


INTERVIEW QUESTION : What are the selenium methods that you use to type in an input?
-sendKeys()
-with javascript executer we can change the value of the input


     */
    public void setValueByJS(WebElement element, String text) {    // tagi <input> olanlarin icin gecerli  // wie sendKeys()
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }




    /*
    @param : Id of the element
     */
    public void getValueByJS(String idOfElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String value = javascriptExecutor.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);

//        NOT: document.querySelector("p").value; -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR

        /*
    How you can get the value of an input box?
    We can js executer
    How?
    I can get the element using js executor, and get the value of the element.
    For example, I can get the element by id, and use value attribute to get the value of in an input
    I have to do this,cause getText in this case does not return the text in an input
     */
    }


    //Changes the changeBackgroundColorByJS of an element. Params: WebElement element, String color. NOT COMMON

    public void changeBackgroundColorByJS(WebElement element, String color) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
    }

    // NOT COMMON
    // highlight

    public void addBorderWithJS(WebElement element, String borderStyle) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='" + borderStyle + "'", element);
    }


    //    scrollToElement  // canH.-------------------------------------------
    public static void scrollToElement(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    public static void JSExecutorSelectVisibleText(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void JSExecutorSelectIndex(WebElement element, int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", element);
        Select select = new Select(element);
        select.selectByIndex(index);
    }


}
