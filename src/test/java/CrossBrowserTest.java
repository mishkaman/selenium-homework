import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.List;

public class CrossBrowserTest {
    private WebDriver driver;


    @BeforeClass
    @Parameters("browser")
    public void setupDriver(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("fireFox");
        }
        else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("chrome");
        }
    }


    @Test
    public void smth3() throws InterruptedException {

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        driver.manage().window().maximize();

        List<WebElement> liList = driver.findElements(By.tagName("ul")).get(0).findElements(By.tagName("li"));
        for (WebElement li : liList) {
            if (li.getText().contains("Practice magic")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(li).perform();

                Thread.sleep(2000);

                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].remove();", li);

                break;
            }
        }


        ///////////////////////////////////////////////////////////





        driver.get("http://webdriveruniversity.com/Scrolling/index.html");

        Thread.sleep(3000);

        WebElement entriesBox = driver.findElement(By.id("zone2-entries"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entriesBox);


        String actualText = entriesBox.getText();
        String expectedText = "0 Entries";

        assert actualText.equals(expectedText) : "Text is not validated";
        System.out.println("Text is validated");

        Thread.sleep(2000);


    }

    @AfterTest
    public void leave(){
        driver.quit();
    }







}



