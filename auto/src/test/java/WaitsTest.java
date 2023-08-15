import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {
    private WebDriver driver;

    @BeforeClass
    public void setupdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void writeWaitsTest() {
        driver.get("https://demoqa.com/progress-bar");

        WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("progressBar"), "100%"));

        System.out.println("100%");

        driver.quit();







    }
}
