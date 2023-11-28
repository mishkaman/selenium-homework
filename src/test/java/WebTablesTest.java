import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void printHondaCarPrice() throws InterruptedException {


        driver.get("http://techcanvass.com/Examples/webtable.html");

        WebElement htmlTable = driver.findElement(By.xpath("//table[@id='t01']"));

        List<WebElement> rows = htmlTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            if (!columns.isEmpty() && columns.get(0).getText().equals("Honda")) {
                System.out.println("Honda's price: " + columns.get(2).getText());
            }
        }

        Thread.sleep(3000);

        driver.quit();
    }
}
