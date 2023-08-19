import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class JSexecutor {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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


        WebElement entriesBox = driver.findElement(By.id("zone2-entries"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entriesBox);


        String actualText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", entriesBox);


        String expectedText = "0 Entries";
        Assert.assertEquals(actualText, expectedText, "Text is not validated");
        System.out.println("Text is validated");
    }







}


